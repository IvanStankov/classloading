package com.ivan.jmp.producer;

import com.ivan.jmp.service.GreetingService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Ваня on 10.01.2016.
 */
public final class GreetingReloadableProducer {
    private static final GreetingReloadableProducer GREETING_RELOADABLE_PRODUCER = new GreetingReloadableProducer();

    private URLClassLoader urlClassLoader;
    private boolean closed;

    public GreetingReloadableProducer() {
        instantiateClassLoader();
    }

    public GreetingService getService() {
        return getService(false);
    }

    public GreetingService getService(boolean reload) {
        if (reload) {
            instantiateClassLoader();
        }
        GreetingService greetingService = null;
        try {
            Class<?> clazz = urlClassLoader.loadClass("com.ivan.jmp.service.GreetingServiceImpl");
            greetingService = (GreetingService) clazz.newInstance();
            if (!closed) {
                urlClassLoader.close();
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | IOException e) {
            e.printStackTrace();
        }
        return greetingService;
    }

    public static GreetingReloadableProducer getInstance() {
        return GREETING_RELOADABLE_PRODUCER;
    }

    private void instantiateClassLoader() {
        try {
            urlClassLoader = URLClassLoader.newInstance(new URL[]{
                    new URL("file:///F:/Work/Classloading/classloading/impl/target/impl-1.0-SNAPSHOT.jar")});
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
