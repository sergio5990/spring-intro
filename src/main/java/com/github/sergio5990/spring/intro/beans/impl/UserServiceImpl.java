package com.github.sergio5990.spring.intro.beans.impl;

import com.github.sergio5990.spring.intro.beans.UserRepository;
import com.github.sergio5990.spring.intro.beans.UserService;
import com.github.sergio5990.spring.intro.model.User;

@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final String salt;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.salt = "123";
    }

    String validateUserAndPassword(String userName, String password){
        User user = userRepository.findByUserName(userName);
        if (isValidPassword(user.password, password)){
            return "Ok";
        } else {
            return "error";
        }
    }

    private boolean isValidPassword(String userPassword, String requestPassword) {
        return userPassword.equals(requestPassword + salt);
    }
}
