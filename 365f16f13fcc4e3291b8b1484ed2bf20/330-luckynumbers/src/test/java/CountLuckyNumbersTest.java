import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class CountLuckyNumbersTest {

    @Test
    public void testCase1() {
        int L = 10;
        int R = 28;
        int expected = 13;
        assertEquals(expected, CountLuckyNumbers.countLuckyNumbers(L, R));
    }

    @Test
    public void testCase2() {
        int L = 107;
        int R = 107;
        int expected = 1;
        assertEquals(expected, CountLuckyNumbers.countLuckyNumbers(L, R));
    }

    @Test
    public void testCase3() {
        int L = 87;
        int R = 89;
        int expected = 2;
        assertEquals(expected, CountLuckyNumbers.countLuckyNumbers(L, R));
    }

    @Test
    public void testCase4() {
        int L = 50;
        int R = 100;
        int expected = 42;
        assertEquals(expected, CountLuckyNumbers.countLuckyNumbers(L, R));
    }

    @Test
    public void testCase5() {
        int L = 3123;
        int R = 21342;
        int expected = 18220;
        assertEquals(expected, CountLuckyNumbers.countLuckyNumbers(L, R));
    }

    @Test
    public void testCase6() {
        int L = 12;
        int R = 90;
        int expected = 62;
        assertEquals(expected, CountLuckyNumbers.countLuckyNumbers(L, R));
    }


}
