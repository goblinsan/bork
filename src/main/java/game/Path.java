package game;

public class Path {
    private boolean passable;
    private PathType type;

    public Path() {
        this.passable = true;
        this.type = PathType.STRAIGHT;
    }

    public boolean isPassable() {
        return passable;
    }

    public PathType getType() {
        return type;
    }

    enum PathType {STRAIGHT, FORKED, RIGHT_TURN, LEFT_TURN, IMPASSABLE}
}
