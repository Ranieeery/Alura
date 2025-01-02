package dev.raniery.ecommerce;

import java.nio.file.Files;
import java.nio.file.Path;

public class ClientsLoading {
    public static String loadClients(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (Exception e) {
            throw new RuntimeException("Error loading clients file", e);
        }
    }
}
