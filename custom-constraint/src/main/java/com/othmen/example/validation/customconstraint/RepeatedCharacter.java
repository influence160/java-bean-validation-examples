package com.othmen.example.validation.customconstraint;

import javax.validation.Constraint;
import javax.validation.ConstraintTarget;
import javax.validation.Payload;

import java.lang.annotation.*;

/**
 *
 * @see https://beanvalidation.org/2.0/spec/#constraintdeclarationvalidationprocess-validationroutine-typevalidatorresolution
 */
@Documented
@Constraint(validatedBy = RepeatedCharacterValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatedCharacter {

    String message() default "{com.othmen.example.validation.customconstraint.TreeTimesCharacter.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String repeatTimes() default "";

    ConstraintTarget validationAppliesTo() default ConstraintTarget.IMPLICIT;


}
