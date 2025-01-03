package dev.raniery.ecommerce.functions;

import dev.raniery.ecommerce.IntegrationTest;
import io.github.sashirestela.openai.domain.chat.Chat;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class FineTunneling {
    public static Chat getResponse(String systemMessage) {
        IntegrationTest integrationTest = new IntegrationTest();
        String placeholder = "I'm sorry, I can't help you with that.";

        try (Scanner scanner = new Scanner(System.in)) {
            String userMessage = scanner.nextLine();

            Chat response = integrationTest.ProductCategorizer(userMessage, systemMessage);

            String chatResponse = response.getChoices().getFirst().getMessage().getContent();

            if (Objects.equals(chatResponse, placeholder)) {
                System.out.printf("%s Please try again.\n", placeholder);
                return getResponse(systemMessage);
            }
            return response;
        }
    }

    public static Chat getResponse(String userMessage, String systemMessage) {
        IntegrationTest integrationTest = new IntegrationTest();

        return integrationTest.ProductCategorizer(userMessage, systemMessage);
    }

    public static void analysis(String systemMessage) {
        Path dir = Paths.get("src/main/resources/reviews");
        try (Stream<Path> pathStream = Files.walk(dir, 1)) {
            List<Path> files = pathStream.filter(path -> path.toString().endsWith(".txt")).toList();

            fileLoop(files, systemMessage);

        } catch (Exception e) {
            throw new RuntimeException("Error analyzing files", e);
        }
    }

    public static void fileLoop(List<Path> files, String systemMessage) {

        BigDecimal total = BigDecimal.ZERO;

        for (Path file : files) {
            System.out.println("Analyzing file: " + file.getFileName());
            String prompt = ClientsLoading.loadFiles(file);

            Chat response = getResponse(prompt, systemMessage);

            String chatResponse = response.getChoices().getFirst().getMessage().getContent();

            ClientsLoading.saveAnalysis(file.getFileName().toString(), chatResponse);

            System.out.println("Analysis completed.");

            total = total.add(Pricing.calculatePrice(TokensCount.count(chatResponse), response.getModel(), 1));
        }

        System.out.println("This request costs: $" + total);
    }
}
