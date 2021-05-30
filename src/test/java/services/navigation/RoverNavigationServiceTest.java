package services.navigation;

import org.junit.jupiter.api.BeforeAll;
import services.navigation.RoverNavigationService;

public class RoverNavigationServiceTest {

    private static RoverNavigationService navigationService;

    @BeforeAll
    public static void initiateNavigationService() {
        navigationService = new RoverNavigationService();
    }

    // TODO test navigation command, and ensure returned value is correct
}
