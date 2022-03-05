package com.othmen.example.validation.spring.core.integration.test3;

import com.othmen.example.validation.customconstraint.RepeatedCharacterHolder;

import javax.validation.constraints.NotBlank;

public class ValidatedRepeatedCharacterHolder extends RepeatedCharacterHolder {

    @NotBlank
    private String s2;

    public ValidatedRepeatedCharacterHolder(String s1, String s2) {
        super(s1);
        this.s2 = s2;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }
}
