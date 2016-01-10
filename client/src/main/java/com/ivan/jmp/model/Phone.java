package com.ivan.jmp.model;

/**
 * Created by Ваня on 10.01.2016.
 */
public class Phone {

    private String name;
    private boolean has4g;

    public Phone(String name, boolean has4g) {
        this.name = name;
        this.has4g = has4g;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHas4g() {
        return has4g;
    }

    public void setHas4g(boolean has4g) {
        this.has4g = has4g;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", has4g=" + has4g +
                '}';
    }
}
