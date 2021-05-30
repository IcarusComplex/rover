package services.navigation;

import model.rover.exceptions.InvalidNavigationOrderException;
import services.Validator;
import java.util.Arrays;


/**
 * Navigation Commands may contain F, B, R and L as valid characters, case sensitive, in a string
 * of unrestricted length. If any character in the String is invalid, the entire navigation command
 * is considered invalid
 */
public class NavigationCommandValidator implements Validator<String, InvalidNavigationOrderException> {

    @Override
    public boolean isValid(String toValidate) {
        if (toValidate == null || toValidate.isEmpty()) return false;

        for (String c : toValidate.split("")) {
            if (!c.equals("F") && !c.equals("B") && !c.equals("R") && !c.equals("L"))
                return false;
        }
        return true;
    }

    @Override
    public void validate(String toValidate) throws InvalidNavigationOrderException {
        if (toValidate == null || toValidate.isEmpty())
            throw new InvalidNavigationOrderException();

        for (String c : toValidate.split("")) {
            if (!c.equals("F") && !c.equals("B") && !c.equals("R") && !c.equals("L"))
                throw new InvalidNavigationOrderException();
        }
    }
}
