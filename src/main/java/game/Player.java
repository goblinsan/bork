package game;

import game.exceptions.WorldBoundary;

public class Player {

    private final WorldMap map;
    private Backpack backpack = new Backpack();
    private Direction currentlyFacing = Direction.NORTH;
    private int[] position = {0,0};

    public Player(WorldMap worldMap) {
        this.map = worldMap;
    }

    public WorldMap getMap() {
        return map;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public PlayerView getCurrentView() {
        return map.getGrid().get(position[0]).get(position[1]).getPlayerView();
    }

    public Direction isFacing() {
        return currentlyFacing;
    }

    public void turnRight() {
        currentlyFacing = currentlyFacing.values()[(currentlyFacing.ordinal() + 1) %4];
    }

    public void turnLeft() {
        int faceValue = currentlyFacing.ordinal();
        currentlyFacing = faceValue == 0 ? Direction.WEST : currentlyFacing.values()[faceValue - 1];
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] newPosition) throws WorldBoundary {
        if(isAtTheWorldEdge(newPosition)){
            throw new WorldBoundary("You are at the edge of the world.");
        }
        this.position = newPosition;
    }

    private boolean isAtTheWorldEdge(int[] newPosition) {
        try{
            map.grid.get(newPosition[1]).get(newPosition[0]);
        }
        catch (IndexOutOfBoundsException e){
            return true;
        }
        return false;
    }

    public void move(int x, int y) throws WorldBoundary {
        int[] newPosition = {position[0]+x, position[1]+y};
        setPosition(newPosition);
    }
}
