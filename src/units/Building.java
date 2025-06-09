package units;

import controller.ElevatorController;

public class Building {
    private String name;
    private int floor;
    private ElevatorController elevatorController;

    public Building(String name, int floor, int noOfElevators) {
        this.name = name;
        this.floor = floor;
        this.elevatorController = new ElevatorController(floor,noOfElevators);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ElevatorController getElevatorController() {
        return elevatorController;
    }

    public void setElevatorController(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }
}
