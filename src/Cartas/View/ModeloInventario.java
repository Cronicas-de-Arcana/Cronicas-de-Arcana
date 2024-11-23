package Cartas.View;

import Cartas.Carta;
import Cartas.Inventario;
import Controle.Jogador;
import Visualização.ComponenteVisual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModeloInventario extends ComponenteVisual {

    public ModeloInventario(Jogador jogador) {
        this.definirEstilo();
        this.renderizar();
    }

    @Override
    public void definirEstilo() {
        this.setLayout(new GridLayout(2, 2, 10, 10));
        this.setBackground(new Color(68, 41, 170));
    }

    public void renderizar(){
        this.removeAll(); // Limpa componentes anteriores

        // Criação dos botões
        JButton botaoDeck1 = new JButton("Deck 1");
        JButton botaoDeck2 = new JButton("Deck 2");
        JButton botaoDeck3 = new JButton("Deck 3");
        JButton botaoDeck4 = new JButton("Deck 4");

        // Adiciona os botões ao painel
        this.add(botaoDeck1);
        this.add(botaoDeck2);
        this.add(botaoDeck3);
        this.add(botaoDeck4);
    }
}
