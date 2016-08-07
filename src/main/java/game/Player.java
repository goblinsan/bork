package game;

import game.exceptions.WorldBoundary;

public class Player {

    private WorldMap map;
    private Backpack backpack = new Backpack();
    private Direction currentlyFacing = Direction.NORTH;
    private Coordinates position = new Coordinates(0,0);

    public WorldMap getMap() {
        return map;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public PlayerView getCurrentView() {
        return map.getGrid().get(position.y).get(position.x).getPlayerView(currentlyFacing);
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
        this.position = newPosition;
    }

    private boolean isAtTheWorldEdge(Coordinates newPosition) {
        try{
            map.grid.get(newPosition.y).get(newPosition.x);
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

    public void setMap(WorldMap map) {
        this.map = map;
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
}
