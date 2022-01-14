package com.py.mcsusers.service;

import com.py.mcsusers.model.response.User;

import java.util.List;

public interface UserService {
    public User getUserByCode(Integer id);
    public List<User> getUserAll();
    public List<User> getUserByList(List<Integer> listId);
}
