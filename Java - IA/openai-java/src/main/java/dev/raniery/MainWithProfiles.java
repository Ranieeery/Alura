package dev.raniery;

import dev.raniery.ecommerce.ClientsLoading;
import dev.raniery.ecommerce.Pricing;
import dev.raniery.ecommerce.TokensCount;
import io.github.sashirestela.openai.domain.chat.Chat;

import static dev.raniery.ecommerce.FineTunneling.getResponse;

public class MainWithProfiles {
    public static void main(String[] args) {
        String userMessage = ClientsLoading.loadClients("src/main/resources/clients10.csv");

        Chat response = getResponse(userMessage);

        String chatResponse = response.getChoices().getFirst().getMessage().getContent();
        String model = response.getModel();

        System.out.println(chatResponse);

        Pricing.calculatePrice(TokensCount.count(chatResponse, model), model);
    }
}