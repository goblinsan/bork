package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlayerViewTest {

    PlayerView testObject = new PlayerView();

    @Test
    public void testViewDescribesPath() {
        assertNotNull(testObject.getPath());
    }

    @Test
    public void testViewDescribesDefaultBackground() {
        assertEquals("You can't see very far ahead.",testObject.getDescription());
    }

    @Test
    public void testAboveDefault() {
        assertEquals("Not much to see up there.", testObject.getAbove());
    }

    @Test
    public void testBelowDefault() {
        assertEquals("Nothing interesting down there.", testObject.getBelow());
    }
}