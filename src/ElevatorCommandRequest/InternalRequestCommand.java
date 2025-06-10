package ElevatorCommandRequest;

import EnumUtil.Directions;
import Utilities.Elevator;

public class InternalRequestCommand implements RequestCommand {
    private Elevator elevator;
    private int floor;

    public InternalRequestCommand(Elevator elevator, int floor) {
        this.elevator = elevator;
        this.floor = floor;
    }

    @Override
    public void execute() {
        int currentFloor = elevator.getCurrentFloor();
        if(floor > currentFloor){
            elevator.addRequest(floor, Directions.UP);
        } else if(floor < currentFloor) {
            elevator.addRequest(floor,Directions.DOWN);
        }
    }
}
