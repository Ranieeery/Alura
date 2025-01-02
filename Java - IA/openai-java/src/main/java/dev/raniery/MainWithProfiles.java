package dev.raniery;

import dev.raniery.ecommerce.ClientsLoading;
import dev.raniery.ecommerce.Pricing;
import dev.raniery.ecommerce.TokensCount;

import java.util.Scanner;

import static dev.raniery.ecommerce.FineTunneling.getResponse;

public class MainWithProfiles {
    public static void main(String[] args) {
        String userMessage = ClientsLoading.loadClients();

        String chatResponse = getResponse(userMessage).getChoices().getFirst().getMessage().getContent();
        String model = getResponse(userMessage).getModel();

        System.out.println(chatResponse);
        System.out.println("Model: " + model);

        Pricing.calculatePrice(TokensCount.count(chatResponse), model);
    }
}