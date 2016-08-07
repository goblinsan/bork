package game;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class WorldTest {
    World testObject = new World();

    @Test
    public void testWorldHasMap() {
        assertNotNull(testObject.getMap());
    }

}