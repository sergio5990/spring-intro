package com.github.sergio5990.spring.intro.beans.impl;

import com.github.sergio5990.spring.intro.beans.UserRepository;
import com.github.sergio5990.spring.intro.model.User;

@org.springframework.stereotype.Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public User findByUserName(String userName) {
        if (userName.equals("sergey")) {
            return new User("sergey", "123");
        } else {
            throw new IllegalArgumentException("user not found");
        }
    }

    @Override
    public String toString() {
        return "class UserRepository";
    }
}
