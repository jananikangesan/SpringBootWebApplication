package com.example.demo.service;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("english")
public class GreetigServiceEnglish implements GreetingService{

    @Override
    public String sayHello(String name){
        return "hello "+ name;
    }
    
}
