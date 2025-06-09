package units;

import ElevatorObserver.Observer;
import command.ElevatorRequests;
import utils.Direction;
import utils.ElevatorState;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState elevatorState;
    private Queue<ElevatorRequests> requests;
    private List<Observer> observeList;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 1;
        this.direction = Direction.IDLE;
        this.elevatorState = ElevatorState.IDLE;
        this.requests = new LinkedList<>();
        this.observeList = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observeList.add(observer);
    }

    public void removeObserver(Observer observer) {
        observeList.remove(observer);
    }

    private void notifyStateChange(ElevatorState state) {
        for (Observer observer : observeList) {
            observer.onElevatorStateChange(this, state);
        }
    }

    private void notifyFloorChange(int floor){
        for(Observer observer : observeList) {
            observer.onElevatorFloorChange(this,floor);
        }
    }

    public void setState(ElevatorState newState) {
        this.elevatorState = newState;
        notifyStateChange(newState);
    }

    public void setDirection(Direction newDirection) {
        this.direction = newDirection;
    }

    public void addRequest(ElevatorRequests elevatorRequest){
        if(!requests.contains(elevatorRequest)){
            requests.add(elevatorRequest);
        }

        int requestFloor = elevatorRequest.getFloor();

        if(elevatorState.equals(ElevatorState.IDLE) && !requests.isEmpty()){
            if (currentFloor > requestFloor){
                direction = Direction.DOWN;
            } else if(currentFloor < requestFloor) {
                direction = Direction.UP;
            }
            setState(ElevatorState.MOVING);
        }
    }

    public void moveToNextStop(int nextStop){

        if(elevatorState != ElevatorState.MOVING){
            return;
        }

        while (currentFloor != nextStop) {
            // Update floor based on direction
            if (direction == Direction.UP) {
                currentFloor++;
            } else {
                currentFloor--;
            }

            notifyFloorChange(currentFloor);

            if(currentFloor == nextStop){
            completeArrival();
            return;
            }
        }

    }

        private void completeArrival() {
            setState(ElevatorState.STOP);
            requests.removeIf(elevatorRequests -> elevatorRequests.getFloor() == currentFloor);

            if(!requests.isEmpty()){
                setState(ElevatorState.MOVING);
            } else {
                direction = Direction.IDLE;
                setState(ElevatorState.IDLE);
            }
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public Queue<ElevatorRequests> getRequests() {
        return requests;
    }

    public void setRequests(Queue<ElevatorRequests> requests) {
        this.requests = requests;
    }

    public List<Observer> getObserveList() {
        return observeList;
    }

    public void setObserveList(List<Observer> observeList) {
        this.observeList = observeList;
    }

    public String getDestinationFloors() {
        List<Integer> requestList = new ArrayList<>();
        for(ElevatorRequests r : requests){
            requestList.add(r.getFloor());
        }
        return requestList.toString();
    }
}
