package com.othmen.example.validation.customconstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.util.Objects;

/**
 * this constraint validator checks that a string is like aaa, bb, cccccccc ...
 */
@SupportedValidationTarget({ValidationTarget.PARAMETERS, ValidationTarget.ANNOTATED_ELEMENT})
public class RepeatedCharacterValidator implements ConstraintValidator<RepeatedCharacter, String> {

    private Integer repeatTimes;

    @Override
    public void initialize(RepeatedCharacter constraintAnnotation) {
        repeatTimes = constraintAnnotation.repeatTimes().isEmpty() ? null : Integer.valueOf(constraintAnnotation.repeatTimes());
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(" validating " + s);
        if (repeatTimes != null) {
            if (s == null) {
                return false;
            }
            if (s.length() != repeatTimes) {
                System.out.println("not valid");
                return false;
            }
        } else {
            return true;
        }
        if (s.length() > 0) {
            char c = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != c) {
                    System.out.println("not valid");
                    return false;
                }
            }
        }
        System.out.println("valid");
        return true;
    }
}
