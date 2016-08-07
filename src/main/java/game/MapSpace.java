package game;

import java.util.HashMap;
import java.util.Map;

import static game.Direction.*;

public class MapSpace {
    private PlayerView defaultPlayerView;
    private Map<Direction, PlayerView> views;

    public MapSpace() {
        defaultPlayerView = new PlayerView();
        views = new HashMap<>();
        views.put(NORTH, defaultPlayerView);
        views.put(EAST, defaultPlayerView);
        views.put(SOUTH, defaultPlayerView);
        views.put(WEST, defaultPlayerView);
    }

    public PlayerView getPlayerView(Direction facing) {
        if (null == facing){
            return defaultPlayerView;
        }
        return views.get(facing);
    }
}
