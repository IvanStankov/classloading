package com.ivan.jmp;

import com.ivan.jmp.model.Phone;
import com.ivan.jmp.service.PhoneService;
import com.ivan.jmp.service.PhoneServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Ваня on 10.01.2016.
 */
public class ProxyMain {

    public static void main(String[] args) {
        PhoneService phoneService = (PhoneService) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{PhoneService.class},
                new InvocationHandler() {
                    private PhoneService phoneService = new PhoneServiceImpl();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Invoking " + method.getName() + ", params = " + args);
                        return method.invoke(phoneService, args);
                    }
                });

        Phone phone = phoneService.getPhone();

        System.out.println(phone);
    }
}
