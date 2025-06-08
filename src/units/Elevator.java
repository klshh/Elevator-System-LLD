package units;

import ElevatorObserver.Observer;
import command.ElevatorRequests;
import utils.Direction;
import utils.ElevatorState;

import java.util.List;
import java.util.Queue;

public class Elevator {
    private int id;
    private Direction direction;
    private ElevatorState elevatorState;
    private Queue<ElevatorRequests> requests;
    private List<Observer> observeList;

}
