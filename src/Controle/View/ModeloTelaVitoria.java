package Controle.View;

import Cartas.Carta;
import Cartas.View.ModeloCarta;
import Controle.ControladorJogo;
import Controle.Jogador;
import Visualização.ComponenteVisual;
import Visualização.Tela;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModeloTelaVitoria extends Tela {
    private Jogador jogadorGanhador;
    private ArrayList<Carta> cartasGanhas;
    private ArrayList<ModeloCarta> modelosCartasGanhas;
    private ControladorJogo controladorJogo;

    public ModeloTelaVitoria(Jogador jogadorGanhador, ControladorJogo controladorJogo) {
        this.jogadorGanhador = jogadorGanhador;
        this.controladorJogo = controladorJogo;
        this.cartasGanhas = jogadorGanhador.adicionarCartasProgresso();
        definirEstilo();
        renderizar();
    }

    public ControladorJogo getControladorJogo() {
        return controladorJogo;
    }

    public void setControladorJogo(ControladorJogo controladorJogo) {
        this.controladorJogo = controladorJogo;
    }

    public void definirEstilo() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);
    }

    @Override
    public void renderizar() {
        removeAll();

        JPanel painelSuperior = new JPanel();
        JLabel titulo = new JLabel(jogadorGanhador.getNome() + "Você ganhou!\n\nAqui estão suas recompensas:");
        titulo.setBackground(Color.WHITE);
        titulo.setFont(new Font("Verdana", Font.BOLD, 20));
        JLabel titulo2 = new JLabel(String.valueOf(jogadorGanhador.getExperiencia()));
        titulo2.setBackground(Color.WHITE);
        titulo2.setFont(new Font("Verdana", Font.BOLD, 20));
        painelSuperior.add(titulo);
        painelSuperior.add(titulo2);

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new FlowLayout());
        painelCentral.setBackground(Color.WHITE);

        for (Carta carta : cartasGanhas) {
            ModeloCarta modelo = new ModeloCarta(carta, jogadorGanhador, controladorJogo, "Carta Ganha!");
            modelosCartasGanhas.add(modelo);

            // Adiciona ações específicas para os botões de cada carta, se necessário
            modelo.getBotao().addActionListener(e -> {
                // Adicione aqui a lógica para o que acontece ao clicar no botão "Jogar Carta"
                JOptionPane.showMessageDialog(null, "Você ganhou a carta: " + carta.getNome());
            });

            painelCentral.add(modelo); // Adiciona o componente visual ao layout
        }

        this.add(painelSuperior, BorderLayout.NORTH);
        this.add(painelCentral, BorderLayout.CENTER);

        this.revalidate();
        this.repaint();
    }
}
