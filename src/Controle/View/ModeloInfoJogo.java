package Controle.View;

import Controle.ControladorJogo;
import Visualização.ComponenteVisual;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ModeloInfoJogo extends ComponenteVisual {
    private ControladorJogo controladorJogo;

    public ModeloInfoJogo(ControladorJogo controladorJogo) {
        this.controladorJogo = controladorJogo;
        definirEstilo();
        renderizar();
    }

    public void definirEstilo() {
        this.setLayout(new GridLayout(1, 2)); // 1 linha duas colunas
        this.setBorder(new LineBorder(Color.WHITE, 1)); // Borda branca
    }

    @Override
    public void renderizar() {
        removeAll();

        // Pega o nome do jogador atual, ou define "Não definido" caso seja null
        String nomeJogadorAtual = (controladorJogo.getJogadorAtual() != null && controladorJogo.getJogadorAtual().getNome() != null)
                ? controladorJogo.getJogadorAtual().getNome()
                : "Aguardando definição";

        // Define o texto para exibir a fase do jogo e o jogador atual
        JLabel faseJogo = criarLabel("Fase: " + controladorJogo.getFaseJogo());
        JLabel jogadorAtual = criarLabel("Vez de: " + nomeJogadorAtual);

        // Adiciona os componentes ao layout
        this.add(faseJogo);
        this.add(jogadorAtual);

        revalidate();
        repaint();
    }

    private JLabel criarLabel(String texto) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER); // Centraliza o texto
        label.setOpaque(true); // Permite alterar o fundo
        label.setBackground(new Color(17, 0, 128, 255)); // Fundo roxo médio
        label.setForeground(Color.WHITE); // Texto branco
        label.setBorder(new LineBorder(Color.WHITE, 1)); // Borda branca
        label.setFont(new Font("Arial", Font.BOLD, 16)); // Fonte maior e em negrito
        return label;
    }

    public void atualizar() {
        renderizar();
    }
}
