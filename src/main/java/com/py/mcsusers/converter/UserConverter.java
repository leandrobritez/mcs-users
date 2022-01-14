package com.py.mcsusers.converter;

import com.py.mcsusers.dto.UserDto;
import com.py.mcsusers.model.response.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User dtoToModel(UserDto userDto){
        User user = new User();
        user.setUserCode(userDto.getUserCode());
        user.setUserName(userDto.getUserName());
        user.setUserLastName(userDto.getUserLastName());
        return user;
    }
}
