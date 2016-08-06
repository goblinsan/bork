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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerView that = (PlayerView) o;

        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        return background != null ? background.equals(that.background) : that.background == null;

    }

    @Override
    public int hashCode() {
        int result = path != null ? path.hashCode() : 0;
        result = 31 * result + (background != null ? background.hashCode() : 0);
        return result;
    }
}
