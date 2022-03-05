package com.othmen.example.validation.spring.core.integration.test1;

import com.othmen.example.validation.customconstraint.RepeatedCharacterHolder;
import com.othmen.example.validation.customconstraint.TestConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Component
public class A {
    @Autowired
    private TestConstraint testConstraint;

    @Autowired
    private LocalValidatorFactoryBean validator;

    public boolean validateString(String s) {
        Set<ConstraintViolation<RepeatedCharacterHolder>> violations = validator.validate(new RepeatedCharacterHolder(s));
        System.out.println(violations);
        return violations.isEmpty();
    }


    public void test(String s) {
        testConstraint.soutValidRepeatedCharacter(new RepeatedCharacterHolder(s));
    }
}
