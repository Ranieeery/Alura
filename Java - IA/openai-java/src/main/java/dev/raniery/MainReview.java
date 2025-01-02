package dev.raniery;

import dev.raniery.ecommerce.details.SystemMessageProductRecommendation;
import dev.raniery.ecommerce.details.SystemMessageSentimentAnalyzer;
import dev.raniery.ecommerce.functions.Pricing;
import dev.raniery.ecommerce.functions.TokensCount;
import io.github.sashirestela.openai.domain.chat.Chat;

import static dev.raniery.ecommerce.functions.FineTunneling.getResponse;

public class MainReview {
    public static void main(String[] args) {
        String systemMessage = SystemMessageSentimentAnalyzer.getString();

        System.out.println("Analysis of the product recommendation system.");

        Chat response = getResponse(systemMessage);

        String chatResponse = response.getChoices().getFirst().getMessage().getContent();
        String model = response.getModel();

        System.out.println(chatResponse);

        Pricing.calculatePrice(TokensCount.count(chatResponse), model);
    }
}