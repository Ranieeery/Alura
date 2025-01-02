package dev.raniery.ecommerce;

import io.github.sashirestela.openai.domain.chat.Chat;

import java.util.Objects;
import java.util.Scanner;

public class FineTunneling {
    public static Chat getResponse(String userMessage) {
        IntegrationTest integrationTest = new IntegrationTest();
        Chat chatResponse;
        String response;
        String placeholder = "I'm sorry, I can't help you with that.";

        try (Scanner scanner = new Scanner(System.in)) {
            chatResponse = integrationTest.ProductCategorizer(userMessage);
            response = chatResponse.getChoices().getFirst().getMessage().getContent();

            if (Objects.equals(response, placeholder)) {
                System.out.printf("%s Please try again.\n", response);

                userMessage = scanner.nextLine();
                getResponse(userMessage);
            }
            return chatResponse;
        }
    }
}
