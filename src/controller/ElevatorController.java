package controller;

import EnumUtil.Directions;
import Utilities.Elevator;

import java.util.List;

public class ElevatorController {
    private final List<Elevator> elevators;

    public ElevatorController(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public void handleExternalRequest(int requestedFloor, Directions direction) {
        Elevator selectedElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            // Select IDLE elevator or elevator going in the same direction
            if (elevator.getDirection() == null || elevator.getDirection() == direction) {
                int distance = Math.abs(elevator.getCurrentFloor() - requestedFloor);
                if (distance < minDistance) {
                    minDistance = distance;
                    selectedElevator = elevator;
                }
            }
        }
    }
}
