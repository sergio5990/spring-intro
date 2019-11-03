package com.github.sergio5990.spring.intro.annotation;

import com.github.sergio5990.spring.intro.beans.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnotationInject {
    @Autowired
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
