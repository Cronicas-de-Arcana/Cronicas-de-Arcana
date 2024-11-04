package Controle.View;

import Controle.ControladorJogo;
import Visualização.OuvinteMudancaTela;
import Visualização.Tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends Tela {
    private OuvinteMudancaTela ouvinte;
    private ControladorJogo controlador;

    public TelaInicial(ControladorJogo controlador) {
        this.controlador = controlador;
        this.renderizar();
    }

    public void setOuvinteMudancaTela(OuvinteMudancaTela ouvinte) {
        this.ouvinte = ouvinte;
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

        //Criando botão iniciar
        JButton botaoIniciar = new JButton("Iniciar Partida");
        botaoIniciar.setFont(new Font("Arial", Font.BOLD, (int) (titulo.getFont().getSize()*0.7)));
        botaoIniciar.setBackground(Color.WHITE);
        botaoIniciar.setPreferredSize(new Dimension(320, 120));

        // Configuração do Botão e ActionListener
        GridBagConstraints configuracaoBotao = new GridBagConstraints();
        configuracaoBotao.gridx = 0;
        configuracaoBotao.gridy = 0;
        configuracaoBotao.weightx = 1.0;
        configuracaoBotao.weighty = 1.0;
        configuracaoBotao.anchor = GridBagConstraints.CENTER;


        botaoIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Classe controlador inicia o jogo pelo construtor
                // vamos ter que mudar para a entrega final
                controlador.mostrarTelaBatalha();
            }
        });

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