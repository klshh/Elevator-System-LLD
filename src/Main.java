import ElevatorObserver.Display;
import EnumUtil.Directions;
import SchedulingStrategy.LookStrategyScheduler;
import Utilities.Elevator;
import Utilities.ElevatorController;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        List<Elevator> elevators = new ArrayList<>();
        ElevatorController controller = new ElevatorController(elevators);

        // Step 1: Initialize elevators
        for (int i = 0; i < 3; i++) {
            Elevator elevator = new Elevator(i);
            elevator.setSchedulerStrategy(new LookStrategyScheduler());
            elevator.addObserver(new Display(i));
            elevator.start(); // Start elevator thread
            elevators.add(elevator);
        }

        // Step 2: Send External Requests
        controller.sendExternalRequest(3, Directions.UP);   // Will later have a destination
        controller.sendExternalRequest(1, Directions.UP);
        controller.sendExternalRequest(9, Directions.DOWN); // Will later have a destination
        controller.sendExternalRequest(4, Directions.DOWN);

        // Step 3: Send Internal Requests (Simulate after passengers enter)
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                controller.sendInternalRequest(3, 7); // From floor 3 to 7
                controller.sendInternalRequest(9, 2); // From floor 9 to 2
                controller.sendInternalRequest(1, 5); // From floor 1 to 5
                controller.sendInternalRequest(4, 0); // From floor 4 to 0
            }
        }, 2000); // Delay to simulate time between entry and pressing destination
    }
}
