package game;

import game.exceptions.WorldBoundary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerMotionTest {

    Player james;

    @Before
    public void setUp() throws Exception {
        WorldMap map = new WorldMap();
        james = new Player();
        james.setMap(map);
    }

    @Test
    public void testPlayerStartsOnSpace0x0() {
        Coordinates expectedPostion = new Coordinates(0,0);
        assertEquals(expectedPostion, james.getPosition());
    }

    @Test
    public void testCanMovePlayer() throws WorldBoundary {
        Coordinates newPostion = new Coordinates(6,7);
        james.setPosition(newPostion);
        assertEquals(newPostion, james.getPosition());
    }

    @Test
    public void testPlayerCanMove() throws WorldBoundary {
        Coordinates startingPostion = new Coordinates(2,6);
        james.setPosition(startingPostion);
        james.move(1,1);
        Coordinates expectedPostion = new Coordinates(3,7);
        assertEquals(expectedPostion,james.getPosition());
        Coordinates nextExpectedPostion = new Coordinates(1,5);
        james.move(-2,-2);
        assertEquals(nextExpectedPostion,james.getPosition());
    }

    @Test
    public void testZeroYMove() throws WorldBoundary {
        Coordinates nextExpectedPostion = new Coordinates(1,0);
        james.move(1,0);
        assertEquals(nextExpectedPostion,james.getPosition());
    }

    @Test
    public void testZeroXMove() throws WorldBoundary {
        Coordinates nextExpectedPostion = new Coordinates(0,1);
        james.move(0,1);
        assertEquals(nextExpectedPostion,james.getPosition());
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

    @Test
    public void testPlayerCanTurnToDirection(){
        james.turnTo(Direction.SOUTH);
        assertEquals(Direction.SOUTH, james.isFacing());
    }

    @Test
    public void testPlayerCanTurnAround() {
        james.turnAround();
        assertEquals(Direction.SOUTH, james.isFacing());
    }

    @Test
    public void testPlayerCanMoveForward() throws WorldBoundary {
        james.turnAround();
        james.moveForward();
        Coordinates nextExpectedPostion = new Coordinates(0,1);
        assertEquals(nextExpectedPostion,james.getPosition());
    }
    @Test
    public void testPlayerCanMoveRight() throws WorldBoundary {
        james.moveRight();
        Coordinates nextExpectedPostion = new Coordinates(1,0);
        assertEquals(nextExpectedPostion,james.getPosition());
    }

    @Test
    public void testPlayerCanMoveLeft() throws WorldBoundary {
        james.turnAround();
        james.moveLeft();
        Coordinates nextExpectedPostion = new Coordinates(1,0);
        assertEquals(nextExpectedPostion,james.getPosition());
    }

    @Test
    public void testPlayerCanMoveBackward() throws WorldBoundary {
        james.moveBackwards();
        Coordinates nextExpectedPostion = new Coordinates(0,1);
        assertEquals(nextExpectedPostion,james.getPosition());
    }
}