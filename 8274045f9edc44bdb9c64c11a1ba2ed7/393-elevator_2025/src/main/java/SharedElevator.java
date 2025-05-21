
import java.util.*;

public class SharedElevator {
    private final List<Elevator> elevators;

    public SharedElevator(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public Optional<Elevator> selectResponder(int targetFloor) {
        // TODO: 此处写共享电梯选择当前响应者的逻辑，返回被选中的电梯
        return Optional.empty();
    }

    public List<Elevator> getAll() {
        return elevators;
    }
}