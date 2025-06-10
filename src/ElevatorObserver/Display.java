package ElevatorObserver;

public class Display implements Observer{
    private int elevatorId;

    public Display() {

    }

    @Override
    public void update(int floor, String direction) {
        String dir = (direction == null) ? "IDLE" : direction;
        System.out.println("[Elevator " + elevatorId + "] Floor: " + floor + " | Direction: " + dir);
    }
}
