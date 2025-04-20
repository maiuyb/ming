import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

public class FindMinDifferenceTest {

    @Test
    public void testAdjacentTimes() {
        List<String> timePoints = Arrays.asList("12:00", "12:01");
        assertEquals(1, FindMinDifference.findMinDifference(timePoints));
    }

    @Test
    public void testMultipleTimes() {
        List<String> timePoints = Arrays.asList("01:00", "13:00", "21:30", "06:45");
        assertEquals(210, FindMinDifference.findMinDifference(timePoints));
    }

    @Test
    public void testCrossMidnightMinDiff() {
        List<String> timePoints = Arrays.asList("23:59", "00:00");
        assertEquals(1, FindMinDifference.findMinDifference(timePoints));
    }

    @Test
    public void testIdenticalTimes() {
        List<String> timePoints = Arrays.asList("00:00", "00:00");
        assertEquals(0, FindMinDifference.findMinDifference(timePoints));
    }

    @Test
    public void testMaxPossibleDiff() {
        List<String> timePoints = Arrays.asList("00:00", "12:00");
        assertEquals(720, FindMinDifference.findMinDifference(timePoints));
    }

    @Test
    public void testMultipleIdenticalTimes() {
        List<String> timePoints = Arrays.asList("12:34", "12:34", "12:34");
        assertEquals(0, FindMinDifference.findMinDifference(timePoints));
    }

    @Test
    public void testExactly12HoursDiff() {
        List<String> timePoints = Arrays.asList("12:00", "00:00");
        assertEquals(720, FindMinDifference.findMinDifference(timePoints));
    }

    @Test
    public void testAllNearMidnight() {
        List<String> timePoints = Arrays.asList("23:50", "23:55", "00:05", "00:10");
        assertEquals(5, FindMinDifference.findMinDifference(timePoints));
    }


}