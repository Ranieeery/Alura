package dev.raniery.ecommerce.functions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

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

    public static void saveAnalysis(String file, String analysis) {
        try {
            Files.writeString(Path.of("src/main/resources/reviews/analise-sentimentos-" + file + ".txt"), analysis, StandardOpenOption.CREATE_NEW);
        } catch (Exception e) {
            throw new RuntimeException("Error saving analysis", e);
        }
    }
}
