package services.navigation;

import model.rover.Rover;
import model.rover.RoverLocation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import model.rover.exceptions.InvalidNavigationOrderException;
import util.CardinalDirections;

public class RoverNavigationServiceTest {

    private Rover rover;
    private static RoverNavigationService navigationService;

    @BeforeAll
    public static void initiateNavigationService() {
        navigationService = RoverNavigationService.getInstance();
        Assertions.assertNotNull(navigationService);
    }

    @BeforeEach
    public void initiateRover() {
        rover = new Rover(1, 1, CardinalDirections.NORTH);
    }

    @ParameterizedTest
    @CsvSource({"F,1,2,NORTH", "B,1,0,NORTH", "R,1,1,EAST", "L,1,1,WEST", "FRBL,0,2,NORTH"})
    public void executeValidNavigationCommand(String command, int x, int y, String bearing) {
        Assertions.assertDoesNotThrow(() -> {
            RoverLocation location = navigationService.executeNavigationCommand(rover, command);
            Assertions.assertEquals(x, location.getXCoord());
            Assertions.assertEquals(y, location.getYCoord());
            Assertions.assertEquals(bearing, location.getBearing().toString());
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "C", "D", "E", "G", "H", "I", "J", "K", "M", "N", "O", "P", "Q", "S", "T", "U", "V", "W", "X", "Y", "Z", "FBRLA", "FFZBBGRRTLLE"})
    public void executeInvalidNavigationCommandTest(String command) {
        Assertions.assertThrows(InvalidNavigationOrderException.class, () -> {
            navigationService.executeNavigationCommand(rover, command);
        });
    }
}
