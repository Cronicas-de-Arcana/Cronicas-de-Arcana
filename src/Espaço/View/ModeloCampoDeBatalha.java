package Espaço.View;

import Cartas.Carta;
import Cartas.Criatura;
import Cartas.View.ModeloCarta;
import Controle.ControladorJogo;
import Controle.Jogador;
import Espaço.CampodeBatalha;
import Visualização.ComponenteVisual;

import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class ModeloCampoDeBatalha extends ComponenteVisual {
    private CampodeBatalha campoBatalha;
    private ArrayList<ModeloCarta> modelosCartas;
    private ControladorJogo controladorJogo;
    private Jogador jogador;

    public ModeloCampoDeBatalha(CampodeBatalha campoBatalha, Jogador jogador, ControladorJogo controladorJogo) {
        this.campoBatalha = campoBatalha;
        this.jogador = jogador;
        this.controladorJogo = controladorJogo;
        this.modelosCartas = new ArrayList<>();
        this.renderizar();
        this.definirEstilo();
    }

    @Override
    public void definirEstilo() {
        this.setLayout(new GridLayout(1, 0, 10, 10));
        this.setBackground(new Color(55, 51, 51));
        this.setBorder(new LineBorder(new Color(255, 255, 255)));
    }

    // Renderiza todas as cartas do campo de batalha
    public void renderizar(){
        this.removeAll();
        modelosCartas.clear();

        for (Carta carta : campoBatalha.getCampo()) {
            ModeloCarta modelo = new ModeloCarta(carta, jogador, controladorJogo);
            modelosCartas.add(modelo);
            this.add(modelo);  // Adiciona o modelo visual da carta ao layout
        }

        revalidate();
        repaint();
    }
}

