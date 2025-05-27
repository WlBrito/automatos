package lfa_t2;

public class ExpressaoRegular {

    public String BRANCO, BRANCOS;
    public String DIGITO, DIGITOS;
    public String LETRA, LETRAS;
    public String IDENT;
    public String EXPONENCIAL;
    public String REAL;
    public String INTEIRO;
    public String NUMEROS;
    public String ATRIBUICAO;
    public String TIPO;
    public String PARAM;
    public String PARAMS;
    public String FUNCAO;

    public ExpressaoRegular() {
        // ' ' (espaço), '\t' TAB, '\n' new line, '\r' volta o cursos para o inicio da
        // linha, '\f' avanço de pagina, '\v' vertical TAB - (usado em configuraçoes de
        // impressora)
        BRANCO = "(\\s)"; // [ \t\n\r\f\v] onde
        BRANCOS = BRANCO + "*";
        DIGITO = "([0-9])";
        DIGITOS = DIGITO + "*";
        LETRA = "([A-Za-z])";
        LETRAS = LETRA + "*";
        IDENT = "(" + LETRA + "(" + LETRA + "|" + DIGITO + ")*)";
        EXPONENCIAL = "(E(\\+|-)" + DIGITOS + ")";
        REAL = "(\\-?" + DIGITOS + "\\.?" + DIGITOS + EXPONENCIAL + ")";
        INTEIRO = "(" + DIGITOS + EXPONENCIAL + "?)";
        NUMEROS = "(" + INTEIRO + "|" + REAL + ")";
        ATRIBUICAO = IDENT + BRANCOS + "=" + BRANCOS + REAL;
        // TIPO = TIPOS PRIMITIVOS (void, int, float, double, char, String, boolean)
        TIPO = "(void|int|float|double|char|String|boolean)";
        // PARAMETROS = "(" + TIPO + BRANCOS + IDENT + BRANCOS)";
        PARAM = "(" + TIPO + BRANCOS + IDENT + BRANCOS + ")";
        PARAMS = "(" + PARAM + "(," + PARAM + ")*)";
        FUNCAO = "(" + TIPO + BRANCOS + IDENT + BRANCOS + "\\(" + PARAMS + "\\))"; // errado ainda, pq?

    }

    public void confere(String exp, String sentenca) {
        if ((sentenca != null) && !sentenca.isEmpty()) {
            if (sentenca.matches(exp)) {
                System.out.println("W:'" + sentenca + "'........ ACEITA!");
            } else {
                System.err.println("W:'" + sentenca + "'........ rejeitada.");
            }
        } else {
            System.err.println("Sentença vazia.");
        }
    }
}
