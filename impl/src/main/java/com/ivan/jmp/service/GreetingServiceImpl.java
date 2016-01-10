package com.ivan.jmp.service;

/**
 * Created by Ваня on 10.01.2016.
 */
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String getGreeting() {
        return "Hello whoever you are!";
    }

}
