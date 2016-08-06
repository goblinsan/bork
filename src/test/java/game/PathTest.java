package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PathTest {

    @Test
    public void testDefaultIsWalkableAndStraight() {
        Path testObject = new Path();
        assertTrue(testObject.isPassable());
        assertEquals(Path.PathType.STRAIGHT, testObject.getType());
    }
}