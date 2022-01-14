package com.py.mcsusers.controller.impl;

import com.py.mcsusers.controller.UserController;
import com.py.mcsusers.model.response.User;
import com.py.mcsusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity getUserByCode(Integer id) {
        User user = userService.getUserByCode(id);
        if (user == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getUserAll() {
        List<User> listUser = userService.getUserAll();
        if(listUser.isEmpty()){
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listUser,HttpStatus.OK);

    }

    @Override
    public ResponseEntity getUserByList(List<Integer> listId) {
        List<User> listUser = userService.getUserByList(listId);
        if(listUser.isEmpty()){
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listUser,HttpStatus.OK);
    }
}
