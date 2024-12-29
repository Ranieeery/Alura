package br.com.alura.Command;

import br.com.alura.Client.HttpConfiguration;
import br.com.alura.Service.AbrigoService;

import java.io.IOException;

public class CadastroAbrigoCommand implements Command {

    @Override
    public void execute() {
        try {
            HttpConfiguration client = new HttpConfiguration();
            AbrigoService abrigoService = new AbrigoService(client);

            abrigoService.cadastrarAbrigo();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
