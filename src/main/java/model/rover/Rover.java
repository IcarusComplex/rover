package model.rover;

import util.CardinalDirections;
import util.RoverNavigationCommands;

public class Rover {

    private int xCoord;
    private int yCoord;

    private CardinalDirections bearing;

    public Rover(int xCoord, int yCoord, CardinalDirections bearing) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.bearing = bearing;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public CardinalDirections getBearing() {
        return bearing;
    }

    public void executeNavigationCommand(RoverNavigationCommands command){

    }

}
