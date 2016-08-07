package game;

public class World {
    private WorldMap worldMap;

    public World() {
        worldMap = new WorldMap();
    }

    public WorldMap getMap() {
        return worldMap;
    }

}
