package services.navigation;

import model.rover.exceptions.InvalidNavigationOrderException;

public class RoverNavigationService {

    private static RoverNavigationService instance;

    public static RoverNavigationService getInstance(){
        if (instance == null)
            instance = new RoverNavigationService();

        return instance;
    }

    private final NavigationCommandValidator validator;

    private RoverNavigationService(){
       this.validator = new NavigationCommandValidator();
    }

    public void executeNavigationCommand(String command) throws InvalidNavigationOrderException {
        validator.validate(command);
    }
}
