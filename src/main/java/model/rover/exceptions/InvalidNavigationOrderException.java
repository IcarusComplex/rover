package model.rover.exceptions;

// TODO implement better message to include point of failure in navigation order
public class InvalidNavigationOrderException extends Exception{
    public InvalidNavigationOrderException(){
        super();
    }
}
