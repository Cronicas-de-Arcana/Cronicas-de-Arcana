package Espaço.View;

import Baralhos.View.ModeloMaoJogador;
import Controle.Jogador;
import Controle.View.ModeloInfoJogador;
import Visualização.Tela;

import javax.swing.*;
import java.awt.*;

public class TelaBatalha extends Tela
{
    private ModeloMaoJogador ModeloMaoJogador1;
    private ModeloMaoJogador ModeloMaoJogador2;

    public TelaBatalha(Jogador jogador1, Jogador jogador2) {
        this.ModeloMaoJogador1 = new ModeloMaoJogador(jogador1.getMao());
        this.ModeloMaoJogador2 = new ModeloMaoJogador(jogador2.getMao());
        this.renderizar(jogador1, jogador2);
    }

    @Override
    public void renderizar(Jogador jogador1, Jogador jogador2) {
        this.setLayout(new BorderLayout());

        JPanel painelNorte = new JPanel();
        painelNorte.add(ModeloMaoJogador1);
        this.add(painelNorte, BorderLayout.NORTH);
        painelNorte.setBackground(new Color(119, 2, 2));

        JPanel painelSul = new JPanel();
        painelSul.add(ModeloMaoJogador2);
        painelSul.setBackground(new Color(1, 31, 99));
        this.add(painelSul, BorderLayout.SOUTH);

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(2, 1));
        painelCentral.add(new ModeloCampoDeBatalha(jogador2.getCampoDeBatalha()));
        painelCentral.add(new ModeloCampoDeBatalha(jogador1.getCampoDeBatalha()));
        this.add(painelCentral, BorderLayout.CENTER);

        //Provisório para mapear a tela - porção Oeste
        JPanel painelOeste = new JPanel();
        painelOeste.setLayout(new GridLayout(2, 1));
        painelOeste.setPreferredSize(new Dimension(320, painelOeste.getPreferredSize().height));

        painelOeste.add(new ModeloCemiterio(jogador2.getCemiterio()));
        painelOeste.add(new ModeloCemiterio(jogador1.getCemiterio()));
        this.add(painelOeste, BorderLayout.WEST);

        //Provisório para mapear a tela - porção Leste
        JPanel painelLeste = new JPanel();
        painelLeste.setLayout(new GridLayout(3, 1));
        painelLeste.setBackground(new Color(60, 43, 214));
        painelLeste.setPreferredSize(new Dimension(320, painelOeste.getPreferredSize().height));

        JLabel contadorRodadas = new JLabel("Rodada nºX + Futuras informações adicinais!");
        contadorRodadas.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        contadorRodadas.setHorizontalAlignment(SwingConstants.CENTER);
        contadorRodadas.setForeground(Color.WHITE);

        painelLeste.add(new ModeloInfoJogador(jogador2));
        painelLeste.add(contadorRodadas);
        painelLeste.add(new ModeloInfoJogador(jogador1));

        this.add(painelLeste, BorderLayout.EAST);
    }
}
