package game;

import java.util.ArrayList;
import java.util.List;

public class PlayerMap {
    private List<List<PlayerMapSpace>> grid = new ArrayList<>();

    public PlayerMap(WorldMap worldMap) {
        PlayerMapSpace playerMapSpace = new PlayerMapSpace();
        playerMapSpace.setVisited(true);
        playerMapSpace.setCurrentLocation(true);
        List<PlayerMapSpace> firstRow = new ArrayList<>();
        firstRow.add(playerMapSpace);
        firstRow = addSpaces(firstRow, worldMap.getGrid().get(0).size()-1);
        grid.add(firstRow);
        for (int i = 0; i < worldMap.getGrid().size() - 1; i++) {
            List<PlayerMapSpace> newRow = new ArrayList<>();
            newRow = addSpaces(newRow, worldMap.getGrid().get(0).size());
            grid.add(newRow);
        }
    }

    public List<List<PlayerMapSpace>> getGrid() {
        return grid;
    }

    public void addSpace(Coordinates oldPosition, Coordinates newPosition, Direction currentlyFacing) {
        deactivateOldPosition(oldPosition);
        setNewPositionActiveAndVisited(newPosition, currentlyFacing);
    }

    private void setNewPositionActiveAndVisited(Coordinates newPosition, Direction currentlyFacing) {
        grid.get(newPosition.y).get(newPosition.x).setVisited(true);
        grid.get(newPosition.y).get(newPosition.x).setCurrentLocation(true);
        grid.get(newPosition.y).get(newPosition.x).setDisplayChar(currentlyFacing);
    }

    private void deactivateOldPosition(Coordinates oldPosition) {
        grid.get(oldPosition.y).get(oldPosition.x).setCurrentLocation(false);
    }

    private List<PlayerMapSpace> addSpaces(List<PlayerMapSpace> newRow, int i) {
        for (int j = 0; j < i; j++) {
            newRow.add(new PlayerMapSpace());
        }
        return newRow;
    }
}
