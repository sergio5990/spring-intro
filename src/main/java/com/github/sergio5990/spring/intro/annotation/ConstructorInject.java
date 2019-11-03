package com.github.sergio5990.spring.intro.annotation;

import com.github.sergio5990.spring.intro.beans.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ConstructorInject {
    private final UserRepository userRepository;

//    @Autowired
    public ConstructorInject(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

}
