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
    public String OPERADORLOG;
    public String CONDICAO;
    public String EXPRESSAOMAT;
    public String IF;

    // Exercício 4
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
    public String NUMEROS_IMPARES;

   public String PARCELA;
    
    // Exercício 5

    public String EXERCICIO5_A;
    public String EXERCICIO5_B;

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
        // ERRO DO ZÉ RUI AQUI: O padrão REAL não estava correto, pois não considerava o
        // caso de
        // números sem parte decimal.
        REAL = "(\\-?" + DIGITOS + "\\.?" + DIGITOS + "(" + EXPONENCIAL + ")?)";
        INTEIRO = "(" + DIGITOS + EXPONENCIAL + "?)";
        NUMEROS = "(" + INTEIRO + "|" + REAL + ")";
        ATRIBUICAO = IDENT + BRANCOS + "=" + BRANCOS + REAL;

        // COMEÇA AQUI EX 1 - 3
        
        // TIPO = TIPOS PRIMITIVOS (void, int, float, double, char, String, boolean)
        TIPO = "(void|int|float|double|char|String|boolean)";
        // PARAMETROS = TIPO + ESPAÇO EM BRANCO + NOME
        PARAM = "(" + TIPO + BRANCOS + IDENT + ")";
        // PARAMS = BRANCO + PARAMETROS + ("," + BRANCO + PARAMETROS + ")*" +
        // ou seja, uma lista de parâmetros separados por vírgula
        PARAMS = "(" + BRANCOS + "(" + PARAM + "(" + BRANCOS + "," + BRANCOS + PARAM + ")*)?" + BRANCOS + ")";
        // FUNCAO = TIPO + ESPAÇO EM BRANCO + NOME + ESPAÇO EM BRANCO + PARAMETROS
        // ou seja, uma função que retorna um tipo e tem um nome seguido de parâmetros
        FUNCAO = "(" + TIPO + BRANCOS + IDENT + BRANCOS + "\\(" + PARAMS + "\\)" + ")";
        // OPERADORLOG = "==" | "!=" | "<=" | ">=" | "<" | ">"
       
        /*   if (3*a != 4+t)
        AINDA COM ERRO:
        palavra IF + BRANCOS + "\\(" + BRANCOS + CONDICAO + BRANCOS + "\\)"
        
        CONDICAO
        "\\(" "(""("IDENT | EXPRESSAOMAT")" + BRANCOS + OPERADORLOG + BRANCOS + "("IDENT | EXPRESSAOMAT ")"")+"
        
        EXPRESSAOMAT
        "(" + BRANCOS + "(" + NUMEROS | IDENT + ")" + OPERADORMATEMATICO + "(" NUMEROS | ")" ")+"
        
       */ 
        OPERADORLOG = "(==|!=|<=|>=|<|>)";

        OPERADORMATEMATICO = "(/|\\*|\\+|-)";
        // ERRO DE PARENTESES AQUI, MAS ONDE ??????
        
        PARCELA = "("+NUMEROS + "|" + IDENT+")";
        EXPRESSAOMAT =  PARCELA +
                "(" + BRANCOS + OPERADORMATEMATICO  
                 + BRANCOS + PARCELA + ")+" ;

        /*
         * CONDICAO = "\\(" "(""("IDENT | EXPRESSAOMAT")" + BRANCOS + OPERADORLOG +
         * BRANCOS + "("IDENT | EXPRESSAOMAT ")"")+"
         * IDENT OU EXPESSAOMAT PODE ESTAR CONTIDA SOMENTE EM EXPRESSAOMAT, OU SEJA,
         * EXPRESSAOMAT + OPERADOR + EXPRESSAOMAT
         */
        CONDICAO = "(" + EXPRESSAOMAT + ")+" + BRANCOS + OPERADORLOG + BRANCOS + "(" + EXPRESSAOMAT + ")+";
        // EXPRESSAOMAT = "(" + "(" + NUMEROS + "|" + IDENT + ")" + "(" + BRANCOS +
        // OPERADORMATEMATICO + BRANCOS + "(" + NUMEROS + "|" + IDENT + ")" + ")*";
        // ou seja, uma expressão matemática que pode conter números e identificadores e
        // operadores matemáticos

        // IF = palavra IF + BRANCOS + "\\(" + BRANCOS + CONDICAO + BRANCOS + "\\)"
        IF = "if" + BRANCOS + "\\(" + BRANCOS + CONDICAO + BRANCOS + "\\)";

        // Exercicio 4

        DIGITOSEMZERO = "[1-9]";
        DIGITOSSEMZERO = "(" + DIGITOSEMZERO + DIGITO + ")" + "*";
        REALSEMZERO = "(\\-?" + DIGITOSEMZERO + "\\.?" + DIGITOS + "(" + EXPONENCIAL + ")?)";

        GRUPO = "\\(" + BRANCOS + OPERANDO + BRANCOS + "\\)";

        ARRAY = IDENT + "(\\[" + DIGITOS + "\\])";
        CAMPO = ARRAY + "?" + "(" + "\\." + IDENT + ")+";

        CHAMADAFUNCAO = BRANCOS + IDENT + "\\(" + "(" + BRANCOS + REALSEMZERO + "|" + IDENT + "|" + "\\," + ")+"
                + "\\)";

        OPERANDO = "(" + REAL + "|" + CAMPO + "|" + ARRAY + "|" + CHAMADAFUNCAO + "|" + IDENT + ")";
        GRUPO = "\\(" + BRANCOS + OPERANDO + "(" + BRANCOS + OPERADORMATEMATICO + BRANCOS + OPERANDO + ")+" + BRANCOS
                + "\\)";

        EXPRESSAOMATEMATICA = BRANCOS + "(" + "(" + OPERANDO + "|" + GRUPO + ")" + "(" + BRANCOS + OPERADORMATEMATICO
                + BRANCOS + ")" + "(" + OPERANDO + "|" + GRUPO + ")" + ")+" + BRANCOS;

        // Atividade 5
        NUMEROS_IMPARES = "(" + "1" + "|" + "3" + "|" + "5" + "|" + "7" + "|" + "9" + ")";
        EXERCICIO5_A = "(" + REAL + REAL + "(" + REAL + ")+";
        EXERCICIO5_B = "(" + BRANCOS + "|" + REAL + "|" + DIGITOS + ")+" + BRANCOS + NUMEROS_IMPARES;

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
