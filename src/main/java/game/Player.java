package game;

import game.exceptions.WorldBoundary;

public class Player {

    private final WorldMap worldMap;
    private Backpack backpack = new Backpack();
    private Direction currentlyFacing = Direction.NORTH;
    private Coordinates position = new Coordinates(0,0);
    private PlayerMap playerMap;

    public Player(WorldMap worldMap){
        this.worldMap = worldMap;
        playerMap = new PlayerMap(worldMap);
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public PlayerView getCurrentView() {
        return worldMap.getGrid().get(position.y).get(position.x).getPlayerView(currentlyFacing);
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

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates newPosition) throws WorldBoundary {
        if(isAtTheWorldEdge(newPosition)){
            throw new WorldBoundary("You are at the edge of the world.");
        }
        playerMap.addSpace(position, newPosition, currentlyFacing);
        this.position = newPosition;
    }

    private boolean isAtTheWorldEdge(Coordinates newPosition) {
        try{
            worldMap.grid.get(newPosition.y).get(newPosition.x);
        }
        catch (IndexOutOfBoundsException e){
            return true;
        }
        return false;
    }

    public void move(int x, int y) throws WorldBoundary {
        Coordinates newPosition = new Coordinates(position.x+x, position.y+y);
        setPosition(newPosition);
    }

    public void turnTo(Direction direction) {
        currentlyFacing = direction;
    }

    public void turnAround() {
        turnLeft();
        turnLeft();
    }

    public void moveForward() throws WorldBoundary {
        switch (currentlyFacing){
            case NORTH:
                move(0,-1);
                return;
            case EAST:
                move(1,0);
                return;
            case SOUTH:
                move(0,1);
                return;
            case WEST:
                move(-1,0);
                return;
        }
    }

    public void moveRight() throws WorldBoundary {
        turnRight();
        moveForward();
    }

    public void moveLeft() throws WorldBoundary {
        turnLeft();
        moveForward();
    }

    public void moveBackwards() throws WorldBoundary {
        turnAround();
        moveForward();
    }

    public PlayerMap getPlayerMap() {
        return playerMap;
    }
}
