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
            answer: 1. Clean Code by Robert C. Martin
            2. The Pragmatic Programmer by Andrew Hunt and David Thomas
            3. Refactoring by Martin Fowler
            4. Design Patterns by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides
            
            question: I want some new athletic shoes
            answer: 1. Nike Air Zoom Pegasus 38
            2. Adidas Ultraboost 21
            3. New Balance Fresh Foam 1080v11
            4. Brooks Ghost 13
            5. Hoka One One Clifton 7
            
            question: skincare products
            answer: 1. CeraVe Hydrating Facial Cleanser
            2. Neutrogena Hydro Boost Gel-Cream
            3. Neutrogena Ultra Sheer Dry-Touch Sunscreen SPF 55
            4. CeraVe Moisturizing Cream
            
            Rules:
            1. You can only recommend products from the categories listed above.
            2. If the user asks for something outside of the categories, respond with "I'm sorry, I can't help you with that."
            3. You should provide 3-5 recommendations.
            4. You can't recommend the same product twice.
            5. Answer in english.
            6. You can't recommend products that are inappropriate or illegal.
            7. If the user asks in another language, respond with "I'm sorry, I can't help you with that."
            8. Don't speak, just provide the product names.
            """.formatted(Categories.getCategories());

        assert OPENAI_API_KEY != null;
        SimpleOpenAI openAI = SimpleOpenAI.builder()
            .apiKey(OPENAI_API_KEY)
            .build();

        ChatRequest chatRequest = ChatRequest.builder()
            .model("gpt-4o-mini")
            .message(SystemMessage.of(userMessage))
            .message(UserMessage.of(systemMessage))
            .temperature(1D)
            .maxCompletionTokens(300)
//            .n(5)
            .build();

        CompletableFuture<Chat> futureChat = openAI.chatCompletions().create(chatRequest);
        return futureChat.join();
    }
}