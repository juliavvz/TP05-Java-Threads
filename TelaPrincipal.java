package br.edu.ifsp.tp05;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/** JFrame principal do Trabalho Prático 5. */
public class TelaPrincipal extends JFrame {
    private final JTextField campoMaximo = new JTextField("1000", 8);
    private final JTextField campoPrioridade1 = new JTextField("1", 4);
    private final JTextField campoPrioridade2 = new JTextField("10", 4);
    private final JButton botaoIniciar = new JButton("Iniciar");
    private final JButton botaoLimpar = new JButton("Limpar");
    private PainelContagem painel1 = criarPainel("1");
    private PainelContagem painel2 = criarPainel("2");
    private int finalizados;

    public TelaPrincipal() {
        super("Trabalho Prático 5 - Threads");
        montarTela();
    }

    private PainelContagem criarPainel(String identificacao) {
        return new PainelContagem(identificacao, 0, Thread.NORM_PRIORITY, this::registrarFinalizacao);
    }

    private void montarTela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 500);
        setLocationRelativeTo(null);

        JPanel configuracao = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 8));
        configuracao.setBorder(BorderFactory.createTitledBorder("Configuração das Threads"));
        configuracao.add(new JLabel("Máximo:"));
        configuracao.add(campoMaximo);
        configuracao.add(new JLabel("Prioridade 1:"));
        configuracao.add(campoPrioridade1);
        configuracao.add(new JLabel("Prioridade 2:"));
        configuracao.add(campoPrioridade2);
        configuracao.add(botaoIniciar);

        JPanel listas = new JPanel(new GridLayout(1, 2, 12, 0));
        listas.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JPanel coluna1 = new JPanel(new BorderLayout());
        coluna1.add(new JLabel("Lista 1", JLabel.CENTER), BorderLayout.NORTH);
        coluna1.add(painel1, BorderLayout.CENTER);
        JPanel coluna2 = new JPanel(new BorderLayout());
        coluna2.add(new JLabel("Lista 2", JLabel.CENTER), BorderLayout.NORTH);
        coluna2.add(painel2, BorderLayout.CENTER);
        listas.add(coluna1);
        listas.add(coluna2);

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rodape.add(botaoLimpar);

        add(configuracao, BorderLayout.NORTH);
        add(listas, BorderLayout.CENTER);
        add(rodape, BorderLayout.SOUTH);

        botaoIniciar.addActionListener(evento -> iniciarContagens());
        botaoLimpar.addActionListener(evento -> limpar());
    }

    private void iniciarContagens() {
        try {
            int maximo = inteiroNoIntervalo(campoMaximo.getText(), 1, Integer.MAX_VALUE, "valor máximo");
            int prioridade1 = inteiroNoIntervalo(campoPrioridade1.getText(), 1, 10, "prioridade 1");
            int prioridade2 = inteiroNoIntervalo(campoPrioridade2.getText(), 1, 10, "prioridade 2");
            finalizados = 0;
            botaoIniciar.setEnabled(false);
            botaoLimpar.setEnabled(false);

            PainelContagem novoPainel1 = novoPainel("1", maximo, prioridade1);
            PainelContagem novoPainel2 = novoPainel("2", maximo, prioridade2);
            substituirPainel(painel1, novoPainel1);
            substituirPainel(painel2, novoPainel2);
            painel1 = novoPainel1;
            painel2 = novoPainel2;
            painel1.criarThread().start();
            painel2.criarThread().start();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Dados inválidos", JOptionPane.WARNING_MESSAGE);
        }
    }

    private PainelContagem novoPainel(String identificacao, int maximo, int prioridade) {
        return new PainelContagem(identificacao, maximo, prioridade, this::registrarFinalizacao);
    }

    private void substituirPainel(PainelContagem antigo, PainelContagem novo) {
        JPanel pai = (JPanel) antigo.getParent();
        int indice = pai.getComponentZOrder(antigo);
        pai.remove(antigo);
        pai.add(novo, indice);
        pai.revalidate();
        pai.repaint();
    }

    private int inteiroNoIntervalo(String texto, int minimo, int maximo, String nome) {
        try {
            int valor = Integer.parseInt(texto.trim());
            if (valor < minimo || valor > maximo) {
                throw new IllegalArgumentException(nome + " deve estar entre " + minimo + " e " + maximo + ".");
            }
            return valor;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(nome + " deve ser um número inteiro.");
        }
    }

    private void registrarFinalizacao() {
        finalizados++;
        if (finalizados == 2) {
            botaoIniciar.setEnabled(true);
            botaoLimpar.setEnabled(true);
        }
    }

    private void limpar() {
        painel1.limpar();
        painel2.limpar();
        botaoIniciar.setEnabled(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
