package dev.raniery.ecommerce.functions;

import java.math.BigDecimal;

public class Pricing {
    public static void calculatePrice(int tokensCount, String model) {
        BigDecimal priceToken;

        if (model.equals("chatgpt-4o-latest")) {
            priceToken = BigDecimal.valueOf(5);
        } else {
            priceToken = BigDecimal.valueOf(0.5);
        }

        BigDecimal price = new BigDecimal(tokensCount).divide(new BigDecimal(1000000)).multiply(priceToken);

        System.out.println("This request costs: $" + price);
    }

    public static BigDecimal calculatePrice(int tokensCount, String model, int number) {
        BigDecimal priceToken;

        if (model.equals("chatgpt-4o-latest")) {
            priceToken = BigDecimal.valueOf(5);
        } else {
            priceToken = BigDecimal.valueOf(0.5);
        }

        return new BigDecimal(tokensCount).divide(new BigDecimal(1000000)).multiply(priceToken);
    }

}
