package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerMapTest {

    PlayerMap testObject = new PlayerMap(new WorldMap());

    @Test
    public void initialSizeIs8x8() {
        assertEquals(8, testObject.getGrid().get(0).size());
        assertEquals(8, testObject.getGrid().size());
    }

    @Test
    public void firstSpaceIsVisitedDisplayNorth() {
        PlayerMapSpace testSpace = testObject.getGrid().get(0).get(0);
        assertTrue(testSpace.isVisited());
        assertTrue(testSpace.isCurrentLocation());
        testSpace.setDisplayChar(Direction.NORTH);
        assertEquals("^", testSpace.getDisplayChar());
    }
}