package com.stackroute.service;

import com.stackroute.Exceptions.UserAlreadyFoundException;
import com.stackroute.Exceptions.UserNotFoundException;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User saveUser(User user) throws UserAlreadyFoundException {



        if(userRepository.existsById(user.getUserId()))
        {
            throw new UserAlreadyFoundException("User already exists");
        }
        User saveduser=userRepository.save(user);


        if(saveduser==null)
        {
            throw new UserAlreadyFoundException("user does not exists");
        }

        return saveduser;
      
    }

    @Override
    public List<User> deleteUser(int userId) throws UserNotFoundException {
        if(!userRepository.existsById(userId))
        {
            throw new UserNotFoundException("user to delete doesnt exists");
        }

        userRepository.deleteById(userId);

        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int userId) throws UserNotFoundException {

        if(!userRepository.existsById(userId))
        {
            throw new UserNotFoundException("user your are searching doesnt exists");
        }
        Optional<User> user= userRepository.findById(userId);

        if(user==null)
        {
            throw new UserNotFoundException("track doesnt exists");
        }
        return user;
      
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
