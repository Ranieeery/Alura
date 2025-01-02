package dev.raniery;

import dev.raniery.ecommerce.details.SystemMessageProductRecommendation;
import dev.raniery.ecommerce.functions.ClientsLoading;
import dev.raniery.ecommerce.functions.Pricing;
import dev.raniery.ecommerce.functions.TokensCount;
import io.github.sashirestela.openai.domain.chat.Chat;

import static dev.raniery.ecommerce.functions.FineTunneling.getResponse;

public class MainWithProfiles {
    public static void main(String[] args) {
        String systemMessage = SystemMessageProductRecommendation.getString();
        String userMessage = ClientsLoading.loadClients("src/main/resources/clients10.csv");

        Chat response = getResponse(userMessage, systemMessage);

        String chatResponse = response.getChoices().getFirst().getMessage().getContent();
        String model = response.getModel();

        System.out.println(chatResponse);

        Pricing.calculatePrice(TokensCount.count(chatResponse, model), model);
    }
}