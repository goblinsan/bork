package game;

import game.exceptions.WorldBoundary;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class PlayerMotionTest {

    WorldMap map = new WorldMap();
    Player james = new Player(map);

    @Test
    public void testPlayerStartsOnSpace0x0() {
        int[] expectedPostion = {0,0};
        assertTrue(Arrays.equals(expectedPostion, james.getPosition()));
    }

    @Test
    public void testCanMovePlayer() throws WorldBoundary {
        int[] newPostion = {6,7};
        james.setPosition(newPostion);
        assertTrue(Arrays.equals(newPostion, james.getPosition()));
    }

    @Test
    public void testPlayerCanMove() throws WorldBoundary {
        int[] startingPostion = {2,6};
        james.setPosition(startingPostion);
        james.move(1,1);
        int[] expectedPostion = {3,7};
        assertTrue(Arrays.equals(expectedPostion,james.getPosition()));
        int[] nextExpectedPostion = {1,5};
        james.move(-2,-2);
        assertTrue(Arrays.equals(nextExpectedPostion,james.getPosition()));
    }

    @Test
    public void testZeroYMove() throws WorldBoundary {
        int[] nextExpectedPostion = {1,0};
        james.move(1,0);
        assertTrue(Arrays.equals(nextExpectedPostion,james.getPosition()));
    }

    @Test
    public void testZeroXMove() throws WorldBoundary {
        int[] nextExpectedPostion = {0,1};
        james.move(0,1);
        assertTrue(Arrays.equals(nextExpectedPostion,james.getPosition()));
    }

    @Test(expected = WorldBoundary.class)
    public void testPlayerCantMoveNegativeBoundary() throws WorldBoundary {
        james.move(-1,-1);
    }

    @Test(expected = WorldBoundary.class)
    public void testPlayerCantMoveOneNegativeBoundary() throws WorldBoundary {
        james.move(-1,0);
    }

    @Test(expected = WorldBoundary.class)
    public void testPlayerCantMovePositiveBoundary() throws WorldBoundary {
        james.move(8,8);
    }

    @Test(expected = WorldBoundary.class)
    public void testPlayerCantMoveOnePositiveBoundary() throws WorldBoundary {
        james.move(1,8);
    }
}