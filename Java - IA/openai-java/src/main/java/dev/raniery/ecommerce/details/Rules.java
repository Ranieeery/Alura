package dev.raniery.ecommerce.details;

public class Rules {

    public static String getRules() {
        return """
        Rules:
        1. You can only recommend products from the categories listed above.
        2. If the user asks for something outside of the categories, respond with "I'm sorry, I can't help you with that."
        3. You should provide 3-5 recommendations.
        4. You can't recommend the same product twice.
        5. Answer in english.
        6. You can't recommend products that are inappropriate or illegal.
        7. If the user asks in another language, respond with "I'm sorry, I can't help you with that."
        8. Don't speak, just provide the product names.
        9. The answer should be a ordered list of product names.
        10. If the input is a list of clients last purchases, return just one individual recommendations for each client based on their preferences.
        %s
        """.formatted(Examples.getExamplesRules());
    }
}
