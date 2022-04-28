package com.othmen.example.validation.customconstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget({ValidationTarget.PARAMETERS, ValidationTarget.ANNOTATED_ELEMENT})
public class NotNulAndNotEmptyAndFirstCharacterIsAlphabeticAndRepeatedCharacterValidator extends RepeatedCharacterValidator implements ConstraintValidator<RepeatedCharacter, String> {

    @Override
    public void initialize(RepeatedCharacter constraintAnnotation) {
        super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s != null && !s.isEmpty()) {
            return super.isValid(s, constraintValidatorContext);
        }
        return false;
    }
}
