package game.exceptions;

public class BackpackIsFull extends Exception {

    public BackpackIsFull() {
    }

    public BackpackIsFull(String message) {
        super(message);
    }

    public BackpackIsFull(String message, Throwable cause) {
        super(message, cause);
    }

    public BackpackIsFull(Throwable cause) {
        super(cause);
    }
}
