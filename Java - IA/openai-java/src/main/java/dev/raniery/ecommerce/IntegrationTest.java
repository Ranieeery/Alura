package dev.raniery.ecommerce;

import dev.raniery.ecommerce.functions.TokensCount;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.sashirestela.openai.SimpleOpenAI;
import io.github.sashirestela.openai.domain.chat.Chat;
import io.github.sashirestela.openai.domain.chat.ChatMessage.SystemMessage;
import io.github.sashirestela.openai.domain.chat.ChatMessage.UserMessage;
import io.github.sashirestela.openai.domain.chat.ChatRequest;

import java.util.concurrent.CompletableFuture;

public class IntegrationTest {

    public Chat ProductCategorizer(String userMessage, String systemMessage) {
        String OPENAI_API_KEY = Dotenv.load().get("OPENAI_API_KEY");

        assert OPENAI_API_KEY != null;
        SimpleOpenAI openAI = SimpleOpenAI.builder()
            .apiKey(OPENAI_API_KEY)
            .build();

        var model = TokensCount.count(userMessage) > 4096 ? "chatgpt-4o-latest" : "gpt-3.5-turbo-0125";

        ChatRequest chatRequest = ChatRequest.builder()
            .model(model)
            .message(SystemMessage.of(systemMessage))
            .message(UserMessage.of(userMessage))
            .temperature(0.7)
            .build();

        CompletableFuture<Chat> futureChat = openAI.chatCompletions().create(chatRequest);
        return futureChat.join();
    }

    public void loadFiles() {
        // Load files
    }
}