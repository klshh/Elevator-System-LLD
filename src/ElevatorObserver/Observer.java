package ElevatorObserver;

import EnumUtil.Directions;

public interface Observer {
    void update(int floor, String directions);
}
