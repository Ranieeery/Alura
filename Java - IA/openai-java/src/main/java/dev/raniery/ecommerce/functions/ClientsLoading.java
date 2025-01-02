package dev.raniery.ecommerce.functions;

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

    public static String loadFiles(String file) {
        try {
            return Files.readAllLines(Path.of("src/main/resources/avaliacoes-" + file + ".txt")).toString();
        } catch (Exception e) {
            throw new RuntimeException("Error loading files", e);
        }
    }

    public static String saveAnalysis(String file, String analysis) {
        try {
            return Files.readAllLines(Path.of("src/main/resources/analise-sentimentos-" + file + ".txt")).toString();
        } catch (Exception e) {
            throw new RuntimeException("Error saving analysis", e);
        }
    }
}
