package services.navigation;

import model.rover.exceptions.InvalidNavigationOrderException;
import services.Validator;

public class NavigationCommandValidator implements Validator<String, InvalidNavigationOrderException> {
    @Override
    public boolean isValid(String toValidate) {
        if (toValidate.equalsIgnoreCase("f")
                ||toValidate.equalsIgnoreCase("b")
                ||toValidate.equalsIgnoreCase("r")
                ||toValidate.equalsIgnoreCase("l"))
            return true;

        return false;
    }

    @Override
    public void validate(String toValidate) throws InvalidNavigationOrderException {
        if (toValidate.equalsIgnoreCase("f")
        ||toValidate.equalsIgnoreCase("b")
                ||toValidate.equalsIgnoreCase("r")
                ||toValidate.equalsIgnoreCase("l"))
            return;

        throw new InvalidNavigationOrderException();

    }
}
