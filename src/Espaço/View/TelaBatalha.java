package Espaço.View;

import Baralhos.View.ModeloMaoJogador;
import Controle.Jogador;
import Visualização.Tela;

import javax.swing.*;
import java.awt.*;

public class TelaBatalha extends Tela
{

    public TelaBatalha(Jogador jogador1, Jogador jogador2) {
        this.renderizar(jogador1, jogador2);
    }

    @Override
    public void renderizar(Jogador jogador1, Jogador jogador2) {
        this.setLayout(new BorderLayout());
        JPanel painelNorte = new JPanel();
        painelNorte.add(new ModeloMaoJogador(jogador2.getMao()));
        this.add(painelNorte, BorderLayout.NORTH);

        JPanel painelSul = new JPanel();
        painelSul.add(new ModeloMaoJogador(jogador1.getMao()));
        this.add(painelSul, BorderLayout.SOUTH);

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(2, 1));
        painelCentral.add(new ModeloCampoDeBatalha(jogador2.getCampoDeBatalha()));
        painelCentral.add(new ModeloCampoDeBatalha(jogador1.getCampoDeBatalha()));
        this.add(painelCentral, BorderLayout.CENTER);

    }
}
