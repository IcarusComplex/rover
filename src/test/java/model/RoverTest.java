package model;

import model.rover.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.CardinalDirections;
import util.RoverNavigationCommands;

public class RoverTest {

    private Rover rover;

    @BeforeEach
    public void createRover () {
        rover = new Rover(11, 13, CardinalDirections.NORTH);
    }

    @Test
    public void instantiationTest() {
        Assertions.assertNotNull(rover);
        Assertions.assertEquals(11, rover.getXCoord());
        Assertions.assertEquals(13, rover.getYCoord());
        Assertions.assertEquals(CardinalDirections.NORTH, rover.getBearing());
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
    public void testNavigationForward() {
        // Rover starts at [NORTH](11, 13)

        rover.executeNavigationCommand(RoverNavigationCommands.F);
        //[NORTH](11, 14)
        Assertions.assertEquals(11, rover.getXCoord());
        Assertions.assertEquals(14, rover.getYCoord());
        Assertions.assertEquals(CardinalDirections.NORTH, rover.getBearing());

        // Update Bearing and test Forward movement:
        rover.executeNavigationCommand(RoverNavigationCommands.R);
        //[EAST](11, 14)
        rover.executeNavigationCommand(RoverNavigationCommands.F);
        //[EAST](12, 14)
        Assertions.assertEquals(12, rover.getXCoord());
        Assertions.assertEquals(14, rover.getYCoord());
        Assertions.assertEquals(CardinalDirections.EAST, rover.getBearing());

        // Update Bearing and test Forward movement:
        rover.executeNavigationCommand(RoverNavigationCommands.R);
        //[SOUTH](12, 14)
        rover.executeNavigationCommand(RoverNavigationCommands.F);
        //[SOUTH](12, 13)
        Assertions.assertEquals(12, rover.getXCoord());
        Assertions.assertEquals(13, rover.getYCoord());
        Assertions.assertEquals(CardinalDirections.SOUTH, rover.getBearing());

        // Update Bearing and test Forward movement:
        rover.executeNavigationCommand(RoverNavigationCommands.R);
        //[WEST](12, 13)
        rover.executeNavigationCommand(RoverNavigationCommands.F);
        //[WEST](11, 13)
        Assertions.assertEquals(11, rover.getXCoord());
        Assertions.assertEquals(13, rover.getYCoord());
        Assertions.assertEquals(CardinalDirections.WEST, rover.getBearing());
    }

    @Test
    public void testNavigationBackward() {

    }

    @Test
    public void testNavigationRightTurn() {

    }

    @Test
    public void testNavigationLeftTurn() {

    }

}
