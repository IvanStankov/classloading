package com.ivan.jmp.service;

import com.ivan.jmp.model.Phone;

/**
 * Created by Ваня on 10.01.2016.
 */
public class PhoneServiceImpl implements PhoneService {
    @Override
    public Phone getPhone() {
        return new Phone("Samsung Galaxy SIII", false);
    }
}
