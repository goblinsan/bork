package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    WorldMap map = new WorldMap();
    Player james = new Player(map);

    @Test
    public void testPlayerHasWorldMap() {
        assertNotNull(james.getMap());
    }

    @Test
    public void testPlayerHasBackpack() throws Exception {
        Backpack myBackpack = james.getBackpack();
        assertEquals(8, myBackpack.getSize());
        assertEquals(8, myBackpack.getRemainingCapacity());
        Flashlight flashlight = new Flashlight();
        james.getBackpack().addItem(flashlight);
        assertEquals(7, myBackpack.getRemainingCapacity());
        assertTrue(myBackpack.getContents().contains(flashlight));
    }

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
        assertNotNull(james.getCurrentView());
    }

    @Test
    public void testPlayerStartsOnSpace0x0() {
        int[] expectedPostion = {0,0};
        assertEquals(expectedPostion[0], james.getPosition()[0]);
        assertEquals(expectedPostion[1], james.getPosition()[1]);
    }

    @Test
    public void testCanMovePlayer() {
        int[] newPostion = {0,0};
        newPostion[0] = 6;
        newPostion[1] = 7;
        james.setPosition(newPostion);
        assertEquals(newPostion[0], james.getPosition()[0]);
        assertEquals(newPostion[1], james.getPosition()[1]);
    }
}