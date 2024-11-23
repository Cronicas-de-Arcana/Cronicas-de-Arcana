package Controle.View;

import Cartas.View.ModeloInventario;
import Controle.ControladorJogo;
import Controle.Jogador;
import Visualização.Tela;

import javax.swing.*;
import java.awt.*;

public class TelaInventario extends Tela {
    private ControladorJogo controladorJogo;
    private ModeloInventario modeloInventario;

    public TelaInventario(ControladorJogo controladorJogo, Jogador jogador) {
        this.controladorJogo = controladorJogo;
        this.modeloInventario = new ModeloInventario(jogador, this, this.getControladorJogo());
        definirEstilo();
        renderizar(jogador);
    }

    public ControladorJogo getControladorJogo() {
        return controladorJogo;
    }

    public void definirEstilo(){
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(68, 41, 170));
    }

    public void renderizar(Jogador jogador) {
        JPanel painelInventario = new JPanel(new BorderLayout());
        painelInventario.add(modeloInventario, BorderLayout.CENTER); // Adiciona o ModeloInventario no centro
        this.add(painelInventario, BorderLayout.CENTER);

        JPanel painelSuperior = new JPanel();
        JLabel mensagem = new JLabel(jogador.getNome()+" escolha seu Deck:");
        mensagem.setOpaque(true);
        mensagem.setBackground(new Color(68, 41, 170,0));
        mensagem.setForeground(Color.WHITE);
        mensagem.setFont(new Font("Arial", Font.BOLD, 48));
        painelSuperior.add(mensagem);
        painelSuperior.setBackground(new Color(68, 41, 170));
        this.add(painelSuperior, BorderLayout.NORTH);
    }

}
