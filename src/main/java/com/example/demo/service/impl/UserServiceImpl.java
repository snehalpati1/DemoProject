package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceI {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    //Ioc -spring bean LIfe cycle,Di mange) inversion of controller
    //Di-setter getter,contructor,felid dependency dependency Injection.


    @Override
    public User createUser(User user) {
        log.info("Initing the dao call for the save user data");
        User savedUser = userRepository.save(user);
        log.info("Completed the dao call for the save user data");
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
    public User getSingleUser(Long userId) throws Exception {
        log.info("Initiating the dao call for get single user data as userId{}:",userId);
     User user= userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resourece not found on server"));
        log.info("Complated the dao call for get single user data as userId{}:",userId);
        return user;
          }

  /*      Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new Exception("Resource not found on server ! !" + userId);
        }
        }*/

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    //4th snehal , 28, I am software Dev
    @GetMapping("/users")
    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resourse not found on server" + userId));
        userRepository.delete(user);
    }
}
