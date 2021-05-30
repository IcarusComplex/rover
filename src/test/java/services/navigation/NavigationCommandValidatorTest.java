package services.navigation;

import model.rover.exceptions.InvalidNavigationOrderException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;

public class NavigationCommandValidatorTest {

    private static NavigationCommandValidator validator;

    @BeforeAll
    public static void instantiateValidator() {
        validator = new NavigationCommandValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"F", "B", "R", "L", "FBRL", "FFBBRRLLFFBBRRLL"})
    public void validNavigationCommands (String command) {
        Assertions.assertTrue(validator.isValid(command));
        Assertions.assertDoesNotThrow(() -> validator.validate(command));
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "C", "D", "E", "G", "H", "I", "J", "K", "M", "N", "O", "P", "Q", "S", "T", "U", "V", "W", "X", "Y", "Z", "FBRLA", "FFZBBGRRTLLE"})
    // Entire alphabet, except FBRL are invalid.
    public void invalidNavigationCommands(String command) {
        Assertions.assertFalse(validator.isValid(command));
        Assertions.assertThrows(InvalidNavigationOrderException.class, () -> validator.validate(command));
    }

}
