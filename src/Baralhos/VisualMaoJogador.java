package Baralhos;

import Visualização.ComponenteVisual;

import javax.swing.*;
import java.awt.*;

public class VisualMaoJogador extends ComponenteVisual {
    JButton[] botao = new JButton[5];

    public void renderizar(){
        for (int i = 0; i < 5; i++){
            botao[i] = new JButton("Botão" + (i + 1));
            this.add(botao[i]);
        }
        setVisible(true);
    }

    @Override
    public void definirEstilo() {
        this.setLayout(new GridLayout());
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
    }

    public VisualMaoJogador(){
        this.definirEstilo();
        this.renderizar();

    }
}
