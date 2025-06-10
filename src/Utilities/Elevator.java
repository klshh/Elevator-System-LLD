package Utilities;

import ElevatorObserver.Observer;
import ElevatorObserver.Subject;
import EnumUtil.Directions;
import SchedulingStrategy.LookStrategyScheduler;
import SchedulingStrategy.Scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Elevator implements Subject, Runnable {
    private int id;
    private int currentFloor = 0;
    private Directions direction;
    private Scheduler schedulerStrategy;
    private List<Observer> observerList = new ArrayList<>();


    private final PriorityQueue<Integer> upQueue = new PriorityQueue<>();
    private final PriorityQueue<Integer> downQueue = new PriorityQueue<>(Collections.reverseOrder());

    public Elevator(Integer i) {
        this.id = i;
    }

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observerList){
            o.update(currentFloor,direction.name());
        }
    }

    public void addRequest(int floor, Directions dir) {
        if (dir == Directions.UP) upQueue.offer(floor);
        else downQueue.offer(floor);
    }

    public void moveToFloor(int targetFloor) {
        if (currentFloor == targetFloor) return;

        direction = (targetFloor > currentFloor) ? Directions.UP : Directions.DOWN;

        while (currentFloor != targetFloor) {
            currentFloor += (currentFloor < targetFloor) ? 1 : -1;

            // Notify observers ONCE per floor change
            notifyObservers();

            try {
                Thread.sleep(400); // Adjusted for better visibility
            } catch (InterruptedException ignored) {}
        }

        // Clear direction once reached
        direction = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public Scheduler getSchedulerStrategy() {
        return schedulerStrategy;
    }

    public void setSchedulerStrategy(Scheduler schedulerStrategy) {
        this.schedulerStrategy = schedulerStrategy;
    }

    public List<Observer> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }

    public PriorityQueue<Integer> getUpQueue() {
        return upQueue;
    }

    public PriorityQueue<Integer> getDownQueue() {
        return downQueue;
    }

    public void setScheduler(LookStrategyScheduler lookScheduler) {
        this.schedulerStrategy = lookScheduler;
    }

    public void setStrategy(LookStrategyScheduler lookStrategyScheduler) {
        this.schedulerStrategy = lookStrategyScheduler;
    }

    private boolean active = true;

    // Call this once after initializing to begin processing
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    // Main loop for the elevator: keeps checking and processing requests
    @Override
    public void run() {
        while (active) {
            // Use the scheduling strategy to process current requests
            if (schedulerStrategy != null) {
                schedulerStrategy.schedule(this);  // You define this logic in LookStrategyScheduler
            }

            try {
                Thread.sleep(500); // Wait before checking queues again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        active = false;
    }
}
