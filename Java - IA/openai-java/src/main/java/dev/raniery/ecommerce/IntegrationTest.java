package dev.raniery.ecommerce;

import dev.raniery.ecommerce.details.Categories;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.sashirestela.openai.SimpleOpenAI;
import io.github.sashirestela.openai.domain.chat.Chat;
import io.github.sashirestela.openai.domain.chat.ChatMessage.SystemMessage;
import io.github.sashirestela.openai.domain.chat.ChatMessage.UserMessage;
import io.github.sashirestela.openai.domain.chat.ChatRequest;

import java.util.concurrent.CompletableFuture;

public class IntegrationTest {

    public Chat ProductCategorizer(String userMessage) {
        String OPENAI_API_KEY = Dotenv.load().get("OPENAI_API_KEY");
        String systemMessage = """
            You are a product recommendation system. The user has asked you to generate a product recommendations for them.
            Answer with just the name of the product you would recommend.
            Choose from the following categories:
            
            %s
            
            Use example:
            question: I like to read programming books
            answer: 6. Clean Code by Robert C. Martin
            
            question: I want some new athletic shoes
            answer: 4. Nike Air Zoom Pegasus 38
            
            
            """.formatted(Categories.getCategories());

        assert OPENAI_API_KEY != null;
        SimpleOpenAI openAI = SimpleOpenAI.builder()
            .apiKey(OPENAI_API_KEY)
            .build();

        ChatRequest chatRequest = ChatRequest.builder()
            .model("gpt-4o-mini")
            .message(SystemMessage.of(userMessage))
            .message(UserMessage.of(systemMessage))
            .temperature(0.5)
            .n(5)
            .maxCompletionTokens(300)
            .build();

        CompletableFuture<Chat> futureChat = openAI.chatCompletions().create(chatRequest);
        return futureChat.join();
    }
}