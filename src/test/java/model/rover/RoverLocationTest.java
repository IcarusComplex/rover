package model.rover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import util.CardinalDirections;
import util.RoverNavigationCommands;

public class RoverLocationTest {

    private static RoverLocation location;

    @BeforeAll
    public static void instantiateRoverLocation () {
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

    // TODO include Backward, Right turn and left turn tests
}
