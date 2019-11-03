package com.github.sergio5990.spring.intro;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class Runner {

    @EventListener(classes = ContextRefreshedEvent.class)
    void run(){
        System.out.println("приложение запустилось");
    }
}
