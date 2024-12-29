package br.com.alura;

import br.com.alura.Client.HttpConfiguration;
import br.com.alura.Command.CadastroAbrigoCommand;
import br.com.alura.Command.CommandExecutor;
import br.com.alura.Command.ListAbrigoCommand;
import br.com.alura.Command.ListPetsCommand;
import br.com.alura.Service.PetService;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutor();

        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int opcaoEscolhida = 0;
            while (true) {
                System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
                System.out.println("1 -> Listar abrigos cadastrados");
                System.out.println("2 -> Cadastrar novo abrigo");
                System.out.println("3 -> Listar pets do abrigo");
                System.out.println("4 -> Importar pets do abrigo");
                System.out.println("5 -> Sair");

                String textoDigitado = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                if (opcaoEscolhida == 1) {
                    executor.executeCommand(new ListAbrigoCommand());
                } else if (opcaoEscolhida == 2) {
                    executor.executeCommand(new CadastroAbrigoCommand());
                } else if (opcaoEscolhida == 3) {
                    executor.executeCommand(new ListPetsCommand());
                } else if (opcaoEscolhida == 4) {
                    executor.executeCommand(new ListPetsCommand());
                } else if (opcaoEscolhida == 5) {
                    break;
                } else {
                    System.out.println("NÚMERO INVÁLIDO!");
                    opcaoEscolhida = 0;
                }
            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
