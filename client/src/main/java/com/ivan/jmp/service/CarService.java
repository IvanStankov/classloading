package com.ivan.jmp.service;

import com.ivan.jmp.model.Car;

/**
 * Created by Ваня on 10.01.2016.
 */
public class CarService {

    public Car getCar() {
        return new Car("Chevrolet Lacetti", 96);
    }

    public Car getAnotherCar() {
        return new Car("BMW M5 E60", 507);
    }

}
