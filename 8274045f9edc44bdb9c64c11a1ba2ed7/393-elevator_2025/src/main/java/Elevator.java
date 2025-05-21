

public interface Elevator {
    String getId();
    int getCurrentFloor();
    boolean canReach(int floor);
    boolean canExecute(Request request);
    void moveTo(int floor);
    void handleRequest(Request request, boolean isExecutor);
    String getPathString();
}