package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public interface GreetingService {
    
    String sayHello(String name);

}
