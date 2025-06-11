package Utilities;

import ElevatorCommandRequest.ExternalRequestCommand;
import ElevatorCommandRequest.InternalRequestCommand;
import EnumUtil.Directions;
import ElevatorCommandRequest.RequestCommand;

import java.util.List;

public class ElevatorController {
    private final List<Elevator> elevators;

    public ElevatorController(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    // Handle external request like someone pressing UP/DOWN on a floor
    public void sendExternalRequest(int floor, Directions direction) {
        Elevator bestElevator = findBestElevator(floor, direction);
        if (bestElevator != null) {
            RequestCommand command = new ExternalRequestCommand(floor, bestElevator, direction);
            command.execute();
        }
    }

    // Handle internal request like someone pressing a button inside the elevator
    public void sendInternalRequest(int entryFloor, int destinationFloor) {
        for (Elevator elevator : elevators) {
            if (elevator.getCurrentFloor() == entryFloor) {
                RequestCommand command = new InternalRequestCommand(elevator,destinationFloor);
                System.out.println("Passenger entered at floor " + entryFloor + " (Destination: " + destinationFloor + ")");
                command.execute();
                return;
            }
        }
        System.out.println("No elevator currently at floor " + entryFloor + " for internal request.");
    }

    private Elevator findBestElevator(int floor, Directions direction) {
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int currentFloor = elevator.getCurrentFloor();
            int distance = Math.abs(currentFloor - floor);

            switch (elevator.getDirection()) {
                case IDLE:
                    // Prefer idle elevators
                    if (distance < minDistance) {
                        best = elevator;
                        minDistance = distance;
                    }
                    break;
                case UP:
                    if (direction == Directions.UP && floor >= currentFloor) {
                        if (distance < minDistance) {
                            best = elevator;
                            minDistance = distance;
                        }
                    }
                    break;
                case DOWN:
                    if (direction == Directions.DOWN && floor <= currentFloor) {
                        if (distance < minDistance) {
                            best = elevator;
                            minDistance = distance;
                        }
                    }
                    break;
            }
        }
        return best;
    }
}
