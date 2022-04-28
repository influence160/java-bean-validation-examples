package com.othmen.example.validation.basic_message_interpolation;

import com.othmen.example.validation.customconstraint.RepeatedCharacter;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;
import java.util.stream.Collectors;

public class TestDefaultMessages {

    Validator validator = Validation
            .byDefaultProvider().configure().buildValidatorFactory()
            .getValidator();

    @Test
    public void test1() {
        ModelWithDefaultMessages model = new ModelWithDefaultMessages();
        model.setS1("adazd");
        System.out.println(validator.validate(model).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", ")));
    }

    @Test
    public void test2() {
        ModelWithDefaultMessages model = new ModelWithDefaultMessages();
        model.setS2("adazd");
        System.out.println(validator.validate(model).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", ")));
    }

    @Test
    public void testSpeedValue() {
        ModelWithDefaultMessages model = new ModelWithDefaultMessages();
        model.setTopSpeed(429.4427222);
        System.out.println(validator.validate(model).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", ")));
    }

    @Test
    public void testSpeedValue2() {
        ModelWithDefaultMessages model = new ModelWithDefaultMessages();
        model.setTopSpeed2(429.4427222);
        System.out.println(validator.validate(model).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", ")));
    }


    @Test
    public void test3() {
        ModelWithDefaultMessages model = new ModelWithDefaultMessages();
        model.setS3("azdazAYllA");
        System.out.println(validator.validate(model).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", ")));
    }
}
