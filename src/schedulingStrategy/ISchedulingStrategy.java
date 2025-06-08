package schedulingStrategy;

import units.Elevator;

public interface ISchedulingStrategy {
    int getNextFloor(Elevator e);
}
