package com.othmen.example.validation.basic_message_interpolation;

import org.hibernate.validator.internal.engine.messageinterpolation.el.BeanMethodsELContext;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.MessageInterpolator;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.stream.Collectors;

public class TestModel {

    Validator validator = Validation
            .byDefaultProvider().configure().buildValidatorFactory()
            .getValidator();

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

    @Test
    public void testSpeedValue() {
        Model model = new Model();
        model.setTopSpeed(429.4427222);
        System.out.println(validator.validate(model).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", ")));
    }

    @Test
    public void testSpeedValue2() {
        Model model = new Model();
        model.setTopSpeed2(429.4427222);
        System.out.println(validator.validate(model).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", ")));
    }


    @Test
    public void test3() {
        Model model = new Model();
        model.setS3("azdazAYllA");
        System.out.println(validator.validate(model).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", ")));
    }
}
