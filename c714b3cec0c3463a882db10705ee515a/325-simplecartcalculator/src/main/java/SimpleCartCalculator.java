import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class SimpleCartCalculator {

    // 内部类定义商品条目
    static class CartItem {
        private final BigDecimal price;
        private final int quantity;

        public CartItem(String price, int quantity) {
            this.price = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
            this.quantity = quantity;
        }
    }

    public static BigDecimal calculateTotal(List<CartItem> items, String discount) {

        return null;
    }

}