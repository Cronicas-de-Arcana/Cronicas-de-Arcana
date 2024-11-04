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
        painelNorte.setBackground(new Color(119, 2, 2));

        JPanel painelSul = new JPanel();
        painelSul.add(new ModeloMaoJogador(jogador1.getMao()));
        painelSul.setBackground(new Color(1, 31, 99));
        this.add(painelSul, BorderLayout.SOUTH);

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(2, 1));
        painelCentral.add(new ModeloCampoDeBatalha(jogador2.getCampoDeBatalha()));
        painelCentral.add(new ModeloCampoDeBatalha(jogador1.getCampoDeBatalha()));
        this.add(painelCentral, BorderLayout.CENTER);

        //Provisório para mapear a tela - porção Oeste
        JPanel painelOeste = new JPanel();
        painelOeste.setBackground(Color.BLACK);
        painelOeste.setLayout(new GridLayout(2, 1));
        painelOeste.setPreferredSize(new Dimension(320, painelOeste.getPreferredSize().height));

        JLabel texto = new JLabel("Cemitério Jogador2");
        texto.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setForeground(Color.WHITE);

        JLabel texto2 = new JLabel("Cemiterio Jogador1");
        texto2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        texto2.setHorizontalAlignment(SwingConstants.CENTER);
        texto2.setForeground(Color.WHITE);

        painelOeste.add(texto);
        painelOeste.add(texto2);
        this.add(painelOeste, BorderLayout.WEST);

        //Provisório para mapear a tela - porção Leste
        JPanel painelLeste = new JPanel();
        painelLeste.setBackground(new Color(13, 112, 4));
        painelLeste.setLayout(new GridLayout(3, 1));
        painelLeste.setPreferredSize(new Dimension(320, painelOeste.getPreferredSize().height));

        JLabel informacaoJogador2 = new JLabel("Informações Jogador 2 aqui!");
        informacaoJogador2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        informacaoJogador2.setHorizontalAlignment(SwingConstants.CENTER);
        informacaoJogador2.setForeground(Color.WHITE);

        JLabel contadorRodadas = new JLabel("Rodada nºX + Futuras informações adicinais!");
        contadorRodadas.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        contadorRodadas.setHorizontalAlignment(SwingConstants.CENTER);
        contadorRodadas.setForeground(Color.WHITE);

        JLabel informacaoJogador1 = new JLabel("Informações Jogador 1 aqui!");
        informacaoJogador1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        informacaoJogador1.setHorizontalAlignment(SwingConstants.CENTER);
        informacaoJogador1.setForeground(Color.WHITE);

        painelLeste.add(informacaoJogador2);
        painelLeste.add(contadorRodadas);
        painelLeste.add(informacaoJogador1);

        this.add(painelLeste, BorderLayout.EAST);
    }
}
