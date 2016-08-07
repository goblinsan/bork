package game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();
    private List<World> worlds = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public List<World> getWorlds() {
        return worlds;
    }

    public void addWorld(World world) {
        worlds.add(world);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
