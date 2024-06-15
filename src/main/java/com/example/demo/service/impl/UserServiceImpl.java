package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;

    //Ioc -spring bean LIfe cycle,Di mange) inversion of controller
    //Di-setter getter,contructor,felid dependency dependency Injection.


    @Override
    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User updateUser(User user, Long UserId) {

        User user1 = userRepository.findById(UserId).get();
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());

        User updatedUser = userRepository.save(user1);
        return user1;
    }

    //4th Snehal 28 I am software Dev
    @Override
    public User getSingleUser(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resourece not found on server"));
        return null;
    }

    /*Optional<User> user= userRepository.findById(userId);
         if(user.isPresent()) {
         return user.get();
     }else{
         throw new Exception("Resource not found on server"+ userId);
     }
     */
    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    //4th snehal , 28, I am software Dev
    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resourse not found on server" + userId));
        userRepository.delete(user);
    }
}
