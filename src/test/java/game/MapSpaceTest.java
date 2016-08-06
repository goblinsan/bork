package game;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MapSpaceTest {
    MapSpace testObject = new MapSpace();

    @Test
    public void testMapSpaceHasPlayerView() {
        assertNotNull(testObject.getPlayerView());
    }
}