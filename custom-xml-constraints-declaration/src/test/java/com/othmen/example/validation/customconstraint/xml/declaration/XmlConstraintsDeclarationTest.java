package com.othmen.example.validation.customconstraint.xml.declaration;

import com.othmen.example.validation.customconstraint.RepeatedCharacterHolder;
import com.othmen.example.validation.customconstraint.TestConstraint;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class XmlConstraintsDeclarationTest {

    private final TestConstraint testConstraint = new TestConstraint();
    Validator validator = Validation
            .buildDefaultValidatorFactory().getValidator();
    ExecutableValidator executableValidator = Validation
            .buildDefaultValidatorFactory().getValidator().forExecutables();

    @Test
    void test2InValid1Characters() {
        assertEquals(1, validator.validate(new RepeatedCharacterHolder("a")).size());
    }

    @Test
    void test1Valid() {
        testConstraint.soutValidRepeatedCharacter(new RepeatedCharacterHolder("aaa"));
    }

    @Test
    void test1InValid() {
        testConstraint.soutValidRepeatedCharacter(new RepeatedCharacterHolder("abc"));
    }

    @Test
    void test2Valid() {
        assertEquals(0, validator.validate(new RepeatedCharacterHolder("aaa")).size());
    }

    @Test
    void test2InValid() {
        assertNotEquals(0, validator.validate(new RepeatedCharacterHolder("abc")).size());
    }

    @Test
    void test2ValidEmpty() {
        assertEquals(1, validator.validate(new RepeatedCharacterHolder("")).size());
    }

    @Test
    void test2ValidNull() {
        assertEquals(1, validator.validate(new RepeatedCharacterHolder(null)).size());
    }

    @Test
    void test3Valid() throws NoSuchMethodException {
        assertEquals(0, executableValidator.validateParameters(new RepeatedCharacterHolder(""),
                RepeatedCharacterHolder.class.getMethod("copyOf", RepeatedCharacterHolder.class),
                new Object[]{new RepeatedCharacterHolder("aaa")}).size());
    }

    @Test
    void test3InValid() throws NoSuchMethodException {
        assertEquals(1, executableValidator.validateParameters(new RepeatedCharacterHolder(""),
                RepeatedCharacterHolder.class.getMethod("copyOf", RepeatedCharacterHolder.class),
                new Object[]{new RepeatedCharacterHolder("avb")}).size());
    }


}
