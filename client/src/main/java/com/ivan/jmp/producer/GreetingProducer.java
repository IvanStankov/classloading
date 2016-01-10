package com.ivan.jmp.producer;

import com.ivan.jmp.service.GreetingService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Ваня on 10.01.2016.
 */
public final class GreetingProducer {
    private static final GreetingProducer GREETING_PRODUCER = new GreetingProducer();

    private URLClassLoader urlClassLoader;

    private GreetingProducer() {
        try {
            urlClassLoader = URLClassLoader.newInstance(new URL[]{
                    new URL("file:///F:/Work/Classloading/classloading/impl/target/impl-1.0-SNAPSHOT.jar")});
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public GreetingService getService() {
        GreetingService greetingService = null;
        try {
            Class<?> clazz = urlClassLoader.loadClass("com.ivan.jmp.service.GreetingServiceImpl");
            greetingService = (GreetingService) clazz.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException  e) {
            e.printStackTrace();
        }
        return greetingService;
    }

    public static GreetingProducer getInstance() {
        return GREETING_PRODUCER;
    }

}
