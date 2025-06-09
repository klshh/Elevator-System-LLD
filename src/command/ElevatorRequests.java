package command;

import controller.ElevatorController;
import utils.Direction;

public class ElevatorRequests implements ElevatorCommand {
    private int elevatorId;
    private int floor;
    private ElevatorController controller;
    private Direction elevatorDirection;
    private Boolean isInternalRequest;

    public ElevatorRequests(int elevatorId, int floor, Direction elevatorDirection, Boolean isInternalRequest) {
        this.elevatorId = elevatorId;
        this.floor = floor;
        this.controller = new ElevatorController();
        this.elevatorDirection = elevatorDirection;
        this.isInternalRequest = isInternalRequest;
    }

    @Override
    public void execute() {
        if(isInternalRequest){
            controller.requestFloor(elevatorId,floor);
        } else {
            controller.requestElevator(elevatorId,elevatorDirection,floor);
        }
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(int elevatorId) {
        this.elevatorId = elevatorId;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ElevatorController getController() {
        return controller;
    }

    public void setController(ElevatorController controller) {
        this.controller = controller;
    }

    public Direction getElevatorDirection() {
        return elevatorDirection;
    }

    public void setElevatorDirection(Direction elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }

    public Boolean getInternalRequest() {
        return isInternalRequest;
    }

    public void setInternalRequest(Boolean internalRequest) {
        isInternalRequest = internalRequest;
    }
}
