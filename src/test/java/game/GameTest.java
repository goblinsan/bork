package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    Game testObject = new Game();

    @Before
    public void testWorldSetup() {
        World world = new World();
        testObject.addWorld(world);
        Player player = new Player();
        player.setMap(world.getMap());
        testObject.addPlayer(player);
    }

    @Test
    public void testNotInitialized() {
        assertFalse(testObject.isInitialized());
    }

    @Test
    public void testPrintMessage() {
        assertEquals("Initialize game:", testObject.getMessage());

    }

    @Test
    public void testGameHas1Player() {
        assertEquals(1, testObject.getPlayers().size());
    }

    @Test
    public void testGameHas1World() {
        assertEquals(1, testObject.getWorlds().size());
    }

    @Test
    public void testWorldAndPlayerMapSame() {
        assertSame(testObject.getWorlds().get(0).getMap(), testObject.getPlayers().get(0).getMap());
    }
}
