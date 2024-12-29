package br.com.alura.Service;

import br.com.alura.Client.HttpConfiguration;
import br.com.alura.Domain.Abrigo;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbrigoServiceTest {

    private final HttpConfiguration client = mock(HttpConfiguration.class);
    private final AbrigoService abrigoService = new AbrigoService(client);
    private final HttpResponse<String> response = mock(HttpResponse.class);

    private final Abrigo abrigo = new Abrigo("Abrigo 1", "1234567890", "abrigo@pet.com");

    @Test
    public void verificaRequisicaoDeAbrigoGet() throws IOException, InterruptedException {
        abrigo.setId(1L);
        String expectedAbrigosCadastrados = "Abrigos cadastrados:";
        String expectedIdAndNome = "1 - Abrigo 1";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        when(response.body()).thenReturn("[{" + abrigo + "}]");
        when(client.httpRequestGet("http://localhost:8080/abrigos")).thenReturn(response);

        abrigoService.listarAbrigos();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actualAbrigosCadastrados = lines[0];
        String actualIdAndNome = lines[1];

        assertEquals(expectedAbrigosCadastrados, actualAbrigosCadastrados);
        assertEquals(expectedIdAndNome, actualIdAndNome);
    }
}
