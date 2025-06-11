package ElevatorCommandRequest;

import EnumUtil.Directions;
import Utilities.Elevator;
import Utilities.ElevatorController;

public class ExternalRequestCommand implements RequestCommand {
    private final int floor;
    private final Elevator elevator;
    private final Directions direction;

    public ExternalRequestCommand(int floor, Elevator elevator, Directions direction) {
        this.floor = floor;
        this.elevator = elevator;
        this.direction = direction;
    }

    @Override
    public void execute() {
        elevator.addRequest(floor, direction);
        System.out.println("External request: Floor " + floor + " (Direction: " + direction + ") assigned to Elevator " + elevator.getId());
    }
}
