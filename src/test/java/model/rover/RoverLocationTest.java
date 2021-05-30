package model.rover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.CardinalDirections;
import util.RoverNavigationCommands;

public class RoverLocationTest {

    private RoverLocation location;

    @BeforeEach
    public void instantiateRoverLocation () {
        location = new RoverLocation(11, 13, CardinalDirections.NORTH);
    }

    /**
     * Test forward movement of rover in all four cardinal directions.
     * Ensure forward movement updates position correctly in both x and y coordinates without
     * altering the bearing of the rover.
     *
     * Rotation commands are used here with the assumption of working correctly,
     * as they are tested in testNavigationRightTurn and testNavigationLeftTurn respectively
     */
    @Test
    public void testForwardMove() {
        location.executeForward();
        //[NORTH](11, 14)
        Assertions.assertEquals(11, location.getXCoord());
        Assertions.assertEquals(14, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.NORTH, location.getBearing());

        // Update Bearing and test Forward movement:
        location.executeRightTurn();
        //[EAST](11, 14)
        location.executeForward();
        //[EAST](12, 14)
        Assertions.assertEquals(12, location.getXCoord());
        Assertions.assertEquals(14, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.EAST, location.getBearing());

        // Update Bearing and test Forward movement:
        location.executeRightTurn();
        //[SOUTH](12, 14)
        location.executeForward();
        //[SOUTH](12, 13)
        Assertions.assertEquals(12, location.getXCoord());
        Assertions.assertEquals(13, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.SOUTH, location.getBearing());

        // Update Bearing and test Forward movement:
        location.executeRightTurn();
        //[WEST](12, 13)
        location.executeForward();
        //[WEST](11, 13)
        Assertions.assertEquals(11, location.getXCoord());
        Assertions.assertEquals(13, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.WEST, location.getBearing());
    }

    /**
     * Test backward movement of rover in all four cardinal directions.
     * Ensure backward movement updates position correctly in both x and y coordinates without
     * altering the bearing of the rover.
     *
     * Rotation commands are used here with the assumption of working correctly,
     * as they are tested in testNavigationRightTurn and testNavigationLeftTurn respectively
     */
    @Test
    public void testBackwardMove() {
        //Starting at [NORTH](11, 13)
        location.executeBackward();
        //[NORTH](11, 12)
        Assertions.assertEquals(11, location.getXCoord());
        Assertions.assertEquals(12, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.NORTH, location.getBearing());

        // Update Bearing and test Forward movement:
        location.executeLeftTurn();
        //[WEST](11, 12)
        location.executeBackward();
        //[WEST](12, 12)
        Assertions.assertEquals(12, location.getXCoord());
        Assertions.assertEquals(12, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.WEST, location.getBearing());

        // Update Bearing and test Forward movement:
        location.executeLeftTurn();
        //[SOUTH](12, 12)
        location.executeBackward();
        //[SOUTH](12, 13)
        Assertions.assertEquals(12, location.getXCoord());
        Assertions.assertEquals(13, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.SOUTH, location.getBearing());

        // Update Bearing and test Forward movement:
        location.executeLeftTurn();
        //[EAST](12, 13)
        location.executeBackward();
        //[EAST](11, 13)
        Assertions.assertEquals(11, location.getXCoord());
        Assertions.assertEquals(13, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.EAST, location.getBearing());
    }

    /**
     * Ensure turning, left or right updates bearing correctly from one to the next, and never alters location
     */

    @Test
    public void testNavigationRightTurn () {
        //Starting at [NORTH](11, 13)
        location.executeRightTurn();
        //[EAST](11, 13)
        Assertions.assertEquals(11, location.getXCoord());
        Assertions.assertEquals(13, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.EAST, location.getBearing());

        location.executeRightTurn();
        //[SOUTH](11, 13)
        Assertions.assertEquals(11, location.getXCoord());
        Assertions.assertEquals(13, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.SOUTH, location.getBearing());

        location.executeRightTurn();
        //[WEST](11, 13)
        Assertions.assertEquals(11, location.getXCoord());
        Assertions.assertEquals(13, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.WEST, location.getBearing());
    }

    @Test
    public void testNavigationLeftTurn () {
        //Starting at [NORTH](11, 13)
        location.executeLeftTurn();
        //[WEST](11, 13)
        Assertions.assertEquals(11, location.getXCoord());
        Assertions.assertEquals(13, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.WEST, location.getBearing());

        location.executeLeftTurn();
        //[SOUTH](11, 13)
        Assertions.assertEquals(11, location.getXCoord());
        Assertions.assertEquals(13, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.SOUTH, location.getBearing());

        location.executeLeftTurn();
        //[EAST](11, 13)
        Assertions.assertEquals(11, location.getXCoord());
        Assertions.assertEquals(13, location.getYCoord());
        Assertions.assertEquals(CardinalDirections.EAST, location.getBearing());
    }
}
