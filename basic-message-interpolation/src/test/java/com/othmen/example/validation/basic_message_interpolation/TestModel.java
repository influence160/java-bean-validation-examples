package com.othmen.example.validation.basic_message_interpolation;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.MessageInterpolator;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.stream.Collectors;

public class TestModel {

    Validator validator = Validation
            .buildDefaultValidatorFactory().getValidator();

    @Test
    public void test1() {
        Model model = new Model();
        model.setS1("adazd");
        System.out.println(validator.validate(model).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", ")));
    }

    @Test
    public void test2() {
        Model model = new Model();
        model.setS2("adazd");
        System.out.println(validator.validate(model).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", ")));
    }
}
