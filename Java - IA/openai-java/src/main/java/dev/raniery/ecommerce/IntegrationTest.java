package dev.raniery.ecommerce;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.sashirestela.openai.SimpleOpenAI;
import io.github.sashirestela.openai.domain.chat.ChatMessage.SystemMessage;
import io.github.sashirestela.openai.domain.chat.ChatMessage.UserMessage;
import io.github.sashirestela.openai.domain.chat.ChatRequest;

public class IntegrationTest {

    public static void main(String[] args) {
        String OPENAI_API_KEY = Dotenv.load().get("OPENAI_API_KEY");
        String userMessage = "Generate 5 product recommendations for a user";
        String systemMessage = "You are a data scientist working for an e-commerce company. You have been tasked with generating 5 product recommendations for a user based on their purchase history. The user has purchased the following items: books, a laptop, and a pair of shoes.";

        assert OPENAI_API_KEY != null;
        var openAI = SimpleOpenAI.builder()
                .apiKey(OPENAI_API_KEY)
                .build();

        var chatRequest = ChatRequest.builder()
                .model("gpt-4o-mini")
                .message(SystemMessage.of(userMessage))
                .message(UserMessage.of(systemMessage))
                .temperature(0.0)
                .maxCompletionTokens(300)
                .build();
        var futureChat = openAI.chatCompletions().create(chatRequest);
        var chatResponse = futureChat.join();
        System.out.println(chatResponse.firstContent());

    }
}