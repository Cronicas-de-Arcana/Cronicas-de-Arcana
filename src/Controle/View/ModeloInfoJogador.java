package Controle.View;

import Controle.Jogador;
import Visualização.ComponenteVisual;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ModeloInfoJogador extends ComponenteVisual {
    private Jogador jogador;

    public ModeloInfoJogador(Jogador jogador) {
        this.jogador = jogador;
        definirEstilo();
        renderizar();
    }

    public void definirEstilo() {
        this.setLayout(new GridLayout(4, 1)); // 4 linhas, 1 coluna
        this.setBackground(new Color(2, 67, 2));
        this.setBorder(new LineBorder(Color.WHITE, 1));
    }

    public void renderizar() {
        JLabel nomeJogador = criarLabel(this.jogador.getNome());
        JLabel hpJogador = criarLabel("HP: " + this.jogador.getHp());
        JLabel nivel = criarLabel("Nível: " + this.jogador.getNivel());
        JLabel manaAtual = criarLabel("Mana: " + this.jogador.getManaAtual());

        this.add(nomeJogador);
        this.add(hpJogador);
        this.add(nivel);
        this.add(manaAtual);
    }

    private JLabel criarLabel(String texto) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER); // Centraliza o texto
        label.setOpaque(true); // Permite alterar o fundo
        label.setBackground(new Color(34, 139, 34)); // Fundo verde escuro
        label.setForeground(Color.WHITE); // Texto branco
        label.setBorder(new LineBorder(Color.WHITE, 1)); // Borda branca
        label.setFont(new Font("Arial", Font.BOLD, 16)); // Define uma fonte maior
        return label;
    }
}

