package dev.raniery.ecommerce;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

public class IntegrationTest {

    OpenAIClient client = OpenAIOkHttpClient.builder()
        .apiKey("My API Key")
        .build();
}
