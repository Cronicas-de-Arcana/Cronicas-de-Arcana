package Espaço.View;

import Cartas.Carta;
import Cartas.View.ModeloCarta;
import Controle.ControladorJogo;
import Controle.Jogador;
import Espaço.CampodeBatalha;
import Visualização.ComponenteVisual;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class ModeloCampoDeBatalha extends ComponenteVisual {
    private CampodeBatalha campoBatalha;
    private ArrayList<ModeloCarta> modelosCartas;
    private ControladorJogo controladorJogo;
    private Jogador jogador;

    public ModeloCampoDeBatalha(CampodeBatalha campoBatalha, Jogador jogador, ControladorJogo controladorJogo) {
        this.campoBatalha = campoBatalha;
        this.jogador = jogador;
        this.controladorJogo = controladorJogo;
        this.modelosCartas = new ArrayList<>();
        this.renderizar();
        this.definirEstilo();
    }

    @Override
    public void definirEstilo() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        this.setBackground(new Color(55, 51, 51));
        this.setBorder(new LineBorder(new Color(255, 255, 255)));
    }

    // Renderiza todas as cartas do campo de batalha
    public void renderizar(){
        this.removeAll();
        modelosCartas.clear();

        for (Carta carta : campoBatalha.getCampo()) {
            ModeloCarta modelo = new ModeloCarta(carta, jogador, controladorJogo, "Atacar");
            modelosCartas.add(modelo);

            modelo.getBotao().addActionListener(e -> {
                //Verificador fase de ataque
                if (controladorJogo.getFaseJogo().equals("ATAQUE")) {
                    atribuirCarta(carta, jogador);
                } else {
                    JOptionPane.showMessageDialog(null, "Ainda não é a fase de Ataque!");
                }
            });

            this.add(modelo);  // Adiciona o modelo visual da carta ao layout
        }

        JButton botaoVazio = new JButton("Vazio");
        botaoVazio.addActionListener(e -> {

            //Se não for a fase de ataque, o botao "vazio" ira indicar que ainda nao esta na fase de ataque
            if (!controladorJogo.getFaseJogo().equals("ATAQUE")) {
                JOptionPane.showMessageDialog(null, "Ainda não é a fase de Ataque!");
            }
            else{
                atribuirCarta(null, jogador);
            }
        });

        this.add(botaoVazio);

        revalidate();
        repaint();
    }

    public void atribuirCarta(Carta carta, Jogador jogador) {
        if (controladorJogo.getJogadorAtual().equals(jogador)) {
            controladorJogo.getJogar().setCartaAtacante(carta);
            JOptionPane.showMessageDialog(null, "Carta atacante definida!");
            controladorJogo.getJogar().validarCampoOponente(); // Validar oponente aqui
        } else {
            controladorJogo.getJogar().setCartaAlvo(carta);
            JOptionPane.showMessageDialog(null, "Carta alvo definida!");
        }

        // Verifica se o ataque pode ser executado
        if (controladorJogo.getJogar().getCartaAtacante() != null && controladorJogo.getJogar().getCartaAlvo() != null) {
            controladorJogo.getJogar().executarAtaque();

            // Verifica se todas as ações foram concluídas
            if (controladorJogo.verificarJogadoresJogaram()) {
                controladorJogo.setFaseJogo("ESCOLHA"); // Define a fase de escolha
                controladorJogo.getJanela().getTelaBatalha().atualizarElementos(); // Atualiza a interface
                controladorJogo.getJogar().faseEscolha();
            }
        }
    }

}

