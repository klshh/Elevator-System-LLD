package controller;

import schedulingStrategy.ISchedulingStrategy;
import units.Elevator;
import units.Floors;

import java.util.List;

public class ElevatorController {
    private List<Elevator> elevators;
    private ISchedulingStrategy schedulingStrategy;
    private List<Floors> floors;
    private int currentElevatorId;
}
