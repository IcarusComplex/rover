package model.rover;

import util.CardinalDirection;

public class Rover {

    private int xCoord;
    private int yCoord;

    private CardinalDirection bearing;

    public Rover(int xCoord, int yCoord, CardinalDirection bearing) {
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

    public CardinalDirection getBearing() {
        return bearing;
    }
}
