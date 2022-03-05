package com.othmen.example.validation.spring.core.integration.test2;

import com.othmen.example.validation.customconstraint.RepeatedCharacterHolder;
import com.othmen.example.validation.customconstraint.TestConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Component
public class A {
    @Autowired
    private TestConstraint2 testConstraint2;
    @Autowired
    private TestConstraint testConstraint;

    @Autowired
    private LocalValidatorFactoryBean validator;

    public boolean validateString(String s1, String s2) {
        Set<ConstraintViolation<ValidatedRepeatedCharacterHolder>> violations = validator.validate(new ValidatedRepeatedCharacterHolder(s1, s2));
        System.out.println(violations);
        return violations.isEmpty();
    }


    public void test(String s1, String s2) {
        testConstraint.soutValidRepeatedCharacter(new ValidatedRepeatedCharacterHolder(s1, s2));
    }

    public void test2(String s1, String s2) {
        testConstraint2.soutValidRepeatedCharacter(new ValidatedRepeatedCharacterHolder(s1, s2));
    }
}
