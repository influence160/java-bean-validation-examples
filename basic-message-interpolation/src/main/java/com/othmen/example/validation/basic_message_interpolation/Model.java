package com.othmen.example.validation.basic_message_interpolation;

import com.othmen.example.validation.customconstraint.RepeatedCharacter;

import javax.validation.constraints.Size;

public class Model {

    @Size(min=110, max=111, message="${validatedValue} must have between {min} {max} characters")
    @RepeatedCharacter(message = "{validatedValue} is no good")
    private String s1;

    @RepeatedCharacter(message = "${validatedValue} is no good, repeattime : {repeatTimes}", repeatTimes = "103")
    private String s2;

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public String toString() {
        return "Model[" + s1 + ", " + s2 + "]";
    }
}
