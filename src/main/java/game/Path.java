package game;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return passable == path.passable &&
                type == path.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(passable, type);
    }
}
