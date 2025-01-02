package dev.raniery.ecommerce.functions;

import io.github.sashirestela.openai.domain.chat.Chat;

import java.util.Objects;
import java.util.Scanner;

public class FineTunneling {
    public static Chat getResponse() {
        IntegrationTest integrationTest = new IntegrationTest();
        String placeholder = "I'm sorry, I can't help you with that.";

        try (Scanner scanner = new Scanner(System.in)) {
            String userMessage = scanner.nextLine();

            Chat chatResponse = integrationTest.ProductCategorizer(userMessage);

            String response = chatResponse.getChoices().getFirst().getMessage().getContent();

            if (Objects.equals(response, placeholder)) {
                System.out.printf("%s Please try again.\n", response);
                return getResponse();
            }
            return chatResponse;
        }
    }

    public static Chat getResponse(String userMessage) {
        IntegrationTest integrationTest = new IntegrationTest();

        return integrationTest.ProductCategorizer(userMessage);
    }
}

