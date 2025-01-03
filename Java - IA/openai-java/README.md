# E-commerce Product Recommendation System

A Java-based product recommendation system that uses OpenAI's GPT API to provide personalized product recommendations and sentiment analysis for customer reviews.

## Features

- Product recommendations based on user input
- Multi-profile recommendations
- Sentiment analysis for product reviews
- Token usage tracking and cost calculation
- CSV file processing support

## Technologies

- Java 21
- Maven
- OpenAI GPT API [(simple-openai)](https://github.com/sashirestela/simple-openai)
- JTokkit for token counting

## Project Structure

```structure
src/
├── main/
│   ├── java/
│   │   └── dev/raniery/ecommerce/
│   │       ├── details/                # System configurations
│   │       ├── functions/              # Core functionality
│   │       └── IntegrationTest         # OpenAI API integration
│   └── resources/
│       ├── clients10.csv               # Sample client data
│       ├── clients100.csv              # Extended client data
│       └── reviews/                    # Product review files
└── test/
    └── java/                           # Test classes (not yet)
```

## Setup

1. Clone the repository
2. Copy `.envexample` to `.env` and add your OpenAI API key:

```env
OPENAI_API_KEY=your_api_key_here
```

3. Build the project:

```bash
mvn clean install
```

## Dependencies

- [simple-openai](https://github.com/sashirestela/simple-openai) - OpenAI API client
- [java-dotenv](https://github.com/cdimascio/dotenv-java) - Environment variable management
- [jtokkit](https://github.com/knuddelsgmbh/jtokkit) - Token counting
