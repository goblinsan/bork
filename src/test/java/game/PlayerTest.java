package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    Player james;

    @Before
    public void setUp() throws Exception {
        WorldMap map = new WorldMap();
        james = new Player();
        james.setMap(map);
    }

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
}