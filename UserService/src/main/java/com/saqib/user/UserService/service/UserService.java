package com.saqib.user.UserService.service;

import com.saqib.user.UserService.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);
}
