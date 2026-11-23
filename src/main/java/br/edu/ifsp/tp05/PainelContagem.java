package br.edu.ifsp.tp05;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

import javax.swing.SwingUtilities;

/** Painel de uma contagem. Cada instância é executada por uma Thread própria. */
public class PainelContagem extends JPanel implements Runnable {
    private final String identificacao;
    private final int valorMaximo;
    private final int prioridade;
    private final DefaultListModel<Integer> modelo = new DefaultListModel<>();
    private final JLabel labelFim = new JLabel(" ");
    private final JList<Integer> lista = new JList<>(modelo);
    private final Runnable aoFinalizar;

    public PainelContagem(String identificacao, int valorMaximo, int prioridade, Runnable aoFinalizar) {
        this.identificacao = identificacao;
        this.valorMaximo = valorMaximo;
        this.prioridade = prioridade;
        this.aoFinalizar = aoFinalizar;
        montarTela();
    }

    private void montarTela() {
        setLayout(new BorderLayout(5, 5));
        lista.setVisibleRowCount(12);
        add(new JScrollPane(lista), BorderLayout.CENTER);
        labelFim.setHorizontalAlignment(JLabel.CENTER);
        add(labelFim, BorderLayout.SOUTH);
    }

    public void limpar() {
        modelo.clear();
        labelFim.setText(" ");
    }

    @Override
    public void run() {
        try {
            for (int valor = 1; valor <= valorMaximo; valor++) {
                final int valorAtual = valor;
                SwingUtilities.invokeAndWait(() -> modelo.addElement(valorAtual));
            }
            SwingUtilities.invokeLater(() -> {
                labelFim.setText("Final " + identificacao);
                aoFinalizar.run();
            });
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } catch (Exception ex) {
            SwingUtilities.invokeLater(() -> labelFim.setText("Erro na " + identificacao));
        }
    }

    public Thread criarThread() {
        Thread thread = new Thread(this, "Thread-" + identificacao);
        thread.setPriority(prioridade);
        return thread;
    }
}
