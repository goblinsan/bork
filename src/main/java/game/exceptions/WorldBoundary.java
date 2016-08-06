package game.exceptions;

public class WorldBoundary extends Throwable {
    public WorldBoundary() {
    }

    public WorldBoundary(String message) {
        super(message);
    }

    public WorldBoundary(String message, Throwable cause) {
        super(message, cause);
    }

    public WorldBoundary(Throwable cause) {
        super(cause);
    }

    public WorldBoundary(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
