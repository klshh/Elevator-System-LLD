package ElevatorObserver;

import units.Elevator;
import utils.ElevatorState;

public class ElevatorDisplay implements Observer{
    @Override
    public void onElevatorFloorChange(Elevator elevator, int floor) {
        System.out.println("Elevator Floor changes to: " + floor);
    }

    @Override
    public void onElevatorStateChange(Elevator elevator, ElevatorState elevatorState) {
        System.out.println("Elevator state changes to: " + elevatorState.name());
    }
}
