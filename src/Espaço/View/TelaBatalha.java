package Espaço.View;

import Baralhos.View.ModeloMaoJogador;
import Controle.ControladorJogo;
import Controle.Jogador;
import Controle.View.ModeloInfoJogador;
import Visualização.Tela;

import javax.swing.*;
import java.awt.*;

public class TelaBatalha extends Tela
{
    private ModeloMaoJogador modeloMaoJogador1;
    private ModeloMaoJogador modeloMaoJogador2;
    private ModeloInfoJogador modeloInfoJogador1;
    private ModeloInfoJogador modeloInfoJogador2;
    private ModeloCemiterio modeloCemiterioJogador1;
    private ModeloCemiterio modeloCemiterioJogador2;
    private ModeloCampoDeBatalha modeloCampoDeBatalhaJogador1;
    private ModeloCampoDeBatalha modeloCampoDeBatalhaJogador2;
    private ControladorJogo controladorJogo;

    public TelaBatalha(Jogador jogador1, Jogador jogador2, ControladorJogo controladorJogo) {
        //Estabelecendo controlador da tela, responsavel por referenciar e chamar atualizações
        this.controladorJogo = controladorJogo;

        //Cosntrutor irá atribuir e gerar todos os modelos que irão compor a tela
        this.modeloMaoJogador1 = new ModeloMaoJogador(jogador1.getMao(), this.getControladorJogo().getJogador1(), this.getControladorJogo());
        this.modeloMaoJogador2 = new ModeloMaoJogador(jogador2.getMao(), this.getControladorJogo().getJogador2(), this.getControladorJogo());
        this.modeloCampoDeBatalhaJogador1 = new ModeloCampoDeBatalha(jogador1.getCampoDeBatalha(), this.getControladorJogo().getJogador1(), this.getControladorJogo());
        this.modeloCampoDeBatalhaJogador2 = new ModeloCampoDeBatalha(jogador2.getCampoDeBatalha(), this.getControladorJogo().getJogador2(), this.getControladorJogo());
        this.modeloInfoJogador1 = new ModeloInfoJogador(jogador1);
        this.modeloInfoJogador2 = new ModeloInfoJogador(jogador2);
        this.modeloCemiterioJogador1 = new ModeloCemiterio(jogador1.getCemiterio(), this.getControladorJogo().getJogador1(), this.getControladorJogo());
        this.modeloCemiterioJogador2 = new ModeloCemiterio(jogador2.getCemiterio(), this.getControladorJogo().getJogador2(), this.getControladorJogo());

        this.renderizar(jogador1, jogador2);
    }

    @Override
    public void renderizar(Jogador jogador1, Jogador jogador2) {
        this.setLayout(new BorderLayout());

        JPanel painelNorte = new JPanel();
        painelNorte.add(modeloMaoJogador2);
        this.add(painelNorte, BorderLayout.NORTH);
        painelNorte.setBackground(new Color(119, 2, 2));

        JPanel painelSul = new JPanel();
        painelSul.add(modeloMaoJogador1);
        painelSul.setBackground(new Color(1, 31, 99));
        this.add(painelSul, BorderLayout.SOUTH);

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(2, 1));
        painelCentral.add(modeloCampoDeBatalhaJogador2);
        painelCentral.add(modeloCampoDeBatalhaJogador1);
        this.add(painelCentral, BorderLayout.CENTER);

        //Provisório para mapear a tela - porção Oeste
        JPanel painelOeste = new JPanel();
        painelOeste.setLayout(new GridLayout(2, 1));
        painelOeste.setPreferredSize(new Dimension(320, painelOeste.getPreferredSize().height));

        painelOeste.add(modeloCemiterioJogador2);
        painelOeste.add(modeloCemiterioJogador1);
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

        painelLeste.add(modeloInfoJogador2);
        painelLeste.add(contadorRodadas);
        painelLeste.add(modeloInfoJogador1);

        this.add(painelLeste, BorderLayout.EAST);
    }

    public void atualizarElementos() {
        //Atualiza as mãos
        getModeloMaoJogador1().atualizar();
        getModeloMaoJogador2().atualizar();

        //Atualiza os campos
        getModeloCampoDeBatalhaJogador1().atualizar();
        getModeloCampoDeBatalhaJogador2().atualizar();

        //Atualiza os cemiterios
        getModeloCemiterioJogador1().atualizar();
        getModeloCemiterioJogador2().atualizar();

        //Atualiza as informações
        getModeloInfoJogador1().atualizar();
        getModeloInfoJogador2().atualizar();
    }

    public void setModeloMaoJogador1(ModeloMaoJogador modeloMaoJogador1) {
        this.modeloMaoJogador1 = modeloMaoJogador1;
    }

    public void setModeloMaoJogador2(ModeloMaoJogador modeloMaoJogador2) {
        this.modeloMaoJogador2 = modeloMaoJogador2;
    }

    public ModeloInfoJogador getModeloInfoJogador1() {
        return modeloInfoJogador1;
    }

    public void setModeloInfoJogador1(ModeloInfoJogador modeloInfoJogador1) {
        this.modeloInfoJogador1 = modeloInfoJogador1;
    }

    public ModeloInfoJogador getModeloInfoJogador2() {
        return modeloInfoJogador2;
    }

    public void setModeloInfoJogador2(ModeloInfoJogador modeloInfoJogador2) {
        this.modeloInfoJogador2 = modeloInfoJogador2;
    }

    public ModeloCemiterio getModeloCemiterioJogador1() {
        return modeloCemiterioJogador1;
    }

    public void setModeloCemiterioJogador1(ModeloCemiterio modeloCemiterioJogador1) {
        this.modeloCemiterioJogador1 = modeloCemiterioJogador1;
    }

    public ModeloCemiterio getModeloCemiterioJogador2() {
        return modeloCemiterioJogador2;
    }

    public void setModeloCemiterioJogador2(ModeloCemiterio modeloCemiterioJogador2) {
        this.modeloCemiterioJogador2 = modeloCemiterioJogador2;
    }

    public ModeloCampoDeBatalha getModeloCampoDeBatalhaJogador1() {
        return modeloCampoDeBatalhaJogador1;
    }

    public void setModeloCampoDeBatalhaJogador1(ModeloCampoDeBatalha modeloCampoDeBatalhaJogador1) {
        this.modeloCampoDeBatalhaJogador1 = modeloCampoDeBatalhaJogador1;
    }

    public ModeloCampoDeBatalha getModeloCampoDeBatalhaJogador2() {
        return modeloCampoDeBatalhaJogador2;
    }

    public void setModeloCampoDeBatalhaJogador2(ModeloCampoDeBatalha modeloCampoDeBatalhaJogador2) {
        this.modeloCampoDeBatalhaJogador2 = modeloCampoDeBatalhaJogador2;
    }

    public ModeloMaoJogador getModeloMaoJogador1() {
        return modeloMaoJogador1;
    }

    public ModeloMaoJogador getModeloMaoJogador2() {
        return modeloMaoJogador2;
    }

    public void setControladorJogo(ControladorJogo controladorJogo) {
        this.controladorJogo = controladorJogo;
    }

    public ControladorJogo getControladorJogo() {
        return controladorJogo;
    }
}