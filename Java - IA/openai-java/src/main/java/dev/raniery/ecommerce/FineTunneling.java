package dev.raniery.ecommerce;

import io.github.sashirestela.openai.domain.chat.Chat;

import java.util.Objects;
import java.util.Scanner;

public class FineTunneling {
    public static Chat getResponse(String userMessage) {
        IntegrationTest integrationTest = new IntegrationTest();
        Chat chatResponse = integrationTest.ProductCategorizer(userMessage);

        String placeholder = "I'm sorry, I can't help you with that.";
        String response = chatResponse.getChoices().getFirst().getMessage().getContent();

        while (Objects.equals(response, placeholder)) {
            System.out.println(placeholder + " Please try again.");

            String userMessageNew = new Scanner(System.in).nextLine();

            chatResponse = integrationTest.ProductCategorizer(userMessageNew);

            if (!Objects.equals(chatResponse.getChoices().getFirst().getMessage().getContent(), placeholder)) {
                break;
            }
        }

        return chatResponse;
    }
}
