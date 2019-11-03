package com.github.sergio5990.spring.intro.annotation;

import com.github.sergio5990.spring.intro.beans.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AnnotationName {

//    @Autowired
    private UserRepository repo;

    @Autowired
    @Qualifier("userRepository")
    private UserRepository repo1;

    @Autowired
    private UserRepository userRepository;
}
