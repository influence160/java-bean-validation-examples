package com.othmen.example.validation.spring.core.integration.test2;

import com.othmen.example.validation.customconstraint.TestConstraint;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public class TestConstraint2 {

    public void soutValidRepeatedCharacter(@Valid ValidatedRepeatedCharacterHolder repeatedCharacterHolder) {
        System.out.println(repeatedCharacterHolder.getS1());
    }
}
