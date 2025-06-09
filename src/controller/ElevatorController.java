package controller;

import command.ElevatorRequests;
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
        for(int i = 1; i <= noOfElevators; i++){
            elevators.add(new Elevator(i));
        }

        for(int i = 1; i <= noOfFloors; i++){
            floors.add(new Floors(i));
        }
    }

    public ElevatorController() {
    }

    public void requestFloor(int elevatorId, int floor){
        Elevator selectedElevator = getElevatorById(elevatorId);
//        selectedElevator cant be null here as it is an internal request
        if(selectedElevator != null){
            System.out.println("Internal request: Elevator " + selectedElevator.getId()
                    + " to floor " + floor);
            Direction direction = floor > selectedElevator.getCurrentFloor() ? Direction.UP : Direction.DOWN;
            selectedElevator.addRequest(new ElevatorRequests(selectedElevator.getId(),floor,direction,true));
        }
    }

    private Elevator getElevatorById(Integer elevatorId) {
        for(Elevator e : elevators){
            if(elevatorId.equals(e.getId())){
                return e;
            }
        }
        return null;
    }

    public void requestElevator(int elevatorId, Direction direction, int floor){
        System.out.println(
                "External request: Floor " + floor + ", Direction " + direction);
        Elevator selectedElevator = getElevatorById(elevatorId);
        if(selectedElevator != null){
            selectedElevator.addRequest(new ElevatorRequests(selectedElevator.getId(),floor,direction,false));
            System.out.println("Assigned elevator " + selectedElevator.getId()
                    + " to floor " + floor);
        } else {
            // If no suitable elevator is found
            System.out.println("No elevator available for floor " + floor);
        }
    }

    public void setCurrentElevator(int elevatorId) {
        this.currentElevatorId = elevatorId;
    }

    public void step() {
        for(Elevator elevator : elevators){
            if(!elevator.getRequests().isEmpty()){
                int nextStop = schedulingStrategy.getNextFloor(elevator);

                if(elevator.getCurrentFloor() != nextStop){
                    elevator.moveToNextStop(nextStop);
                }
            }
        }
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public void setElevators(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public ISchedulingStrategy getSchedulingStrategy() {
        return schedulingStrategy;
    }

    public void setSchedulingStrategy(ISchedulingStrategy schedulingStrategy) {
        this.schedulingStrategy = schedulingStrategy;
    }

    public List<Floors> getFloors() {
        return floors;
    }

    public void setFloors(List<Floors> floors) {
        this.floors = floors;
    }

    public int getCurrentElevatorId() {
        return currentElevatorId;
    }

    public void setCurrentElevatorId(int currentElevatorId) {
        this.currentElevatorId = currentElevatorId;
    }
}
