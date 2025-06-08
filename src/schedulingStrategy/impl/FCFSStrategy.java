package schedulingStrategy.impl;

import schedulingStrategy.ISchedulingStrategy;
import units.Elevator;

public class FCFSStrategy implements ISchedulingStrategy {
    @Override
    public int getNextFloor(Elevator e) {
        return 0;
    }
}
