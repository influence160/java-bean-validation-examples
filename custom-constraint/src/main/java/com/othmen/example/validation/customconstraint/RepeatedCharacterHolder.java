package com.othmen.example.validation.customconstraint;


import javax.validation.Valid;

public class RepeatedCharacterHolder {

    @RepeatedCharacter()
    private String s1;

    public RepeatedCharacterHolder(String s1) {
        this.s1 = s1;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public void copyOf(@Valid RepeatedCharacterHolder repeatedCharacterHolder) {
        this.s1 = repeatedCharacterHolder.getS1();
    }
}