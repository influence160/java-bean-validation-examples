package com.othmen.example.validation.spring.core.integration.test3;

import com.othmen.example.validation.customconstraint.TestConstraint;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class A {
    @Autowired
    private TestConstraint2 testConstraint2;

    @Autowired
    private LocalValidatorFactoryBean validator;


    public void test2(String s1, String s2) {
        ValidatedRepeatedCharacterHolder repeatedCharacterHolder = new ValidatedRepeatedCharacterHolder(s1, s2);
        DataBinder binder = new DataBinder(repeatedCharacterHolder);
        binder.setValidator(validator);
        PropertyValues propertyValues = new MutablePropertyValues(Map.of("s1", s1, "s2", s2));
        binder.bind(propertyValues);
        binder.validate();
        BindingResult results = binder.getBindingResult();
        System.out.println("valid = " + !results.hasErrors());
        System.out.println("errors = " + results.getAllErrors());
    }
}
