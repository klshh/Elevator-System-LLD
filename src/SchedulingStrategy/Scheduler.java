package SchedulingStrategy;

import Utilities.Elevator;

public interface Scheduler {
    Integer getNextFloor(Elevator elevator);
}
