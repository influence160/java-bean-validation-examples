package com.othmen.example.validation.spring.core.integration.test3;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;


public class TestConstraint2 {

    public void soutValidRepeatedCharacter(@Valid ValidatedRepeatedCharacterHolder repeatedCharacterHolder) {
        System.out.println(repeatedCharacterHolder.getS1());
    }
}
