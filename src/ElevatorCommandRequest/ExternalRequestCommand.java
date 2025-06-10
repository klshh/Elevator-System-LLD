package ElevatorCommandRequest;

import EnumUtil.Directions;
import Utilities.Elevator;
import controller.ElevatorController;

public class ExternalRequestCommand implements RequestCommand {
    private final int floor;
    private final Directions direction;
    private final ElevatorController controller;

    public ExternalRequestCommand(ElevatorController controller, int floor, Directions direction) {
        this.controller = controller;
        this.floor = floor;
        this.direction = direction;
    }

    @Override
    public void execute() {
        controller.handleExternalRequest(floor,direction);
    }
}
