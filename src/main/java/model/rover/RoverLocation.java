package model.rover;

import util.CardinalDirections;

public class RoverLocation {

    private int xCoord;
    private int yCoord;

    private CardinalDirections bearing;

    public RoverLocation(int xCoord, int yCoord, CardinalDirections bearing) {
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

/*
    Movement is executed assuming NORTH as the 0 degree FORWARD bearing.
    Assuming a positional update vector (1, 1) per movement which we can then modify by cardinal direction using
    the dot product of the vectors:

    North: (0, 1)
    East: (1, 0)
    South: (0, -1)
    West: (-1, 0)

    Backwards, we simply scale the resulting dot product by -1.
    We then add the result to the current x/y coordinate
     */

    private final int[] north = new int[]{0, 1};
    private final int[] east = new int[]{1, 0};
    private final int[] south = new int[]{0, -1};
    private final int[] west = new int[]{-1, 0};

    public void executeForward() {
        executeMove(1);
    }

    public void executeBackward() {
        executeMove(-1);
    }

    private void executeMove(int directionScalar) {
        switch (this.bearing){
            case NORTH -> updateCoordinates(directionScalar, north);
            case EAST -> updateCoordinates(directionScalar, east);
            case SOUTH -> updateCoordinates(directionScalar, south);
            case WEST -> updateCoordinates(directionScalar, west);
        }
    }

    private void updateCoordinates(int directionScalar, int[] movementVector){
        this.xCoord += (directionScalar*movementVector[0]);
        this.yCoord += (directionScalar*movementVector[1]);
    }
    
    public void executeRightTurn() {
        switch (this.bearing) {
            case NORTH -> this.bearing = CardinalDirections.EAST;
            case EAST -> this.bearing = CardinalDirections.SOUTH;
            case SOUTH -> this.bearing = CardinalDirections.WEST;
            case WEST -> this.bearing = CardinalDirections.NORTH;
        }
    }

    public void executeLeftTurn() {
        switch (this.bearing) {
            case NORTH -> this.bearing = CardinalDirections.WEST;
            case EAST -> this.bearing = CardinalDirections.NORTH;
            case SOUTH -> this.bearing = CardinalDirections.EAST;
            case WEST -> this.bearing = CardinalDirections.SOUTH;
        }
    }
}
