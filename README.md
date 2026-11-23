## TP05 - Java Threads

Projeto desenvolvido para o Trabalho Prático 5 de Java do IFSP.

A aplicação utiliza Java Swing, Threads e a interface Runnable para executar duas contagens simultaneamente.

## Sobre o projeto

O programa possui:

- Uma janela principal;
- Duas Threads;
- Duas listas de contagem;
- Campo para informar o valor máximo;
- Campos para definir as prioridades;
- Botão Iniciar;
- Botão Limpar;
- Labels Final 1 e Final 2.

As prioridades das Threads devem estar entre 1 e 10.

## Funcionamento

Ao clicar no botão Iniciar, duas Threads são criadas.

Cada Thread executa uma contagem e preenche sua própria lista com os valores informados.

Quando cada contagem termina, o programa exibe o respectivo resultado:

- Final 1;
- Final 2.

O botão Limpar remove os valores das listas e reinicia a tela.

## Estrutura do projeto

- evidencias/README.md
- src/main/java/br/edu/ifsp/tp05/PainelContagem.java
- src/main/java/br/edu/ifsp/tp05/TelaPrincipal.java
- .gitignore
- pom.xml

## Como executar

É necessário ter instalado:

- JDK 17 ou superior;
- Maven.

Baixe o projeto usando:

git clone https://github.com/juliavvz/TP05-Java-Threads.git

Acesse a pasta:

cd TP05-Java-Threads

Compile o projeto:

mvn clean compile

Execute o programa:

mvn exec:java

## Teste do programa

Preencha os campos com os seguintes valores:

- Valor máximo: 20;
- Prioridade da Thread 1: 1;
- Prioridade da Thread 2: 10.

Depois, clique em Iniciar.

Verifique se:

- As duas listas foram preenchidas;
- As duas Threads foram executadas;
- Os labels Final 1 e Final 2 apareceram.

Também teste o botão Limpar e os campos com valores inválidos.

## Evidências

As imagens e capturas de tela do trabalho devem ser colocadas na pasta evidencias.

Podem ser adicionadas imagens da:

- Tela inicial;
- Contagem em execução;
- Contagem finalizada;
- Mensagem de validação;
- Utilização do botão Limpar.

Não coloque senhas ou dados pessoais nas imagens.

## Tecnologias utilizadas

- Java 17;
- Java Swing;
- Threads;
- Runnable;
- Maven;
- GitHub.
