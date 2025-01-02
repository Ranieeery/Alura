package dev.raniery;

import dev.raniery.ecommerce.IntegrationTest;
import dev.raniery.ecommerce.Pricing;
import dev.raniery.ecommerce.TokensCount;
import io.github.sashirestela.openai.domain.chat.Chat;

import java.util.Scanner;

import static dev.raniery.ecommerce.FineTunneling.getResponse;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi, I'm a product recommendation system. What are you looking for?");
        String userMessage = new Scanner(System.in).nextLine();

        String chatResponse = getResponse(userMessage).getChoices().getFirst().getMessage().getContent();

        System.out.println(chatResponse);

        Pricing.calculatePrice(TokensCount.count(chatResponse));
    }
}