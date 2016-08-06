package game;

import game.exceptions.BackpackIsFull;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BackpackTest {
    Backpack testObject = new Backpack();

    @Test
    public void testInitialSizeIs8() {
        assertEquals(8, testObject.getSize());
    }

    @Test
    public void testSizeUpgrade() {
        int newSlots = 4;
        testObject.addCapacity(newSlots);
        assertEquals(12, testObject.getSize());
    }

    @Test
    public void testAddPortableItem() throws BackpackIsFull {
        Flashlight flashlight = new Flashlight();
        testObject.addItem(flashlight);
        assertEquals(7, testObject.getRemainingCapacity());
        Flashlight anotherFlashlight = new Flashlight();
        testObject.addItem(anotherFlashlight);
        assertEquals(6, testObject.getRemainingCapacity());
        assertTrue(testObject.getContents().contains(flashlight));
        assertTrue(testObject.getContents().contains(anotherFlashlight));
    }

    @Test(expected = BackpackIsFull.class)
    public void testAddItemFailsWhenFull() throws BackpackIsFull {
        Flashlight flashlight = new Flashlight();
        testObject.addItems(Arrays.asList(flashlight,flashlight,flashlight,flashlight,flashlight,flashlight,flashlight,flashlight));
        testObject.addItem(flashlight);
    }

    @Test(expected = BackpackIsFull.class)
    public void testAddItemsFailsWhenFull() throws BackpackIsFull {
        Flashlight flashlight = new Flashlight();
        testObject.addItems(Arrays.asList(flashlight,flashlight,flashlight,flashlight,flashlight,flashlight,flashlight,flashlight,flashlight));
    }
}
