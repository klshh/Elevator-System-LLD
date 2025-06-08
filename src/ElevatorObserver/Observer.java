package ElevatorObserver;

import units.Elevator;
import utils.ElevatorState;

public interface Observer {
    void onElevatorFloorChange(Elevator elevator, int floor);
    void onElevatorStateChange(Elevator elevator, ElevatorState elevatorState);
}
