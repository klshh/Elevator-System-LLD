package schedulingStrategy.impl;

import schedulingStrategy.ISchedulingStrategy;
import units.Elevator;

public class LookSchedulingStrategy implements ISchedulingStrategy {
    @Override
    public int getNextFloor(Elevator e) {
        return 0;
    }
}
