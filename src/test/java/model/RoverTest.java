package model;

import model.rover.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.CardinalDirection;

public class RoverTest {

    private Rover rover;

    @BeforeEach
    public void createRover () {
        rover = new Rover(1, 1, CardinalDirection.NORTH);
    }

    @Test
    public void instantiationTest() {
        Assertions.assertNotNull(rover);
        Assertions.assertEquals(1, rover.getXCoord());
        Assertions.assertEquals(1, rover.getYCoord());
        Assertions.assertEquals(CardinalDirection.NORTH, rover.getBearing());
    }

}
