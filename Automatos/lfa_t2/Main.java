package lfa_t2;

public class Main {
    public static void main(String[] args) {
        ExpressaoRegular ER = new ExpressaoRegular();

        // Teste 1, expressão regular: DIGITOS
        ER.confere(ER.DIGITOS, "000511200021");

        // Teste 2, expressão regular: DIGITOS
        ER.confere(ER.DIGITOS, "000511200021ADAF");

        // Teste 3, expressão regular: LETRAS
        ER.confere(ER.LETRAS, "ASDFEAFdafsafdsf");

        // Teste 4, expressão regular: LETRAS
        ER.confere(ER.LETRAS, "ASDFEAFdafsafdsf4565");

        // Teste 5, expressão regular: IDENT (nome de variável, função e classes)
        ER.confere(ER.IDENT, "Altura1");

        // Teste 6, expressão regular: IDENT (nome de variável, função e classes)
        ER.confere(ER.IDENT, "1Altura");

        // Teste 7, expressão regular: REAL
        ER.confere(ER.REAL, "123.908777E+30");

        // Teste 8, expressão regular: REAL
        ER.confere(ER.REAL, "0.17E-5");

        // Teste 9, expressão regular: ATRIBUICAO
        ER.confere(ER.ATRIBUICAO, "media=-123.908777E+30");

        ER.confere(ER.INTEIRO, "10");

        // Teste 10, expressão regular: ASSINATURA FUNCAO
        ER.confere(ER.FUNCAO, "int soma(int a, int b)"); // Correto
        ER.confere(ER.FUNCAO, "void calcularMedia(float nota1, float nota2, float nota3)"); // Correto
        ER.confere(ER.FUNCAO, "null calcularMedia(float nota1, float nota2, float nota3)"); // Erro: null não é um tipo
        ER.confere(ER.FUNCAO, "void qualquercoisa(int n)"); // Correto apenas um parâmetro

        // Teste 11, expressão regular: IF
        ER.confere(ER.IF, "if (altura > 1.70)"); // Correto
        ER.confere(ER.IF, "if(3*a != 4+t)"); // Correto
        ER.confere(ER.IF, "if (altura > 1.70"); // Erro: falta fechar o bloco
        ER.confere(ER.IF, "if (3*5 + 4+t) + 3 >= 5"); // PEEEEEEEEEEEEEEEEN


	// Testes - EXPRESSAOMATEMATICA
        System.out.println("==== TESTES - Atividade 4: EXPRESSAOMATEMATICA ====");
        List<String> expressoesMatematicasValidas = List.of(
            "media + (total / 2)",
            "a * b + c",
            "(1 + 2) * 3",
            "num - 4.5 / valor",
            "( x + y ) - z",
            "salarioBruto - descontos"
        );
        
        for (String s : expressoesMatematicasValidas) {
            ER.confere(ER.EXPRESSAOMATEMATICA, s);
        }
        
      
        System.out.println("\n\n\nRejeitadassss 4");
        ER.confere(ER.EXPRESSAOMATEMATICA, "((3 + 2)");          // parênteses abertos sem fechamento
        ER.confere(ER.EXPRESSAOMATEMATICA, "3 + 2))");           // parênteses fechados a mais
        ER.confere(ER.EXPRESSAOMATEMATICA, "(a + b)) * 3");      // parêntese sobrando
        ER.confere(ER.EXPRESSAOMATEMATICA, "1.2.3 + 5");          // número mal formado
        ER.confere(ER.EXPRESSAOMATEMATICA, "x + 5 6");            // dois operandos sem operador entre eles
        ER.confere(ER.EXPRESSAOMATEMATICA, " "); // Sem função
    }
}
