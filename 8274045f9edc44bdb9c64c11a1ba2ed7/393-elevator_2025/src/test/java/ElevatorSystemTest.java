import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.*;


public class ElevatorSystemTest {

    @Test
    public void testCase1() {
        String init = "A:4;B:2;C:1;D:1;E:-1;F:1";
        String[] tasks = {"4:-1", "1:12"};

        List<String> expected = Arrays.asList(
            "A:4;1",
            "B:2;4",
            "C:1;12",
            "D:1",
            "E:-1;4;1",
            "F:1;4;-1;1"
        );

        List<String> actual = ElevatorSystem.runSimulation(init, tasks);
        assertEquals(expected, actual);
    }
    
}
