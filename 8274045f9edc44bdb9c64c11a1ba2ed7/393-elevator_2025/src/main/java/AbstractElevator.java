
import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractElevator implements Elevator {
    protected final String id;
    protected int currentFloor;
    protected final Set<Integer> accessibleFloors;
    protected final List<Integer> path = new ArrayList<>();

    public AbstractElevator(String id, int startFloor, Set<Integer> accessibleFloors) {
        this.id = id;
        this.currentFloor = startFloor;
        this.accessibleFloors = accessibleFloors;
        this.path.add(currentFloor);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getCurrentFloor() {
        return currentFloor;
    }

    @Override
    public boolean canReach(int floor) {
        return accessibleFloors.contains(floor);
    }

    @Override
    public boolean canExecute(Request request) {
        return canReach(request.from) && canReach(request.to);
    }

    @Override
    public void moveTo(int floor) {
        if (floor != currentFloor) {
            currentFloor = floor;
            path.add(floor);
        }
    }

    @Override
    public void handleRequest(Request request, boolean isExecutor) {
        moveTo(request.from);
        if (isExecutor) {
            moveTo(request.to);
        }
    }

    @Override
    public String getPathString() {
        return id + ":" + String.join(";", path.stream().map(String::valueOf).collect(Collectors.toList()));
    }
}