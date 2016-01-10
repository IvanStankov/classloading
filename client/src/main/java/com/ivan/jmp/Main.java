package com.ivan.jmp;

import com.ivan.jmp.producer.GreetingProducer;
import com.ivan.jmp.service.GreetingService;

/**
 * Created by Ваня on 10.01.2016.
 */
public class Main {

    public static void main(String[] args) {
        GreetingService greetingService = GreetingProducer.getInstance().getService();

        String greeting = greetingService.getGreeting();

        System.out.println(greeting);
    }

}
