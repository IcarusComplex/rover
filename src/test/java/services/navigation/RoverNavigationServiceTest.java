package services.navigation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import model.rover.exceptions.InvalidNavigationOrderException;

public class RoverNavigationServiceTest {

    private static RoverNavigationService navigationService;

    @BeforeAll
    public static void initiateNavigationService() {
        navigationService = RoverNavigationService.getInstance();
        Assertions.assertNotNull(navigationService);
    }

    //TODO ensure expected location is returned by the service after command execution
    @ParameterizedTest
    @ValueSource(strings = {"F", "B", "R", "L", "FBRL"})
    public void executeValidNavigationCommand(String command) {
        Assertions.assertDoesNotThrow(() -> {
            navigationService.executeNavigationCommand(command);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "C", "D", "E", "G", "H", "I", "J", "K", "M", "N", "O", "P", "Q", "S", "T", "U", "V", "W", "X", "Y", "Z", "FBRLA", "FFZBBGRRTLLE"})
    public void executeInvalidNavigationCommandTest(String command) {
        Assertions.assertThrows(InvalidNavigationOrderException.class, () -> {
            navigationService.executeNavigationCommand(command);
        });
    }
}
