package dev.raniery;

import dev.raniery.ecommerce.IntegrationTest;
import io.github.sashirestela.openai.domain.chat.Chat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi, I'm a product recommendation system. What are you looking for?");
        String userMessage = new Scanner(System.in).nextLine();

        IntegrationTest integrationTest = new IntegrationTest();

        Chat chatResponse = integrationTest.ProductCategorizer(userMessage);

        for (int i = 0; i < chatResponse.getChoices().size(); i++) {
            System.out.println(chatResponse.getChoices().get(i).getMessage().getContent());
        }
    }
}