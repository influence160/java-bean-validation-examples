package com.othmen.example.validation.basic_message_interpolation;

import com.othmen.example.validation.customconstraint.RepeatedCharacter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

public class Model {

    @Size(min=110, max=111, message="${validatedValue} must have between {min} {max} characters")
    @RepeatedCharacter(message = "{validatedValue} is no good")
    private String s1;

    @RepeatedCharacter(message = "${validatedValue} is no good, repeattime : {repeatTimes}", repeatTimes = "103")
    private String s2;

    @DecimalMax(
            value = "350",
            message = "The top speed ${formatter.format('%1$.2f', validatedValue)} is higher than {value}"
    )
    private double topSpeed;

    @DecimalMax(
            value = "350",
            message = "The top speed ${fn:formatter.format('%1$.2f', validatedValue)} is higher than {value}"
    )
    private double topSpeed2;

    // @RepeatedCharacter(message = "${com.othmen.example.validation.basic_message_interpolation.UtilityClass.toUnderscoreCase(validatedValue)} is no good, repeattime : {repeatTimes}", repeatTimes = "103")
    private String s3;

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

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public double getTopSpeed2() {
        return topSpeed2;
    }

    public void setTopSpeed2(double topSpeed2) {
        this.topSpeed2 = topSpeed2;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public String toString() {
        return "Model[" + s1 + ", " + s2 + "]";
    }
}
