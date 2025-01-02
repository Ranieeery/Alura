package dev.raniery.ecommerce;

import java.math.BigDecimal;

public class Pricing {
    public static void calculatePrice(int tokensCount) {
        BigDecimal price = new BigDecimal(tokensCount)
            .divide(new BigDecimal(1000000))
            .multiply(new BigDecimal(0.50));

        System.out.println("This request costs: $" + price);
    }
}
