package lfa;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LerDoArquivo leia = new LerDoArquivo();
            System.out.println("Digite o caminho do arquivo do autômato:");
            String caminhoArquivo = scanner.nextLine();
            Aut automato = leia.lerArquivo(caminhoArquivo);
            System.out.println("\nDigite palavras para testar (ou 'sair' para encerrar):");

            boolean p = true;

            while (p) {
                String palavra = scanner.nextLine();
                if (palavra.equalsIgnoreCase("sair")) {
                    p = false;
                } else {
                    boolean resultado = automato.reconhecer(palavra);
                    System.out.println(
                            "Palavra \"" + palavra + "\" eh " + (resultado ? "palavra aceita" : "palavra rejeitada"));
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o autômato: " + e.getMessage());
        }
    }
}