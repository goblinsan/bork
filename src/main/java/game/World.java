package game;

import java.util.ArrayList;
import java.util.List;

public class World {
    private WorldMap worldMap;
    private List<Player> players;

    public World() {
        worldMap = new WorldMap();
        players = new ArrayList<>();
        Player player = new Player(worldMap);
        players.add(player);
    }

    public WorldMap getMap() {
        return worldMap;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
