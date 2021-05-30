package services.navigation;

import model.rover.exceptions.InvalidNavigationOrderException;
import services.Validator;
import util.RoverNavigationCommands;

import java.util.Arrays;


/**
 * Navigation Commands may contain F, B, R and L as valid characters, case sensitive, in a string
 * of unrestricted length. If any character in the String is invalid, the entire navigation command
 * is considered invalid
 */
public class NavigationCommandValidator implements Validator<String, InvalidNavigationOrderException, RoverNavigationCommands[]> {

    @Override
    public boolean isValid(String toValidate) {
        if (toValidate == null || toValidate.isEmpty()) return false;

        for (String c : toValidate.split("")) {
            try {
                RoverNavigationCommands.valueOf(c);
            } catch (IllegalArgumentException e){
                return false;
            }
        }
        return true;
    }

    @Override
    public RoverNavigationCommands[] validate(String toValidate) throws InvalidNavigationOrderException {
        if (toValidate == null || toValidate.isEmpty())
            throw new InvalidNavigationOrderException();

        RoverNavigationCommands[] commands = new RoverNavigationCommands[toValidate.length()];
        int index = 0;
        for (String c : toValidate.split("")) {
            try {
                commands[index++] = RoverNavigationCommands.valueOf(c);
            } catch (IllegalArgumentException e){
                throw new InvalidNavigationOrderException();
            }
        }
        return commands;
    }
}
