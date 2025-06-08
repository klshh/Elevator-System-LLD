package schedulingStrategy.impl;

import schedulingStrategy.ISchedulingStrategy;
import units.Elevator;

public class ScanSchedulingStrategy implements ISchedulingStrategy {
    @Override
    public int getNextFloor(Elevator e) {
        return 0;
    }
}
