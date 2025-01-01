package dev.raniery.ecommerce;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.*;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

public class IntegrationTest {

    public static void main(String[] args) {
        String OPENAI_API_KEY = Dotenv.load().get("OPENAI_API_KEY");
        String userMessage = "Generate 5 product recommendations for a user";
        String systemMessage = "You are a data scientist working for an e-commerce company. You have been tasked with generating 5 product recommendations for a user based on their purchase history. The user has purchased the following items: books, a laptop, and a pair of shoes.";

        assert OPENAI_API_KEY != null;
        OpenAIClient client = OpenAIOkHttpClient.builder()
            .apiKey(OPENAI_API_KEY)
            .build();

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
            .messages(List.of(ChatCompletionMessageParam.ofChatCompletionUserMessageParam(
                ChatCompletionSystemMessageParam.builder()
                    .additionalProperties(userMessage),
                ChatCompletionUserMessageParam.builder()
                    .role(ChatCompletionUserMessageParam.Role.USER)
                    .content(ChatCompletionUserMessageParam.Content.ofTextContent(systemMessage))
                    .build())))
            .model(ChatModel.GPT_4O_MINI)
            .build();
        ChatCompletion chatCompletion = client.chat().completions().create(params);

        List<ChatCompletion.Choice> choices = chatCompletion.choices();
        for (ChatCompletion.Choice choice : choices) {
            System.out.println("Choice content: " + choice.message().content().get());
        }
    }
}