import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class SimpleCartCalculatorTest {

    @Test
    public void testNormalCalculation() {
        List<SimpleCartCalculator.CartItem> items = Arrays.asList(
                new SimpleCartCalculator.CartItem("10.00", 2),
                new SimpleCartCalculator.CartItem("20.50", 1)
        );
        BigDecimal result = SimpleCartCalculator.calculateTotal(items, "0.20");
        assertEquals(new BigDecimal("32.40"), result);
    }

    @Test
    public void testDecimalPrecision() {
        List<SimpleCartCalculator.CartItem> items = Arrays.asList(
                new SimpleCartCalculator.CartItem("9.995", 1) // 自动四舍五入为10.00
        );
        BigDecimal result = SimpleCartCalculator.calculateTotal(items, "0.10");
        assertEquals(new BigDecimal("9.00"), result); // 10.00 * 0.9=9.00
    }

    // ==================== 边界条件测试 ====================
    @Test
    public void testMaxQuantity() {
        List<SimpleCartCalculator.CartItem> items = Arrays.asList(
                new SimpleCartCalculator.CartItem("1.00", 99)
        );
        BigDecimal result = SimpleCartCalculator.calculateTotal(items, "0.00");
        assertEquals(new BigDecimal("99.00"), result);
    }


    // ==================== 异常场景测试 ====================
    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrice() {
        new SimpleCartCalculator.CartItem("-5.00", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuantityZero() {
        new SimpleCartCalculator.CartItem("10.00", 0);
    }




    @Test
    public void testZeroPriceItem() {
        List<SimpleCartCalculator.CartItem> items = Arrays.asList(
                new SimpleCartCalculator.CartItem("0.00", 5)
        );
        BigDecimal result = SimpleCartCalculator.calculateTotal(items, "0.50");
        assertEquals(new BigDecimal("0.00"), result);
    }

}