package dev.raniery.ecommerce;

import dev.raniery.ecommerce.functions.TokensCount;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.sashirestela.openai.SimpleOpenAI;
import io.github.sashirestela.openai.domain.chat.Chat;
import io.github.sashirestela.openai.domain.chat.ChatMessage.SystemMessage;
import io.github.sashirestela.openai.domain.chat.ChatMessage.UserMessage;
import io.github.sashirestela.openai.domain.chat.ChatRequest;
import io.github.sashirestela.openai.exception.OpenAIException;
import io.github.sashirestela.openai.exception.OpenAIException.AuthenticationException;
import io.github.sashirestela.openai.exception.OpenAIException.InternalServerException;

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

        CompletableFuture<Chat> futureChat = tries(openAI, chatRequest);

        return futureChat.join();
    }

    public CompletableFuture<Chat> tries(SimpleOpenAI openAI, ChatRequest chatRequest) {
        int tries = 0;
        while (tries < 3) {
            try {
                return openAI.chatCompletions().create(chatRequest);
            } catch (AuthenticationException e) {
                throw new RuntimeException("Invalid API Key");
            } catch (OpenAIException.RateLimitException e) {
                throw new RuntimeException("Rate Limit Exceeded");
            } catch (InternalServerException e) {
                tries++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException("Error sleeping thread", ex);
                }
                throw new RuntimeException("Internal Server Error, try number: " + tries + " of 3");
            }
        }

        return null;
    }
}