
import java.util.*;

public class Dispatcher {
    private final Map<String, Elevator> elevators; // Ensure the map is parameterized with Elevator
    private final SharedElevator shared;

    public Dispatcher(Map<String, Elevator> elevators, SharedElevator shared) {
        this.elevators = elevators;
        this.shared = shared;
    }

    public void process(Request request) {
        // TODO: 此处实现调度逻辑
        // TODO: 筛选出可响应者
        // TODO: 筛选出可执行者
        // TODO: 选出最优电梯作为最终执行者
        // TODO: 执行handleRequest调用
    }

    public List<Elevator> getAllElevators() {
        return new ArrayList<>(elevators.values());
    }
}
