package game;


public class PlayerView {
    private Path path = new Path();
    private String background = "You can't see very far ahead.";

    public Path getPath() {
        return path;
    }

    public String getBackground() {
        return background;
    }
}
