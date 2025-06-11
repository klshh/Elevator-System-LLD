package SchedulingStrategy;

import EnumUtil.Directions;
import Utilities.Elevator;

import java.util.PriorityQueue;

public class LookStrategyScheduler implements Scheduler{

    @Override
    public Integer getNextFloor(Elevator elevator) {
        if (elevator.getDirection() == Directions.UP) {
            if (!elevator.getUpQueue().isEmpty()) {
                return elevator.getUpQueue().poll();
            } else if (!elevator.getDownQueue().isEmpty()) {
                elevator.setDirection(Directions.DOWN);
                return elevator.getDownQueue().poll();
            }
        } else if (elevator.getDirection() == Directions.DOWN) {
            if (!elevator.getDownQueue().isEmpty()) {
                return elevator.getDownQueue().poll();
            } else if (!elevator.getUpQueue().isEmpty()) {
                elevator.setDirection(Directions.UP);
                return elevator.getUpQueue().poll();
            }
        } else {
            // Elevator is IDLE, choose direction based on availability
            if (!elevator.getUpQueue().isEmpty()) {
                elevator.setDirection(Directions.UP);
                return elevator.getUpQueue().poll();
            } else if (!elevator.getDownQueue().isEmpty()) {
                elevator.setDirection(Directions.DOWN);
                return elevator.getDownQueue().poll();
            }
        }

        elevator.setDirection(Directions.IDLE);
        return null;
    }
}
