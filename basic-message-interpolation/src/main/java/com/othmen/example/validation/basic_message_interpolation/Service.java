package com.othmen.example.validation.basic_message_interpolation;

import javax.validation.Valid;

public class Service {

    public void soutModel(@Valid Model model) {
        System.out.println(model);
    }
}
