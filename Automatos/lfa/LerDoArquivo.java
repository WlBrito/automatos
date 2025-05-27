package lfa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LerDoArquivo {

    public Aut lerArquivo(String caminhoArquivo) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));
        String primeiraLinha = leitor.readLine();
        String[] partesFinais = primeiraLinha.split(";");
        String[] finaisStr = partesFinais[1].trim().split(",");
        Set<Integer> estadosFinais = new HashSet<>();
        for (String f : finaisStr) {
            estadosFinais.add(Integer.parseInt(f.trim()));
        }
        List<Transicao> transicoes = new ArrayList<>();
        String linha;
        while ((linha = leitor.readLine()) != null) {
            if (linha.trim().isEmpty() || linha.startsWith("#"))
                continue;

            String[] partes = linha.split(";");
            // Cada linha deve ter 3 partes: origem;letra;destino
            if (partes.length == 3) {
                int origem = Integer.parseInt(partes[0]);
                char letra = partes[1].charAt(0);
                int destino = Integer.parseInt(partes[2]);
                // Adiciona uma nova transição à lista
                transicoes.add(new Transicao(origem, letra, destino));
            }
        }
        leitor.close();
        return new Aut(transicoes, estadosFinais);
    }
}
