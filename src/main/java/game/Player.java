package game;

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

    public void setPosition(int[] position) {
        this.position = position;
    }

}
