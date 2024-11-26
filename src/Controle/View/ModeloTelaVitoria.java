package Controle.View;

import Cartas.View.ModeloCarta;
import Controle.ControladorJogo;
import Controle.Jogador;
import Visualização.ComponenteVisual;

import java.awt.*;
import java.util.ArrayList;

public class ModeloTelaVitoria extends ComponenteVisual {
    private Jogador jogadorGanhador;
    private ArrayList<ModeloCarta> cartasGanhas;
    private ControladorJogo controladorJogo;

    public ModeloTelaVitoria(Jogador jogadorGanhador, ControladorJogo controladorJogo) {
        this.jogadorGanhador = jogadorGanhador;
        this.controladorJogo = controladorJogo;
        definirEstilo();
        renderizar();
    }

    public ControladorJogo getControladorJogo() {
        return controladorJogo;
    }

    public void setControladorJogo(ControladorJogo controladorJogo) {
        this.controladorJogo = controladorJogo;
    }

    public void definirEstilo() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);
    }

    @Override
    public void renderizar() {

    }
}
