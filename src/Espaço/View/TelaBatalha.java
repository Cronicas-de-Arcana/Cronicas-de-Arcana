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

        this.add(new ModeloMaoJogador(jogador1.getMao()), BorderLayout.NORTH);
        this.add(new ModeloMaoJogador(jogador2.getMao()), BorderLayout.SOUTH);

        JPanel painelCentral = new JPanel(new BoxLayout(this, BoxLayout.Y_AXIS));
        painelCentral.add(new ModeloCampoDeBatalha(jogador1.getCampoDeBatalha()));
        painelCentral.add(new ModeloCampoDeBatalha(jogador2.getCampoDeBatalha()));
        this.add(painelCentral, BorderLayout.CENTER);

        JButton botaoEsquerdo = new JButton("Esquerdo");
        JButton botaoDireito = new JButton("Direito");
        this.setVisible(true);
    }
}
