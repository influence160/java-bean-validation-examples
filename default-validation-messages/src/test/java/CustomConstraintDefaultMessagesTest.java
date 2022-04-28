import com.othmen.example.validation.customconstraint.RepeatedCharacter;
import com.othmen.example.validation.customconstraint.RepeatedCharacterHolder;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Size;
import javax.validation.executable.ExecutableValidator;
import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomConstraintDefaultMessagesTest {

    Validator validator = Validation
            .buildDefaultValidatorFactory().getValidator();
    ExecutableValidator executableValidator = Validation
            .buildDefaultValidatorFactory().getValidator().forExecutables();

    public static class TestModel {

        @RepeatedCharacter(repeatTimes = "3")
        private final String threeSameCharacter;

        @Size(min = 100, max = 100)
        private final String oneHandredCharacters;

        public TestModel(String threeSameCharacter, String oneHandredCharacters) {
            this.threeSameCharacter = threeSameCharacter;
            this.oneHandredCharacters = oneHandredCharacters;
        }
    }


    @Test
    void testWithoutRepeatedCaracters() {
        Set<ConstraintViolation<RepeatedCharacterHolder>> constraintViolations = validator.validate(new RepeatedCharacterHolder("abc"));
        assertEquals(1, constraintViolations.size());
        String message = constraintViolations.iterator().next().getMessage();
        System.out.println(message);
        if(Locale.getDefault() == Locale.FRANCE || Locale.getDefault() == Locale.FRENCH) {
            assertEquals("abc n'est pas un caractères répetés correct.", message);
        } else {
            assertEquals("abc is not a correct repeated caracters.", message);
        }
    }

    @Test
    void testWithRepeatedCaracters() {
        Set<ConstraintViolation<TestModel>> constraintViolations = validator.validate(new TestModel("aaaaaa", null));
        assertEquals(1, constraintViolations.size());
        String message = constraintViolations.iterator().next().getMessage();
        System.out.println(message);
        if(Locale.getDefault() == Locale.FRANCE || Locale.getDefault() == Locale.FRENCH) {
            assertEquals("aaaaaa n'est pas un caractères répetés 3 fois correct.", message);
        } else {
            assertEquals("aaaaaa is not a correct repeated 3 caracters.", message);
        }
    }

    @Test
    void testCustomDefaultSizeMessage() {
        Set<ConstraintViolation<TestModel>> constraintViolations = validator.validate(new TestModel("aaa", "zzz"));
        assertEquals(1, constraintViolations.size());
        String message = constraintViolations.iterator().next().getMessage();
        System.out.println(message);
        if(Locale.getDefault() == Locale.FRANCE || Locale.getDefault() == Locale.FRENCH) {
            assertEquals("la taille de zzz n'est pas comprise entre 100 et 100.", message);
        } else {
            assertEquals("size of zzz is not between 100 and 100.", message);
        }
    }


}
