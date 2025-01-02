package dev.raniery;

import dev.raniery.ecommerce.functions.Pricing;
import dev.raniery.ecommerce.functions.TokensCount;
import io.github.sashirestela.openai.domain.chat.Chat;

import static dev.raniery.ecommerce.functions.FineTunneling.getResponse;

public class MainPsycho {
    public static void main(String[] args) {
        System.out.println("Hi, I'm a product recommendation system. What are you looking for?");

        Chat response = getResponse();

        String chatResponse = response.getChoices().getFirst().getMessage().getContent();
        String model = response.getModel();

        System.out.println(chatResponse);

        Pricing.calculatePrice(TokensCount.count(chatResponse), model);
    }
}