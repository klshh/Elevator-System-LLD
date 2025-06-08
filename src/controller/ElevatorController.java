package controller;

import schedulingStrategy.ISchedulingStrategy;
import schedulingStrategy.impl.ScanSchedulingStrategy;
import units.Elevator;
import units.Floors;
import utils.Direction;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private List<Elevator> elevators;
    private ISchedulingStrategy schedulingStrategy;
    private List<Floors> floors;
    private int currentElevatorId;

    public ElevatorController(int noOfFloors, int noOfElevators) {
        this.elevators = new ArrayList<>();
        this.schedulingStrategy = new ScanSchedulingStrategy();
        this.floors = new ArrayList<>();
        for(int i = 1;i<noOfElevators;i++){
            elevators.add(new Elevator(i));
        }
    }

    public ElevatorController() {
    }

    public void requestFloor(int elevatorId, int floor){

    }
    public void requestElevator(int elevatorId, Direction direction, int floor){

    }
}
