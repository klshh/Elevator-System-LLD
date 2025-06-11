package ElevatorCommandRequest;

import EnumUtil.Directions;
import Utilities.Elevator;

public class InternalRequestCommand implements RequestCommand {
    private Elevator elevator;
    private int floor;
    private int destination;

    public InternalRequestCommand(Elevator elevator, int floor) {
        this.elevator = elevator;
        this.floor = floor;
    }

    @Override
    public void execute() {
        System.out.println("Passenger entered at floor " + floor + " (Destination: " + destination + ")");
        elevator.addRequest(destination, elevator.getDirection());
    }
}
