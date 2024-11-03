package Espaço.View;

import Cartas.Carta;
import Cartas.View.ModeloCarta;
import Espaço.CampodeBatalha;
import Visualização.ComponenteVisual;

import java.awt.*;
import java.util.ArrayList;

public class ModeloCampoDeBatalha extends ComponenteVisual {
    private CampodeBatalha campoBatalha;
    private ArrayList<ModeloCarta> modelosCartas;

    public ModeloCampoDeBatalha(CampodeBatalha campoBatalha) {
        this.campoBatalha = campoBatalha;
        this.modelosCartas = new ArrayList<>();
        this.renderizar();
        this.definirEstilo();
    }

    @Override
    public void definirEstilo() {
        this.setLayout(new GridLayout(3, 3, 4, 6));
        this.setBackground(new Color(21, 1, 101));
    }

    // Renderiza todas as cartas do campo de batalha
    public void renderizar(){
        this.removeAll();
        modelosCartas.clear();

        for (Carta carta : campoBatalha.getCampo()) {
            ModeloCarta modelo = new ModeloCarta(carta);
            modelosCartas.add(modelo);
            this.add(modelo);  // Adiciona o modelo visual da carta ao layout
        }

        revalidate();
        repaint();
    }

    // Atualiza o campo de batalha dinamicamente
    public void atualizarCampo() {
        renderizar();  // Re-renderiza o campo ao atualizar as cartas
    }

    // Adiciona uma carta ao campo de batalha e atualiza a interface
    public void adicionarCarta(Carta carta) {
        campoBatalha.adicionarCarta(carta);  // Adiciona a carta ao campo
        atualizarCampo();                    // Atualiza a interface para refletir a mudança
    }

    // Remove uma carta do campo de batalha e atualiza a interface
    public void removerCarta(Carta carta) {
        campoBatalha.removerCarta(carta);    // Remove a carta do campo
        atualizarCampo();                    // Atualiza a interface para refletir a mudança
    }
}

