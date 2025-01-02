package dev.raniery.ecommerce;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.*;

public class TokensCount {
    public static int count(String message) {
        EncodingRegistry registry = Encodings.newDefaultEncodingRegistry();
        Encoding enc = registry.getEncodingForModel(ModelType.GPT_3_5_TURBO_16K);
        return enc.countTokens(message);
    }
}
