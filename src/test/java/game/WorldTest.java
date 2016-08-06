package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WorldTest {
    World testObject = new World();

    @Test
    public void testWorldHas1Player() {
        assertEquals(1, testObject.getPlayers().size());
    }

    @Test
    public void testWorldHasMap() {
        assertNotNull(testObject.getMap());
    }
}