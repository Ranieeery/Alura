package dev.raniery.ecommerce;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.*;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

public class IntegrationTest {

    public static void main(String[] args) {
        String OPENAI_API_KEY = Dotenv.load().get("OPENAI_API_KEY");
        String userMessage = "";
        String systemMessage = "";

        assert OPENAI_API_KEY != null;
        OpenAIClient client = OpenAIOkHttpClient.builder()
            .apiKey(OPENAI_API_KEY)
            .build();

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
            .messages(List.of(ChatCompletionMessageParam.ofChatCompletionUserMessageParam(ChatCompletionUserMessageParam.builder()
                .role(ChatCompletionUserMessageParam.Role.USER)
                .content(ChatCompletionUserMessageParam.Content.ofTextContent("Who is Pelé"))
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
