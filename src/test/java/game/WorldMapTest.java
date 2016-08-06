package game;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WorldMapTest {

    WorldMap testObject = new WorldMap();

    @Test
    public void testWorldMapHas64Spaces() {
        assertEquals(8, testObject.getGrid().size());
        assertEquals(8, testObject.getGrid().get(0).size());
        assertEquals(8, testObject.getGrid().get(7).size());
    }

    @Test
    public void testGetMapBoundaries() {
        int[] expectedBounds = {8,8};
        assertTrue(Arrays.equals(expectedBounds,testObject.getBoundaries()));
    }

    @Test
    public void testGetSpaceAtPosition() {
        int[] position = {3,4};
        assertNotNull(testObject.getSpaceAt(position));
    }
}