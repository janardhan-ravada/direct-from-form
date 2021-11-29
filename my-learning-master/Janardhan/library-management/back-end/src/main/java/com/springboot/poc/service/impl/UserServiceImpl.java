package com.springboot.poc.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.poc.model.User;
import com.springboot.poc.repository.UserRepository;
import com.springboot.poc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByName(String name) {
        Objects.requireNonNull(name);
        return userRepository.findByName(name);
    }

}
