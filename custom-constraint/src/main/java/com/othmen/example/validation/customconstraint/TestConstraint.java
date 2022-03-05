package com.othmen.example.validation.customconstraint;

import javax.validation.Valid;

public class TestConstraint {

    public void soutValidRepeatedCharacter(@Valid RepeatedCharacterHolder repeatedCharacterHolder) {
        System.out.println(repeatedCharacterHolder.getS1());
    }
}
