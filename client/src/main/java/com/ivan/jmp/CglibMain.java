package com.ivan.jmp;

import com.ivan.jmp.model.Car;
import com.ivan.jmp.service.CarService;
import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * Created by Ваня on 10.01.2016.
 */
public class CglibMain {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CarService.class);
        // Create callback handlers: for all methods, for getCar and for getAnotherCar methods
//        Callback[] callbacks = new Callback[]{
//                (MethodInterceptor) (o, method, objects, methodProxy) -> {
//                    Car car = (Car) methodProxy.invokeSuper(o, objects);
//                    car.setPower(car.getPower() * 2);
//                    return car;
//                },
//                (MethodInterceptor) (o, method, objects, methodProxy) -> {
//                    Car car = (Car) methodProxy.invokeSuper(o, objects);
//                    car.setPower(car.getPower() / 2);
//                    return car;
//                }
//        };
//        enhancer.setCallbackFilter(method -> {
//            if ("getCar".equals(method.getName())) {
//                return 0;
//            } else {
//                return 1;
//            }
//        });
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("Cglib: Invoking " + method.getName());
            return methodProxy.invokeSuper(o, args);
        });

        CarService proxy = (CarService) enhancer.create();
        Car carFromProxy = proxy.getCar();
        Car anotherCarFromProxy = proxy.getAnotherCar();

        System.out.println(carFromProxy);
        System.out.println(anotherCarFromProxy);
    }

}
