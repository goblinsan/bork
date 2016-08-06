package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void testTurnRight() {
        Direction testObject = Direction.EAST;
        testObject = Direction.values()[testObject.ordinal()+1];
        assertEquals(Direction.SOUTH, testObject);
    }
}