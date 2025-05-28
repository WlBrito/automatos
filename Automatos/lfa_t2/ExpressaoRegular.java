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
    public String OPERADOR;
    public String CONDICAO;
    public String IF;
    
    //Exercicio 4
    public String EXPRESSAOMATEMATICA;
    public String OPERADORMATEMATICO;
    public String DIGITOSEMZERO;
    public String DIGITOSSEMZERO;
    public String EXPONENCIALSEMZERO;
    public String REALSEMZERO;
    public String ARRAY;
    public String IDENTIFICADOR;
    public String CAMPO;
    public String OPERANDO;
    public String CHAMADAFUNCAO;
    public String GRUPO;
    
        


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
        // ERRO AQUI: O padrão REAL não estava correto, pois não considerava o caso de
        // números sem parte decimal.
        REAL = "(\\-?" + DIGITOS + "\\.?" + DIGITOS + "(" + EXPONENCIAL + ")?)";
        INTEIRO = "(" + DIGITOS + EXPONENCIAL + "?)";
        NUMEROS = "(" + INTEIRO + "|" + REAL + ")";
        ATRIBUICAO = IDENT + BRANCOS + "=" + BRANCOS + REAL;
        // TIPO = TIPOS PRIMITIVOS (void, int, float, double, char, String, boolean)
        TIPO = "(void|int|float|double|char|String|boolean)";
        // PARAMETROS = "(" + TIPO + BRANCOS + IDENT + BRANCOS)";
        PARAM = "(" + TIPO + BRANCOS + IDENT + ")";
        // PARAMS = "(" + BRANCOS + "(" + PARAM + "(" + BRANCOS + "," + BRANCOS +
        PARAMS = "(" + BRANCOS + "(" + PARAM + "(" + BRANCOS + "," + BRANCOS + PARAM + ")*)?" + BRANCOS + ")";
        // FUNCAO = "(" + TIPO + BRANCOS + IDENT + BRANCOS + "\\(" + PARAMS + "\\)" +
        FUNCAO = "(" + TIPO + BRANCOS + IDENT + BRANCOS + "\\(" + PARAMS + "\\)" + ")";
        // OPERADOR = "(\\+|\\-|\\*|\\/|%|\\=|\\<|\\>|\\!|\\&|\\||\\^|\\~)";
        OPERADOR = "(==|!=|<=|>=|<|>)";
        // CONDICAO = IDENT + BRANCOS + OPERADOR + BRANCOS + "(" + IDENT + "|" + NUMEROS
        // + ")";
        CONDICAO = IDENT + BRANCOS + OPERADOR + BRANCOS + "(" + IDENT + "|" + NUMEROS + ")";
        // IF = PALAVRA "IF" + ESPAÇO EM BRANCO + "(" + CONDICAO + ")"
        IF = "if" + BRANCOS + "\\(" + BRANCOS + CONDICAO + BRANCOS + "\\)";
        
        
        //Exercicio 4
        OPERADORMATEMATICO = "(/|\\*|\\+|-)";
        
        DIGITOSEMZERO = "[1-9]";
        DIGITOSSEMZERO = "(" + DIGITOSEMZERO + DIGITO + ")" + "*";
        
        EXPONENCIALSEMZERO = DIGITOSSEMZERO + "\\^" + DIGITOSSEMZERO;
        REALSEMZERO = "(\\-?" + DIGITOSEMZERO + "\\.?" + DIGITOS + "(" + EXPONENCIAL + ")?)";
               
        ARRAY = IDENT + "(\\[" + DIGITOS + "\\])";   
        CAMPO = ARRAY + "?" + "(" + "\\."  + IDENT + ")+";
        
        CHAMADAFUNCAO = BRANCOS + IDENT + "\\(" +"(" + BRANCOS + REALSEMZERO + "|" +IDENT + "|" + "\\," + ")+" + "\\)";
        
        OPERANDO = "(" + REAL + "|" + CAMPO + "|" + ARRAY + "|" + CHAMADAFUNCAO + "|" + IDENT + ")";
        GRUPO = "\\(" + BRANCOS + OPERANDO + "(" + BRANCOS + OPERADORMATEMATICO + BRANCOS + OPERANDO + ")*" + BRANCOS + "\\)";

        EXPRESSAOMATEMATICA = BRANCOS + "(" + OPERANDO + "|" + GRUPO + ")" + "(" + BRANCOS + OPERADORMATEMATICO + BRANCOS + "(" + OPERANDO + "|" + GRUPO + ")" + ")*" + BRANCOS;

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