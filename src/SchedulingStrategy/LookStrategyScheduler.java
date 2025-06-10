package SchedulingStrategy;

import EnumUtil.Directions;
import Utilities.Elevator;

import java.util.PriorityQueue;

public class LookStrategyScheduler implements Scheduler{
    @Override
    public void schedule(Elevator elevator) {

        PriorityQueue<Integer> upQueue = elevator.getUpQueue();
        PriorityQueue<Integer> downQueue = elevator.getDownQueue();

        if (upQueue.isEmpty() && downQueue.isEmpty()) {
            elevator.setDirection(Directions.IDLE);
            return;
        }

        if (elevator.getDirection() == Directions.IDLE) {
            if (!upQueue.isEmpty() && elevator.getCurrentFloor() <= upQueue.peek()) {
                elevator.setDirection(Directions.UP);
            } else {
                elevator.setDirection(Directions.DOWN);
            }
        }  if (elevator.getDirection() == Directions.UP) {
            while (!upQueue.isEmpty()) {
                int nextFloor = upQueue.poll();
                elevator.moveToFloor(nextFloor);
            }
            if (!downQueue.isEmpty()) {
                elevator.setDirection(Directions.DOWN);
            } else {
                elevator.setDirection(Directions.IDLE);
            }
        } else if (elevator.getDirection() == Directions.DOWN) {
            while (!downQueue.isEmpty()) {
                int nextFloor = downQueue.poll();
                elevator.moveToFloor(nextFloor);
            }
            if (!upQueue.isEmpty()) {
                elevator.setDirection(Directions.UP);
            } else {
                elevator.setDirection(Directions.IDLE);
            }
        }
    }
}
