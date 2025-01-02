package dev.raniery.ecommerce;

import java.nio.file.Files;
import java.nio.file.Path;

public class ClientsLoading {
    public static String loadClients() {
        try {
            return Files.readString(Path.of("src/main/resources/clients10.csv"));
        } catch (Exception e) {
            throw new RuntimeException("Error loading clients file", e);
        }
    }
}
