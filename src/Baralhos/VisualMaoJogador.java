package Baralhos;

import Cartas.ModeloCarta;
import Visualização.ComponenteVisual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VisualMaoJogador extends ComponenteVisual {
    ArrayList<ModeloCarta> modelosCartas;

    public VisualMaoJogador(){
        this.definirEstilo();
        this.renderizar();
    }

    //Pensar como vou pegar as cartas da mao do player!
    public void renderizar(Mao mao){

    }

    @Override
    public void definirEstilo() {
        this.setLayout(new GridLayout());
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
    }
}
