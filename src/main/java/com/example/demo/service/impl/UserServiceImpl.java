package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl  implements UserServiceI {

    @Autowired
    private UserRepository userRepository;

    //Ioc -spring bean LIfe cycle,Di mange) inversion of controller
    //Di-setter getter,contructor,felid dependency dependency Injection.


    @Override
    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        return  savedUser;
    }

    @Override
    public User updateUser(User user, Long UserId) {
        return null;
    }

    @Override
    public User getSingleUser(Long userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
