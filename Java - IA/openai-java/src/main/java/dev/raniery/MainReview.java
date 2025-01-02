package dev.raniery;

import dev.raniery.ecommerce.details.SystemMessageSentimentAnalyzer;

import static dev.raniery.ecommerce.functions.FineTunneling.analysis;

public class MainReview {
    public static void main(String[] args) {
        String systemMessage = SystemMessageSentimentAnalyzer.getString();

        System.out.println("Analysis of the product recommendation system.");

        analysis(systemMessage);
    }
}