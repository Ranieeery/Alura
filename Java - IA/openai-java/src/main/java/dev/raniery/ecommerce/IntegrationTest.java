package dev.raniery.ecommerce;

import dev.raniery.ecommerce.details.Categories;
import dev.raniery.ecommerce.details.Examples;
import dev.raniery.ecommerce.details.Rules;
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
            
            %s // Categories
            
            %s // Examples
            
            %s // Rules
            """.formatted(Categories.getCategories(), Examples.getExamples(), Rules.getRules());

        assert OPENAI_API_KEY != null;
        SimpleOpenAI openAI = SimpleOpenAI.builder()
            .apiKey(OPENAI_API_KEY)
            .build();

        var model = TokensCount.count(userMessage) > 4096 ? "chatgpt-4o-latest" :  "gpt-3.5-turbo-0125";

        ChatRequest chatRequest = ChatRequest.builder()
            .model(model)
            .message(SystemMessage.of(systemMessage))
            .message(UserMessage.of(userMessage))
            .temperature(0.7)
            .build();

        CompletableFuture<Chat> futureChat = openAI.chatCompletions().create(chatRequest);
        return futureChat.join();
    }
}