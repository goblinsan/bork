package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorldTest {
    World testObject = new World();

    @Test
    public void testWorldMapHas64Spaces() {
        assertEquals(8, testObject.getMap().getGrid().size());
        assertEquals(8, testObject.getMap().getGrid().get(0).size());
        assertEquals(8, testObject.getMap().getGrid().get(7).size());
    }

    @Test
    public void testWorldHas1Player() {
        assertEquals(1, testObject.getPlayers().size());
    }

}