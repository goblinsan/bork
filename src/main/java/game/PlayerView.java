package game;


public class PlayerView {
    private Path path = new Path();
    private String description = "You can't see very far ahead.";
    private String above = "Not much to see up there.";
    private String below = "Nothing interesting down there.";

    public Path getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerView that = (PlayerView) o;

        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = path != null ? path.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public String getAbove() {
        return above;
    }

    public String getBelow() {
        return below;
    }
}
