import ElevatorCommandRequest.ExternalRequestCommand;
import ElevatorCommandRequest.InternalRequestCommand;
import ElevatorCommandRequest.RequestCommand;
import ElevatorObserver.Display;
import EnumUtil.Directions;
import SchedulingStrategy.LookStrategyScheduler;
import Utilities.Elevator;
import controller.ElevatorController;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Elevator> elevators = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Elevator elevator = new Elevator(i);
            elevator.setStrategy(new LookStrategyScheduler());
            elevator.start();
            elevators.add(elevator);
        }

        Display display = new Display();
        for (Elevator elevator : elevators) {
            elevator.addObserver(display);
        }

        ElevatorController controller = new ElevatorController(elevators);


        // 1. External requests: passengers pressing up/down on different floors
        RequestCommand ext1 = new ExternalRequestCommand(controller, 3, Directions.UP);   // assign elevator to go to floor 3
        RequestCommand ext2 = new ExternalRequestCommand(controller, 9, Directions.DOWN); // assign elevator to go to floor 9
        RequestCommand ext3 = new ExternalRequestCommand(controller, 1, Directions.UP);   // assign elevator to go to floor 1
        RequestCommand ext4 = new ExternalRequestCommand(controller, 4, Directions.DOWN); // assign elevator to go to floor 4

        ext1.execute();
        ext2.execute();
        ext3.execute();
        ext4.execute();


        // 2. Internal requests: passengers inside elevators select destination floors
        RequestCommand int1 = new InternalRequestCommand(elevators.get(0), 7); // Passenger in elevator 0 wants floor 7
        RequestCommand int2 = new InternalRequestCommand(elevators.get(1), 2); // Passenger in elevator 1 wants floor 2
        RequestCommand int3 = new InternalRequestCommand(elevators.get(2), 5); // Passenger in elevator 2 wants floor 5

        int1.execute();
        int2.execute();
        int3.execute();
    }
}