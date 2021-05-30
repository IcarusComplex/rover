package services.navigation;

import model.rover.Rover;
import model.rover.RoverLocation;
import model.rover.exceptions.InvalidNavigationOrderException;
import util.RoverNavigationCommands;

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

    public RoverLocation executeNavigationCommand(Rover rover, String command) throws InvalidNavigationOrderException {
        RoverNavigationCommands[] commands = validator.validate(command);

        for (RoverNavigationCommands c : commands){
            rover.executeNavigationCommand(c);
        }
        return rover.getLocation();
    }
}
