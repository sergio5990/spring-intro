package com.github.sergio5990.spring.intro;

import com.github.sergio5990.spring.intro.beans.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Runner {
    @Autowired
    private UserRepository repository;

    public Runner() {
        System.out.println( "constr1 "+ repository);
    }

    @PostConstruct
    public void init(){
        System.out.println("constr2 "+repository);
    }

    @EventListener(classes = ContextRefreshedEvent.class)
    void run() {
        System.out.println("constr3 "+repository);
    }
}
