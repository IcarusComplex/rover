package model.rover;

import util.CardinalDirections;
import util.RoverNavigationCommands;

public class Rover {

    private RoverLocation roverLocation;

    public Rover(int xCoord, int yCoord, CardinalDirections bearing) {
        roverLocation = new RoverLocation(xCoord, yCoord, bearing);
    }

    public int getXCoord() {
        return roverLocation.getXCoord();
    }

    public int getYCoord() {
        return roverLocation.getYCoord();
    }

    public CardinalDirections getBearing() {
        return roverLocation.getBearing();
    }

    public RoverLocation getLocation() {
        return roverLocation;
    }

    public void executeNavigationCommand(RoverNavigationCommands command){
        switch (command){
            case F -> roverLocation.executeForward();
            case B -> roverLocation.executeBackward();
            case R -> roverLocation.executeRightTurn();
            case L -> roverLocation.executeLeftTurn();
        }
    }

}
