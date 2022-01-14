package com.py.mcsusers.controller;

import com.py.mcsusers.controller.impl.UserControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllerDecorator implements  UserController{
    @Autowired
    private UserController userController;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity getUserByCode(@RequestParam(value = "id", required = true ) Integer id) {
        return userController.getUserByCode(id);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/all")
    @Override
    public ResponseEntity getUserAll() {
        return userController.getUserAll();
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/bylist")
    @Override
    public ResponseEntity getUserByList(@RequestParam(value = "listId" , required = true) List<Integer> listId) {
        return userController.getUserByList(listId);
    }
}
