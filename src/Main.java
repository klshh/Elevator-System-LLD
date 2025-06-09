import controller.ElevatorController;
import units.Building;
import units.Elevator;
import utils.Direction;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        step 1: create a building
        Building building = new Building("Office",10, 3);
//        step 2: create an elevator Controller
        ElevatorController elevatorController = building.getElevatorController();
//        step 3: take input from user
        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        while (running) {
            System.out.println("nSelect an option:");
            System.out.println("1. Request elevator (external)");
            System.out.println("2. Request floor (internal)");
            System.out.println("3. Simulate next step");
            System.out.println("4. Exit simulation");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Handle external elevator request
                    System.out.print("Enter elevator ID: ");
                    int externalElevatorId = scanner.nextInt();
                    elevatorController.setCurrentElevator(externalElevatorId); // Set the selected elevator
                    System.out.print("Enter floor number: ");
                    int floorNum = scanner.nextInt();
                    System.out.print("Direction (1 for UP, 2 for DOWN): ");
                    int dirChoice = scanner.nextInt();
                    Direction dir = dirChoice == 1 ? Direction.UP : Direction.DOWN;
                    elevatorController.requestElevator(externalElevatorId, dir, floorNum);
                    break;
                case 2:
                    // Handle internal elevator floor request
                    System.out.print("Enter elevator ID: ");
                    int elevatorId = scanner.nextInt();
                    elevatorController.setCurrentElevator(elevatorId); // Set the selected elevator
                    System.out.print("Enter destination floor: ");
                    int destFloor = scanner.nextInt();
                    elevatorController.requestFloor(elevatorId, destFloor);
                    break;
                case 3:
                    // Simulate the next step in the system
                    System.out.println("Simulating next step...");
                    elevatorController.step(); // Perform the simulation step
                    displayElevatorStatus(elevatorController.getElevators()); // Display elevator statuses
                    break;
                case 4:
                    // Exit the simulation
                    running = false;
                    break;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close(); // Close the scanner to release resources
        System.out.println("Simulation ended"); // End of simulation
    }

    private static void displayElevatorStatus(List<Elevator> elevators) {
        System.out.println("nElevator Status:");
        for (Elevator elevator : elevators) {
            // Print details of each elevator, including current floor, direction, and
            // state
            System.out.println("Elevator " + elevator.getId() + ": Floor "
                    + elevator.getCurrentFloor() + ", Direction "
                    + elevator.getDirection() + ", State " + elevator.getElevatorState()
                    + ", Destinations " + elevator.getDestinationFloors());
        }
    }
}