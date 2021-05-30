package model.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

    /*
    Navigation command tests here are primarily to ensure the correct command is passed by Rover to
    the RoverLocation. See RoverLocationTest for detailed directional navigation tests.
     */

    @Test
    public void testNavigationForward() {
        // Rover starts at [NORTH](11, 13)
        rover.executeNavigationCommand(RoverNavigationCommands.F);
        // Rover should move to [NORTH](11, 14)
        Assertions.assertEquals(11, rover.getXCoord());
        Assertions.assertEquals(14, rover.getYCoord());
        Assertions.assertEquals(CardinalDirections.NORTH, rover.getBearing());
    }

    @Test
    public void testNavigationBackward() {
        // Rover starts at [NORTH](11, 13)
        rover.executeNavigationCommand(RoverNavigationCommands.B);
        // Rover should move to [NORTH](11, 12)
        Assertions.assertEquals(11, rover.getXCoord());
        Assertions.assertEquals(12, rover.getYCoord());
        Assertions.assertEquals(CardinalDirections.NORTH, rover.getBearing());
    }

    @Test
    public void testNavigationRightTurn() {
        // Rover starts at [NORTH](11, 13)
        rover.executeNavigationCommand(RoverNavigationCommands.R);
        // Rover should rotate to [EAST](11, 13)
        Assertions.assertEquals(11, rover.getXCoord());
        Assertions.assertEquals(13, rover.getYCoord());
        Assertions.assertEquals(CardinalDirections.EAST, rover.getBearing());
    }

    @Test
    public void testNavigationLeftTurn() {
        // Rover starts at [NORTH](11, 13)
        rover.executeNavigationCommand(RoverNavigationCommands.L);
        // Rover should rotate to [WEST](11, 13)
        Assertions.assertEquals(11, rover.getXCoord());
        Assertions.assertEquals(13, rover.getYCoord());
        Assertions.assertEquals(CardinalDirections.WEST, rover.getBearing());
    }

}
