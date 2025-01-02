package dev.raniery.ecommerce.details;

public class SystemMessageProductRecommendation implements SystemMessage {

    public static String getString() {
        return """
            You are a product recommendation system. The user has asked you to generate a product recommendations for them.
            Answer with just the name of the product you would recommend.
            Choose from the following categories:
            
            %s // Categories
            
            %s // Examples
            
            %s // Rules
            """.formatted(Categories.getCategories(), Examples.getExamples(), Rules.getRules());

    }
}
