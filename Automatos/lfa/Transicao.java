package lfa;

public class Transicao {
    private int estadoOrigem;
    private char simbolo;
    private int estadoDestino;

    public Transicao(int origem, char simbolo, int destino) {
        this.estadoOrigem = origem;
        this.simbolo = simbolo;
        this.estadoDestino = destino;
    }

    /*
     * Construtor padrão, inicializa os valores de estadoOrigem e simbolo
     * finais: qf
     * d(q0;a) = q1
     * d(q0,b) = q2
     * d(q1,a) = qf
     * d(q1,b) = q2
     * d(q2,a) = q1
     * d(q2,b) = qf
     * d(qf,a) = qf
     * d(qf,b) = qf
     */

    public Transicao() {
        this.estadoOrigem = 0;
        this.simbolo = ' ';
        this.estadoDestino = 0;
    }

    // gets e sets

    public int getEstadoOrigem() {
        return estadoOrigem;
    }

    public void setEstadoOrigem(int estadoOrigem) {
        this.estadoOrigem = estadoOrigem;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public int getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(int estadoDestino) {
        this.estadoDestino = estadoDestino;
    }
}