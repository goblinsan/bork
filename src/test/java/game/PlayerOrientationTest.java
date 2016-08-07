package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerOrientationTest {

    WorldMap map = new WorldMap();
    Player james = new Player(map);

    @Test
    public void testByDefaultPlayerIsFacingNorth() {
        assertEquals(Direction.NORTH, james.isFacing());
    }

    @Test
    public void testTurnPlayerRight() {
        james.turnRight();
        assertEquals(Direction.EAST, james.isFacing());
        james.turnRight();
        assertEquals(Direction.SOUTH, james.isFacing());
        james.turnRight();
        assertEquals(Direction.WEST, james.isFacing());
        james.turnRight();
        assertEquals(Direction.NORTH, james.isFacing());
    }

    @Test
    public void testTurnPlayerLeft() {
        james.turnLeft();
        assertEquals(Direction.WEST, james.isFacing());
        james.turnLeft();
        assertEquals(Direction.SOUTH, james.isFacing());
        james.turnLeft();
        assertEquals(Direction.EAST, james.isFacing());
        james.turnLeft();
        assertEquals(Direction.NORTH, james.isFacing());
    }

    @Test
    public void testPlayerCanSee() {
        MapSpace defaultSpace = new MapSpace();
        PlayerView expectedView = defaultSpace.getPlayerView(james.isFacing());
        assertEquals(expectedView, james.getCurrentView());
    }

}