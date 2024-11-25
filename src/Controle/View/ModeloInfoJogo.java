package Controle.View;

import Controle.ControladorJogo;
import Controle.Jogar;
import Visualização.ComponenteVisual;

import java.awt.*;

public class ModeloInfoJogo extends ComponenteVisual {
    private ControladorJogo controladorJogo;
    private Jogar jogar;

    public ModeloInfoJogo(ControladorJogo controladorJogo, Jogar jogar) {
        this.controladorJogo = controladorJogo;
        this.jogar = jogar;
    }

    public void definirEstilo(){
        this.setLayout(new GridLayout(3, 1));
        this.setBackground(new Color(100, 10, 100));
    }
}
