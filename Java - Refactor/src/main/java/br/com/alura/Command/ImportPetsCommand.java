package br.com.alura.Command;

import br.com.alura.Client.HttpConfiguration;
import br.com.alura.Service.PetService;

import java.io.IOException;

public class ImportPetsCommand implements Command {

    @Override
    public void execute() {
        try {
            HttpConfiguration client = new HttpConfiguration();
            PetService petService = new PetService(client);

            petService.importarPets();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
