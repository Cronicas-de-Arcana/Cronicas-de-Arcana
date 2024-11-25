package Espaço.View;

import Baralhos.View.ModeloMaoJogador;
import Controle.ControladorJogo;
import Controle.Jogador;
import Controle.View.ModeloInfoJogador;
import Controle.View.ModeloInfoJogo;
import Visualização.Tela;

import javax.swing.*;
import java.awt.*;

public class TelaBatalha extends Tela
{
    private ModeloMaoJogador modeloMaoJogador1;
    private ModeloMaoJogador modeloMaoJogador2;
    private ModeloInfoJogador modeloInfoJogador1;
    private ModeloInfoJogador modeloInfoJogador2;
    private ModeloInfoJogo modeloInfoJogo;
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
        this.modeloInfoJogo = new ModeloInfoJogo(this.getControladorJogo());
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
        painelLeste.setPreferredSize(new Dimension(320, painelOeste.getPreferredSize().height));

        painelLeste.add(modeloInfoJogador2);
        painelLeste.add(modeloInfoJogo);
        painelLeste.add(modeloInfoJogador1);

        this.add(painelLeste, BorderLayout.EAST);
    }

    public ModeloInfoJogador getModeloInfoJogador1() {
        return modeloInfoJogador1;
    }

    public ModeloInfoJogador getModeloInfoJogador2() {
        return modeloInfoJogador2;
    }

    public ModeloInfoJogo getModeloInfoJogo() {
        return modeloInfoJogo;
    }

    public ModeloCemiterio getModeloCemiterioJogador1() {
        return modeloCemiterioJogador1;
    }

    public ModeloCemiterio getModeloCemiterioJogador2() {
        return modeloCemiterioJogador2;
    }

    public ModeloCampoDeBatalha getModeloCampoDeBatalhaJogador1() {
        return modeloCampoDeBatalhaJogador1;
    }

    public ModeloCampoDeBatalha getModeloCampoDeBatalhaJogador2() {
        return modeloCampoDeBatalhaJogador2;
    }

    public ModeloMaoJogador getModeloMaoJogador1() {
        return modeloMaoJogador1;
    }

    public ModeloMaoJogador getModeloMaoJogador2() {
        return modeloMaoJogador2;
    }

    public ControladorJogo getControladorJogo() {
        return controladorJogo;
    }

    public void atualizarElementos() {
        //Atualiza as mãos
        atualizarMaos();

        //Atualiza os campos
        atualizarCampos();

        //Atualiza os cemiterios
        atualizarCemiterios();

        //Atualiza as informações
        atualizarInformacoes();
    }

    public void atualizarMaos(){
        getModeloMaoJogador1().atualizar();
        getModeloMaoJogador2().atualizar();
    }

    public void atualizarCampos(){
        getModeloCampoDeBatalhaJogador1().atualizar();
        getModeloCampoDeBatalhaJogador2().atualizar();
    }

    public void atualizarCemiterios(){
        getModeloCemiterioJogador1().atualizar();
        getModeloCemiterioJogador2().atualizar();
    }

    public void atualizarInformacoes(){
        getModeloInfoJogador1().atualizar();
        getModeloInfoJogador2().atualizar();
        getModeloInfoJogo().atualizar();
    }

}