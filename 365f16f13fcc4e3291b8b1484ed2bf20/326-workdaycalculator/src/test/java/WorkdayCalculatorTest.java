import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class WorkdayCalculatorTest {

    @Test
    public void testNormalWorkdays() {
        Calendar start = new GregorianCalendar(2025, Calendar.OCTOBER, 8);
        Calendar end = new GregorianCalendar(2025, Calendar.OCTOBER, 10);
        assertEquals(3, WorkdayCalculator.calculateWorkdays(start, end));
    }

    @Test
    public void testHolidayWithAdjustment() {
        Calendar start = new GregorianCalendar(2025, Calendar.SEPTEMBER, 27);
        Calendar end = new GregorianCalendar(2025, Calendar.SEPTEMBER, 30);
        assertEquals(3, WorkdayCalculator.calculateWorkdays(start, end));
    }

    @Test
    public void testSingleWorkday() {
        Calendar date = new GregorianCalendar(2025, Calendar.JANUARY, 25);
        assertEquals(1, WorkdayCalculator.calculateWorkdays(date, date));
    }

    @Test
    public void testComplexScenario() {
        Calendar start = new GregorianCalendar(2025, Calendar.MAY, 1);
        Calendar end = new GregorianCalendar(2025, Calendar.MAY, 7);
        assertEquals(3, WorkdayCalculator.calculateWorkdays(start, end));
    }

    @Test
    public void testZeroDays1() {
        Calendar date = new GregorianCalendar(2025, Calendar.OCTOBER, 13);
        assertEquals(1, WorkdayCalculator.calculateWorkdays(date, date));
    }

    @Test
    public void testZeroDays() {
        Calendar date = new GregorianCalendar(2025, Calendar.OCTOBER, 12);
        assertEquals(0, WorkdayCalculator.calculateWorkdays(date, date));
    }

}