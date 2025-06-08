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

    private void notifyFloorChange(ElevatorState state){
        for(Observer observer : observeList) {
            observer.onElevatorFloorChange(this,currentFloor);
        }
    }
}
