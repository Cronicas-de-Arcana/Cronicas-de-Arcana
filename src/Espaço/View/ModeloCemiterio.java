package Espaço.View;

import Cartas.Carta;
import Cartas.View.ModeloCarta;
import Controle.ControladorJogo;
import Controle.Jogador;
import Espaço.Cemiterio;
import Visualização.ComponenteVisual;

import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class ModeloCemiterio extends ComponenteVisual {
    private Cemiterio cemiterio;
    private ArrayList<ModeloCarta> modelosCartasCemiterio;
    private ControladorJogo controladorJogo;
    private Jogador jogador;

    public ModeloCemiterio(Cemiterio cemiterio, Jogador jogador, ControladorJogo controladorJogo) {
        this.cemiterio = cemiterio;
        this.jogador = jogador;
        this.controladorJogo = controladorJogo;
        this.modelosCartasCemiterio = new ArrayList<>();
        this.definirEstilo();
        this.renderizar();
    }

    public void definirEstilo(){
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(4, 2, 2));
        this.setBorder(new LineBorder(Color.WHITE, 1));
    }

    public void renderizar() {
        this.removeAll();
        modelosCartasCemiterio.clear();

        for (Carta carta : cemiterio.getCartas()) {
            ModeloCarta modeloCarta = new ModeloCarta(carta, jogador, controladorJogo, "Carta morta");
            modeloCarta.setBackground(new Color(34, 34, 34));
            modelosCartasCemiterio.add(modeloCarta);
            this.add(modeloCarta);
        }

        revalidate();
        repaint();
    }

}
