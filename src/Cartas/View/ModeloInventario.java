package Cartas.View;

import Baralhos.Deck;
import Controle.ControladorJogo;
import Controle.Jogador;
import Controle.View.TelaInventario;
import Visualização.ComponenteVisual;

import javax.swing.*;
import java.awt.*;

public class ModeloInventario extends ComponenteVisual {
    private TelaInventario telaInventario;
    private ControladorJogo controladorJogo;

    public ModeloInventario(Jogador jogador, TelaInventario telaInventario, ControladorJogo controladorJogo) {
        this.telaInventario = telaInventario;
        this.controladorJogo = controladorJogo;
        this.definirEstilo();
        this.renderizar();
    }

    public ControladorJogo getControladorJogo() {
        return controladorJogo;
    }

    public TelaInventario getTelaInventario() {
        return telaInventario;
    }

    @Override
    public void definirEstilo() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        //this.setLayout(new GridLayout(2, 2, 10, 10));
        this.setBackground(new Color(68, 41, 170));
    }

    public void renderizar(){
        this.removeAll(); // Limpa componentes anteriores

        // Criação dos botões
        JButton botaoDeck1 = new JButton("Deck 1");
        botaoDeck1.addActionListener(e -> {
            //Ao escolher esse botao deve ser definido o Deck padrão 1 do inventario e mudar a tela baseado no jogador Atual
            Deck deckEscolhido = new Deck(controladorJogo.getInventario().inicializadorCartasJ1());
            controladorJogo.getJogadorAtual().setDeck(deckEscolhido);

            if (controladorJogo.getJogadorAtual() == controladorJogo.getJogador1()) {
                controladorJogo.setJogadorAtual(controladorJogo.getJogador2());
                controladorJogo.mostrarTelaInventario(controladorJogo.getJogador2());
            } else {
                //Após jogador 2 escolher seu deck devemos iniciar as mãos, mostrar a tela de batalha e iniciar a partida!
                controladorJogo.setJogadorAtual(null);
                controladorJogo.mostrarTelaBatalha();
                controladorJogo.inicializacaoMaos();

            }
        });

        JButton botaoDeck2 = new JButton("Deck 2");
        botaoDeck2.addActionListener(e -> {
            //Ao escolher esse botao deve ser definido o Deck padrão 2 do inventario e mudar a tela baseado no jogador Atual
            Deck deckEscolhido = new Deck(controladorJogo.getInventario().inicializadorCartasJ2());
            controladorJogo.getJogadorAtual().setDeck(deckEscolhido);

            if (controladorJogo.getJogadorAtual() == controladorJogo.getJogador1()) {
                controladorJogo.setJogadorAtual(controladorJogo.getJogador2());
                controladorJogo.mostrarTelaInventario(controladorJogo.getJogador2());
            } else {
                controladorJogo.setJogadorAtual(null);
                controladorJogo.mostrarTelaBatalha();
                controladorJogo.inicializacaoMaos();
            }
        });

        JButton botaoDeck3 = new JButton("Deck 3");
        botaoDeck3.addActionListener(e -> {
            //Ao escolher esse botao deve ser definido o Deck padrão 1 do inventario e mudar a tela baseado no jogador Atual
            Deck deckEscolhido = new Deck(controladorJogo.getInventario().inicializadorCartasJ3());
            controladorJogo.getJogadorAtual().setDeck(deckEscolhido);

            if (controladorJogo.getJogadorAtual() == controladorJogo.getJogador1()) {
                controladorJogo.setJogadorAtual(controladorJogo.getJogador2());
                controladorJogo.mostrarTelaInventario(controladorJogo.getJogador2());
            } else {
                //Após jogador 2 escolher seu deck devemos iniciar as mãos, mostrar a tela de batalha e iniciar a partida!
                controladorJogo.setJogadorAtual(null);
                controladorJogo.mostrarTelaBatalha();
                controladorJogo.inicializacaoMaos();
            }
        });

        // Adiciona os botões ao painel
        this.add(botaoDeck1);
        this.add(botaoDeck2);
        this.add(botaoDeck3);
    }
}
