package com.py.mcsusers.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {
    ResponseEntity getUserByCode(Integer id);
    ResponseEntity getUserAll();
    ResponseEntity getUserByList(List<Integer> listId);
}
