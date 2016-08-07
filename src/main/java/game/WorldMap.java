package game;

import java.util.ArrayList;

public class WorldMap {
    ArrayList<ArrayList<MapSpace>> grid;

    public WorldMap() {
        ArrayList<MapSpace> emptySpaces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            emptySpaces.add(new MapSpace());
        }

        grid = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            grid.add(emptySpaces);
        }
    }

    public ArrayList<ArrayList<MapSpace>> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<ArrayList<MapSpace>> grid) {
        this.grid = grid;
    }

    public int[] getBoundaries() {
        int xLimit = grid.get(0).size();
        int yLimit = grid.size();
        return new int[]{xLimit,yLimit};
    }

    public MapSpace getSpaceAt(Coordinates position) {
        return grid.get(position.y).get(position.x);
    }
}
