package dev.raniery.ecommerce;

import java.nio.file.Files;
import java.nio.file.Path;

public class ClientsLoading {
    public static void main(String[] args) {
        try {
            String path = Files.readString(Path.of("src/main/resources/clients10.csv"));

            System.out.println(path);
        } catch (Exception e) {
            throw new RuntimeException("Error loading clients file", e);
        }
    }
}
