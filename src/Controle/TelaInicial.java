package Controle;

import Visualização.Tela;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends Tela{

    public TelaInicial(){
        this.renderizar();
    }

    public void renderizar(){
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(68, 41, 170));

        //Cria bloco de texto que vai ficar na parte NORTE da tela inicial
        JLabel titulo = new JLabel("Cronicas de Arcana", JLabel.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(45, 0, 0 ,0));
        titulo.setFont(new Font("Arial", Font.BOLD, 48));
        titulo.setForeground(new Color(255, 255, 255));
        this.add(titulo, BorderLayout.NORTH);

        //Criando botão iniciar partida e definindo parametros para ajustá-lo no centro
        JButton botaoIniciar = new JButton("Iniciar Partida");
        botaoIniciar.setFont(new Font("Arial", Font.BOLD, (int) (titulo.getFont().getSize()*0.7)));
        botaoIniciar.setBackground(Color.WHITE);
        botaoIniciar.setPreferredSize(new Dimension(320, 120));
        GridBagConstraints configuracaoBotao = new GridBagConstraints();
        configuracaoBotao.gridx = 0;
        configuracaoBotao.gridy = 0;
        configuracaoBotao.weightx = 1.0;
        configuracaoBotao.weighty = 1.0;
        configuracaoBotao.anchor = GridBagConstraints.CENTER;

        //Criando painel e adicionando botão no centro dele
        JPanel painelCentro = new JPanel();
        painelCentro.setLayout(new GridBagLayout());
        painelCentro.setBackground(new Color(68, 41, 170));
        painelCentro.add(botaoIniciar, configuracaoBotao);

        //Adicionando painel central configurado na tela
        this.add(painelCentro, BorderLayout.CENTER);
        setVisible(true);
    }

}
