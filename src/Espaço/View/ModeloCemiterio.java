package Espaço.View;

import Cartas.Carta;
import Cartas.View.ModeloCarta;
import Espaço.Cemiterio;
import Visualização.ComponenteVisual;

import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class ModeloCemiterio extends ComponenteVisual {
    private Cemiterio cemiterio;
    private ArrayList<ModeloCarta> modelosCartasCemiterio;

    public ModeloCemiterio(Cemiterio cemiterio) {
        this.cemiterio = cemiterio;
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
            ModeloCarta modeloCarta = new ModeloCarta(carta);
            modelosCartasCemiterio.add(modeloCarta);
            this.add(modeloCarta);
        }

        revalidate();
        repaint();
    }

}
