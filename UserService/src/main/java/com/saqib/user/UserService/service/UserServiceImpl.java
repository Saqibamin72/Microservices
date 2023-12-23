package com.saqib.user.UserService.service;

import com.saqib.user.UserService.entity.User;
import com.saqib.user.UserService.exception.ResourceNotFoundException;
import com.saqib.user.UserService.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        String randomUUID= UUID.randomUUID().toString();
        user.setUserId(randomUUID);
        return userRepository.save(user);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id not found!!"+userId));
    }
}
