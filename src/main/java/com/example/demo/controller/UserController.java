package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    //lagger -log4j
    //sl4j
    //INFO,WARN,DEBUG,ERROR,TRACE
    //Http method
    //status code

    @Autowired
    private UserServiceI userServiceI;
    //200

    //@pathVariable -pass single data
    //@RequestBody - whole object
    //@requestparam -key-value data,?,&
    //@RequestMapping(Method=RequestMethod,post,name="/users")

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.info("Entaring the request for save user data");
        User savedUser = userServiceI.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userServiceI.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getsingleUser(@PathVariable Long userId) throws Exception {
        log.info("Entering the request for get user data with userId{}", userId);
        User user = userServiceI.getSingleUser(userId);
        log.info("Completed the request for get user data with userId{}", userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId) {
        User updateUser = userServiceI.updateUser(user, userId);
        return new ResponseEntity<>(updateUser, HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userServiceI.deleteUser(userId);
        return new ResponseEntity<>("Resourse delecte successful", HttpStatus.OK);
    }
}

