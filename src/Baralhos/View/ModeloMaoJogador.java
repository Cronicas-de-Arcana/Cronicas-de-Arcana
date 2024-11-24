package Baralhos.View;

import Controle.Jogador;
import Baralhos.Mao;
import Cartas.Carta;
import Cartas.View.ModeloCarta;
import Controle.ControladorJogo;
import Visualização.ComponenteVisual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModeloMaoJogador extends ComponenteVisual {
    private Mao mao;
    private ArrayList<ModeloCarta> modelosCartas;
    private ControladorJogo controladorJogo;
    private Jogador jogador;

    public ModeloMaoJogador(Mao mao, Jogador jogador,ControladorJogo controladorJogo) {
        this.mao = mao;
        this.jogador = jogador;
        this.controladorJogo = controladorJogo;
        this.modelosCartas = new ArrayList<>();
        this.definirEstilo();
        this.renderizar();
    }

    public ControladorJogo getControladorJogo() {
        return controladorJogo;
    }

    @Override
    public void definirEstilo() {
        this.setLayout(new GridLayout(1, 0, 10, 10)); // Layout para dispor as cartas lado a lado
        this.setBackground(new Color(0, 0,0, 0)); // Deixar transparente
    }

    // Metodo renderizar para exibir as cartas da mão
    public void renderizar() {
        // Limpa cartas anteriores antes de renderizar as novas
        this.removeAll();
        modelosCartas.clear();

        // Itera sobre as cartas na mão e cria modelos de cartas
        for (Carta carta : mao.getCartas()) {
            ModeloCarta modelo = new ModeloCarta(carta, jogador, controladorJogo, "Jogar Carta");
            modelosCartas.add(modelo);
            modelo.getBotao().addActionListener(e -> {
                controladorJogo.getJogadorAtual().jogarCartaCampo(carta, jogador);

                if(controladorJogo.getControleDeEscolhas()==2){
                    JOptionPane.showMessageDialog(null, "Fim da fase de escolha");
                    controladorJogo.setControleDeEscolhas(0);
                }
            });
            this.add(modelo);  // Adiciona o modelo visual da carta ao layout
        }

        JButton botaoPassarRodada = new JButton("Passar");
        botaoPassarRodada.setPreferredSize(new Dimension(180, 200));
        botaoPassarRodada.addActionListener(e -> {
            jogador.jogarCartaCampo(null, jogador);
        });
        this.add(botaoPassarRodada);

        // Atualiza o layout da mão do jogador para refletir as mudanças
        revalidate();
        repaint();
    }
}