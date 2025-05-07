import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class DecompressMessageTest {

    @Test
    public void testCase1() {
        String message = "3[a]";
        String expected = "aaa";
        assertEquals(expected, DecompressMessage.decompressMessage(message));
    }

    @Test
    public void testCase2() {
        String message = "3[a2[c]]";
        String expected = "accaccacc";
        assertEquals(expected, DecompressMessage.decompressMessage(message));
    }

    @Test
    public void testCase3() {
        String message = "3[a]2[xy]";
        String expected = "aaaxyxy";
        assertEquals(expected, DecompressMessage.decompressMessage(message));
    }

    @Test
    public void testCase4() {
        String message = "ab3[c]4[d]ef";
        String expected = "abcccddddef";
        assertEquals(expected, DecompressMessage.decompressMessage(message));
    }

    @Test
    public void testCase5() {
        String message = "10[c]";
        String expected = "cccccccccc";
        assertEquals(expected, DecompressMessage.decompressMessage(message));
    }

}
