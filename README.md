# TP05 — Java Threads

Solução do Trabalho Prático 5 da disciplina de LP2I4 — Java, do IFSP Campus Cubatão.

O projeto utiliza Java Swing, duas Threads e a interface `Runnable` para realizar duas contagens simultâneas.

## Requisitos do enunciado

O programa possui:

- JFrame principal;
- Campo para informar o valor máximo da contagem;
- Campo para informar a prioridade da Thread 1;
- Campo para informar a prioridade da Thread 2;
- Duas listas preenchidas com os valores das contagens;
- Duas Threads independentes;
- Painéis que estendem `JPanel` e implementam `Runnable`;
- Labels `Final 1` e `Final 2`, exibidos somente após o término das contagens;
- Botão **Iniciar**;
- Botão **Limpar**;
- Validação do valor máximo e das prioridades.

As prioridades devem ser valores entre `1` e `10`, conforme as prioridades permitidas para Threads em Java.


Funcionamento
A classe TelaPrincipal representa o JFrame principal da aplicação. Nela, o usuário informa:
O valor máximo da contagem;
A prioridade da Thread 1;
A prioridade da Thread 2.
Ao clicar em Iniciar, são criadas duas Threads. Cada uma executa uma instância de PainelContagem, que implementa Runnable.
Cada Thread preenche uma lista com os valores de 1 até o valor máximo informado.
Quando uma Thread termina sua contagem, o respectivo label é exibido:
text
Final 1
Final 2
O botão Limpar remove os valores das listas e oculta os labels de finalização.
Requisitos para executar
É necessário ter instalado:
JDK 17 ou superior;
Maven;
NetBeans, opcionalmente.
Para verificar as instalações:
Bash
java -version
mvn -version
Execução pelo terminal
Clone o repositório:
Bash
git clone https://github.com/juliavvz/TP05-Java-Threads.git
Entre na pasta do projeto:
Bash
cd TP05-Java-Threads
Compile o projeto:
Bash
mvn clean compile
Se a compilação estiver correta, será exibida a mensagem:
text
BUILD SUCCESS
Execute o programa:
Bash
mvn exec:java
Execução pelo NetBeans
Abra o NetBeans.
Selecione File > Open Project.
Escolha a pasta TP05-Java-Threads.
Abra o arquivo TelaPrincipal.java.
Execute o projeto ou a classe TelaPrincipal.
Informe o valor máximo e as prioridades.
Clique em Iniciar.
O enunciado solicita um aplicativo Java com um JFrame principal e um painel que estenda Runnable. Por isso, o método main está dentro da classe TelaPrincipal, não existindo uma classe principal separada.
Testes sugeridos
Teste 1 — Contagem normal
Informe:
text
Máximo: 20
Prioridade 1: 1
Prioridade 2: 10
Clique em Iniciar.
As duas listas deverão ser preenchidas com os valores de 1 até 20.
Ao final, deverão aparecer os labels:
text
Final 1
Final 2
Teste 2 — Botão Limpar
Depois da contagem:
Clique em Limpar.
Confira se as listas foram esvaziadas.
Confira se os labels Final 1 e Final 2 desapareceram.
Teste 3 — Prioridade inválida
Informe uma prioridade fora do intervalo permitido, por exemplo:
text
11
O sistema deverá apresentar uma mensagem informando que a prioridade deve estar entre 1 e 10.
Teste 4 — Valor máximo inválido
Teste os valores:
text
0
ou:
text
abc
O sistema deverá apresentar uma mensagem informando que o valor máximo é inválido.
Teste 5 — Contagem maior
Informe:
text
Máximo: 1000
Prioridade 1: 1
Prioridade 2: 10
Clique em Iniciar e utilize a barra de rolagem para visualizar os valores das listas.
Divisão do trabalho
Pessoa 1 — Threads e contagem
Responsabilidades:
Revisar PainelContagem.java;
Conferir a implementação de Runnable;
Conferir a criação das duas Threads;
Testar as prioridades entre 1 e 10;
Testar o preenchimento das listas;
Conferir a exibição dos labels finais.
Pessoa 2 — Interface e integração
Responsabilidades:
Revisar TelaPrincipal.java;
Conferir o layout da aplicação;
Testar os botões Iniciar e Limpar;
Testar os campos de máximo e prioridade;
Conferir as mensagens de validação;
Preparar as capturas de tela e a gravação do vídeo.
Evidências
As imagens utilizadas no vídeo ou relatório podem ser colocadas na pasta:
text
evidencias/
Sugestões de capturas:
Tela inicial do programa;
Campos preenchidos;
Listas durante a contagem;
Labels Final 1 e Final 2;
Uso do botão Limpar;
Mensagem de validação de dados inválidos;
Estrutura do projeto no NetBeans;
Resultado do comando mvn clean compile.
Não coloque senhas ou dados pessoais nas imagens.
Tecnologias utilizadas
Java 17;
Java Swing;
Threads;
Runnable;
Maven;
NetBeans;
Git e GitHub.
Plain Text

Para substituir o README no GitHub:

1. Abra o arquivo `README.md`.
2. Clique no ícone de lápis, **Edit this file**.
3. Apague o conteúdo antigo.
4. Cole o texto acima.
5. Clique em **Commit changes**.
6. Use a mensagem:

```text
docs: atualiza README do TP05
