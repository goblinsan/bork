package game;

import game.exceptions.BackpackIsFull;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private int size = 8;
    private List<PortableThing> contents = new ArrayList<>();

    public int getSize() {
        return size;
    }

    public void addCapacity(int newSlots) {
        size = size + newSlots;
    }

    public void addItem(PortableThing someItem) throws BackpackIsFull {
        if (getRemainingCapacity() == 0) {
            throw new BackpackIsFull("No more room in your backpack.");
        }
        contents.add(someItem);
    }

    public int getRemainingCapacity() {
        return size - contents.size();
    }

    public List<PortableThing> getContents() {
        return contents;
    }

    public void addItems(List<PortableThing> someItems) throws BackpackIsFull {
        for (PortableThing p : someItems) {
            addItem(p);
        }
    }
}
