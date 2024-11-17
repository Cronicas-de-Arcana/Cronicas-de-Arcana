package Cartas.View;

import Cartas.Carta;
import Cartas.Inventario;
import Controle.Jogador;
import Visualização.ComponenteVisual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModeloInventario extends ComponenteVisual {
    private Inventario inventario;
    private ArrayList<ModeloCarta> modelosCartas;

    public ModeloInventario(Jogador jogador) {
        this.inventario = jogador.getInventario();
        this.modelosCartas = new ArrayList<>();
        this.definirEstilo();
        this.renderizar();
    }

    @Override
    public void definirEstilo() {
        this.setLayout(new GridLayout(6, 5, 10, 10));
        this.setBackground(Color.BLACK);
    }

    public void renderizar(){
        this.removeAll();
        modelosCartas.clear();

        for (Carta carta : inventario.getCartasInventario()){
            ModeloCarta modelo = new ModeloCarta(carta);
            modelosCartas.add(modelo);
            this.add(modelo);
        }

        revalidate();
        repaint();

        JButton botao = new JButton("Cartas selecionadas");
        this.add(botao);
    }
}
