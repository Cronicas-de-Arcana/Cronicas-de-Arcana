package Espaço;

import Baralhos.VisualMaoJogador;
import Controle.Jogador;
import Visualização.Tela;

import java.awt.*;

public class TelaBatalha extends Tela
{

    public TelaBatalha(Jogador jogador1, Jogador jogador2) {
        this.renderizar(jogador1, jogador2);
    }

    @Override
    public void renderizar(Jogador jogador1, Jogador jogador2) {
        this.setLayout(new BorderLayout());

        this.add(new VisualMaoJogador(jogador1.getMao()), BorderLayout.NORTH);
        this.add(new VisualMaoJogador(jogador2.getMao()), BorderLayout.SOUTH);
    }
}
