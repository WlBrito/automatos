
# AFD - Autômato Finito Determinístico

Este projeto é uma implementação em Java de um AFD (Autômato Finito Determinístico).

## 📚 Descrição

O sistema permite que o usuário leia um autômato de um arquivo `.csv`, insira palavras e verifique se elas são aceitas pelo autômato definido.

A implementação utiliza conceitos de estados, transições e estados finais, baseando-se em um alfabeto fixo (`a` e `b`). A transição entre os estados ocorre de acordo com a leitura de símbolos da palavra de entrada.

## ⚙️ Como Funciona

1. O programa solicita o caminho de um arquivo `.csv` com a definição do autômato.
2. Após carregado, o usuário pode digitar palavras para testar se são aceitas.
3. Digite `sair` para encerrar a execução.

## 🧩 Formato do Arquivo do Autômato (`.csv`)

O arquivo `.csv` deve seguir o seguinte formato:

```
# Comentários são ignorados (linhas que iniciam com #)
# Primeira linha: descrição inicial do estado e estados finais
0; 2,3

# Linhas seguintes: transições no formato
# estadoOrigem;simbolo;estadoDestino
0;a;1
1;b;2
2;a;3
```

- A primeira linha contém o estado inicial (sempre 0) e os estados finais separados por vírgula.
- Cada linha de transição contém: `estadoOrigem;simbolo;estadoDestino`.

## ▶️ Como Executar

1. Compile o projeto:

```bash
javac *.java
```

2. Execute o programa:

```bash
java Main
```

3. Digite o caminho para o arquivo `.csv` contendo o autômato:

```text
Digite o caminho do arquivo do autômato:
automato1.csv
Obs.: o arquivo deve existir dentro do diretório da Main.
```

4. Insira palavras para verificar se são aceitas:

```text
Digite palavras para testar (ou 'sair' para encerrar):
abba
Palavra "abba" eh palavra aceita
abbb
Palavra "abbb" eh palavra rejeitada
sair
```

## 🗂️ Adicionando Novos Autômatos

1. Crie um novo arquivo `.csv` com o nome desejado, por exemplo `automato2.csv`.
2. Siga o mesmo formato de estrutura mencionado acima.
3. Salve o arquivo na pasta do projeto ou em outro local acessível.
4. Ao executar o programa, informe o caminho correto para esse novo arquivo.

