package game;

import game.exceptions.WorldBoundary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Game {
    private List<Player> players = new ArrayList<>();
    private List<World> worlds = new ArrayList<>();
    private boolean initialized;
    private String message = "Initialize game:";

    public Game(){
        World newWorld = new World();
        Player newPlayer = new Player(newWorld.getMap());
        worlds.add(newWorld);
        players.add(newPlayer);
    }

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

    public boolean isInitialized() {
        return initialized;
    }

    public String getMessage() {
        return message;
    }

    public void parseCommand(Command command) {
        if(null != command){
            String[] commandString = command.getCommand().split("\\s+");
            if(commandString[0].equalsIgnoreCase("go")){
                try {
                    movePlayer(commandString[1]);
                } catch (WorldBoundary worldBoundary) {
                    message = worldBoundary.getMessage();
                }
            } else {
                message = "Sorry, I didn't understand.";
            }
        }
    }

    private void movePlayer(String direction) throws WorldBoundary {
        Player player = players.get(0);
        switch (direction){
            case "straight":
                player.moveForward();
                break;
            case "forward":
                player.moveForward();
                break;
            case "right":
                player.moveRight();
                break;
            case "left":
                player.moveLeft();
                break;
            case "back":
                player.moveBackwards();
                break;
            default:
                message = "Sorry, I didn't understand.";
                return;
        }
        message = getSpaceDescription(player);
    }

    private String getSpaceDescription(Player player) {
        return player.getWorldMap().getSpaceAt(player.getPosition()).getPlayerView(player.isFacing()).getDescription();
    }
}
