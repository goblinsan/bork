package game;

public class PlayerMapSpace {
    private boolean visited;
    private boolean currentLocation;
    private String displayChar = "";

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getDisplayChar() {
        return displayChar;
    }

    public void setDisplayChar(Direction facing) {
        switch (facing){
            case NORTH:
                displayChar = "^";
                break;
            case EAST:
                displayChar = ">";
                break;
            case SOUTH:
                displayChar = "v";
                break;
            case WEST:
                displayChar = "<";
                break;
            default:
                displayChar = "X";
                break;
        }
    }

    public boolean isCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(boolean currentLocation) {
        this.currentLocation = currentLocation;
    }
}
