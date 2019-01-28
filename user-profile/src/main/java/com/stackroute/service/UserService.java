package com.stackroute.service;

import com.stackroute.Exceptions.UserAlreadyFoundException;
import com.stackroute.Exceptions.UserNotFoundException;
import com.stackroute.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    public User saveUser(User user) throws UserAlreadyFoundException;

    public List<User> deleteUser(int userId) throws UserNotFoundException;

    public Optional<User> findById(int userId) throws UserNotFoundException;

   public List<User> getAllUser();
//
//    public User updateUser(String comment,int userId) throws UserNotFoundException;
//
//
//
//
//
//    public List<User> findByuserName(String userName);

}
