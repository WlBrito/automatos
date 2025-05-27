package lfa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Aut {
    private final List<Transicao> transicoes;
    private final Set<Integer> estadosFinais;
    private final String alfabeto = "ab";

    public Aut(List<Transicao> transicoes, Set<Integer> estadosFinais) {
        this.transicoes = transicoes;
        this.estadosFinais = estadosFinais;
        this.estadosFinais.add(0);
    }

    public Aut() {
        this.transicoes = new ArrayList<>();
        this.estadosFinais = new HashSet<>();
    }

    public boolean reconhecer(String palavra) {
        int estadoAtual = 0;
        for (char c : palavra.toCharArray()) {
            if (alfabeto.indexOf(c) == -1) {
                return false; // palavra com caractere inválido já trava aqui e cabo
            }
            boolean transicaoEncontrada = false;
            for (Transicao t : transicoes) {
                if (t.getEstadoOrigem() == estadoAtual && t.getSimbolo() == c) {
                    estadoAtual = t.getEstadoDestino();
                    transicaoEncontrada = true;
                    break;
                }
            }
            if (!transicaoEncontrada) {
                return false;
            }
        }

        return estadosFinais.contains(estadoAtual);
    }
}
