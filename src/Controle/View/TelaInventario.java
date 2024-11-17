package Controle.View;

import Cartas.View.ModeloInventario;
import Controle.ControladorJogo;
import Controle.Jogador;
import Visualização.OuvinteMudancaTela;
import Visualização.Tela;

import java.awt.*;

public class TelaInventario extends Tela {
    private ControladorJogo controlador;

    public TelaInventario(ControladorJogo controlador, Jogador jogador1, Jogador jogador2) {
        this.controlador = controlador;
        renderizar(jogador1, jogador2);
    }

    public void renderizar(Jogador jogador1, Jogador jogador2) {
        this.setLayout(new GridLayout(2, 1));
        this.add(new ModeloInventario(jogador1));
        this.add(new ModeloInventario(jogador2));
    }
}
