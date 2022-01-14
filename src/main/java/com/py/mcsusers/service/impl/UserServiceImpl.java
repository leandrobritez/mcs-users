package com.py.mcsusers.service.impl;

import com.py.mcsusers.converter.UserConverter;
import com.py.mcsusers.dto.UserDto;
import com.py.mcsusers.model.response.User;
import com.py.mcsusers.repository.UserRepository;
import com.py.mcsusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private Integer id;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public User getUserByCode(Integer id) {
        User user = null;
        try {

            Optional<UserDto> userDtoOptional = userRepository.getUserByCode(id);
            if (userDtoOptional.isPresent()) {
                user = userConverter.dtoToModel(userDtoOptional.get());

            } else {
                System.out.print("Entra en null de service");
                return null;
            }


        } catch (Exception e){
            System.out.print(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> getUserAll() {
        List<User> listUser = new ArrayList<>();
        List<UserDto> listUserDto = userRepository.getUserAll();
        if(listUserDto.isEmpty()){
            return null;
        } else {
            for(UserDto userDto : listUserDto){
                listUser.add(userConverter.dtoToModel(userDto));
            }
            return listUser;
        }
    }

    @Override
    public List<User> getUserByList(List<Integer> listId) {
        List<User> listUser = new ArrayList<>();
        List<UserDto> listUserDto = userRepository.getUserByList(listId);
        if(listUserDto.isEmpty()){
            return null;
        } else {
            for(UserDto userDto : listUserDto){
                listUser.add(userConverter.dtoToModel(userDto));
            }
            return listUser;
        }
    }
}
