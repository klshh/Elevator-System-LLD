import EnumUtil.Directions;

public class Request {
    private int floor;
    private Directions directions;

    public Request(int floor, Directions directions) {
        this.floor = floor;
        this.directions = directions;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Directions getDirections() {
        return directions;
    }

    public void setDirections(Directions directions) {
        this.directions = directions;
    }
}
