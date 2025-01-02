package dev.raniery;

import dev.raniery.ecommerce.IntegrationTest;
import io.github.sashirestela.openai.domain.chat.Chat;

import java.util.Scanner;

import static dev.raniery.ecommerce.FineTunneling.getResponse;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi, I'm a product recommendation system. What are you looking for?");
        String userMessage = new Scanner(System.in).nextLine();

        Chat chatResponse = getResponse(userMessage);

        for (int i = 0; i < chatResponse.getChoices().size(); i++) {
            System.out.println(chatResponse.getChoices().get(i).getMessage().getContent());
        }
    }
}