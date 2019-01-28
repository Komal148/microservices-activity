package com.stackroute.controller;


import com.stackroute.Exceptions.UserAlreadyFoundException;
import com.stackroute.Exceptions.UserNotFoundException;
import com.stackroute.service.UserService;
import com.stackroute.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //this method is used to post data for the first time
    @PostMapping("user")
    public ResponseEntity<?> saveMusic(@RequestBody User user) throws UserAlreadyFoundException {
        ResponseEntity responseEntity;

        userService.saveUser(user);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);

        return responseEntity;
    }


    //this is a get method and it is used to get all the values
    @GetMapping("users")
    public ResponseEntity<?> getAllUser()
    {
        return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
    }

    @DeleteMapping("user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId) throws UserNotFoundException
    {
        ResponseEntity responseEntity;

        responseEntity= new ResponseEntity<List<User>>(userService.deleteUser(userId),HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<?> findById(@PathVariable("userId")int userId) throws UserNotFoundException
    {
        ResponseEntity responseEntity;

        responseEntity= new ResponseEntity<Optional<User>>(userService.findById(userId),HttpStatus.OK);
        return responseEntity;

    }


}