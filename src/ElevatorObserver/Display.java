package ElevatorObserver;

public class Display implements Observer{
    private int elevatorId;
    private int lastFloor = -1;
    private String lastDirection = "";

    public Display(int elevatorId) {
        this.elevatorId = elevatorId;
    }

    public Display() {

    }

    @Override
    public void update(int currentFloor, String direction) {
        if (currentFloor != lastFloor || !direction.equals(lastDirection)) {
            System.out.println("[Elevator " + elevatorId + "] Floor: " + currentFloor + " | Direction: " + direction);
            lastFloor = currentFloor;
            lastDirection = direction;
        }
    }
}
