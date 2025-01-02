package dev.raniery.ecommerce.functions;

import dev.raniery.ecommerce.IntegrationTest;
import dev.raniery.ecommerce.details.SystemMessageSentimentAnalyzer;
import io.github.sashirestela.openai.domain.chat.Chat;

import java.util.Objects;
import java.util.Scanner;

public class FineTunneling {
    public static Chat getResponse(String systemMessage) {
        IntegrationTest integrationTest = new IntegrationTest();
        String placeholder = "I'm sorry, I can't help you with that.";

        try (Scanner scanner = new Scanner(System.in)) {
            String userMessage = scanner.nextLine();

            Chat chatResponse = integrationTest.ProductCategorizer(userMessage, systemMessage);

            String response = chatResponse.getChoices().getFirst().getMessage().getContent();

            if (Objects.equals(response, placeholder)) {
                System.out.printf("%s Please try again.\n", response);
                return getResponse(systemMessage);
            }
            return chatResponse;
        }
    }

    public static Chat getResponse(String userMessage, String systemMessage) {
        IntegrationTest integrationTest = new IntegrationTest();

        return integrationTest.ProductCategorizer(userMessage, systemMessage);
    }

    public static void analysis() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the file to load the reviews:");
            String file = scanner.nextLine();

            String prompt = ClientsLoading.loadFiles(file);

            Chat chatResponse = getResponse(prompt, SystemMessageSentimentAnalyzer.getString());

            String response = chatResponse.getChoices().getFirst().getMessage().getContent();

            ClientsLoading.saveAnalysis(file, response);
        }
    }
}

