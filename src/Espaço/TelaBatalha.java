package Espaço;

import Baralhos.VisualMaoJogador;
import Visualização.Tela;

import java.awt.*;

public class TelaBatalha extends Tela
{

    public TelaBatalha() {
        this.renderizar();
    }

    @Override
    public void renderizar() {
        this.setLayout(new BorderLayout());

        //this.add(new VisualMaoJogador(), BorderLayout.NORTH);
        //this.add(new VisualMaoJogador(), BorderLayout.SOUTH);
    }
}
