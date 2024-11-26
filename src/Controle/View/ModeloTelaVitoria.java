package Controle.View;

import Cartas.Carta;
import Cartas.View.ModeloCarta;
import Controle.ControladorJogo;
import Controle.Jogador;
import Visualização.Tela;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        this.cartasGanhas = new ArrayList<Carta>(); // Inicializa a lista de modelos
        this.modelosCartasGanhas = new ArrayList<ModeloCarta>();
        cartasGanhas = controladorJogo.getInventario().sorteioRecompensa();

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
        this.setBackground(new Color(30, 30, 30)); // Fundo escuro para maior contraste
    }

    @Override
    public void renderizar() {
        removeAll();

        // Painel Superior
        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new BoxLayout(painelSuperior, BoxLayout.Y_AXIS));
        painelSuperior.setBackground(new Color(45, 45, 45));
        painelSuperior.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Parabéns, " + jogadorGanhador.getNome() + "!");
        titulo.setForeground(new Color(255, 215, 0)); // Cor dourada para destaque
        titulo.setFont(new Font("Serif", Font.BOLD, 36));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Você é o vencedor!");
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setFont(new Font("Serif", Font.ITALIC, 20));
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel experiencia = new JLabel("Experiência Ganha: " + jogadorGanhador.getExperiencia());
        experiencia.setForeground(Color.WHITE);
        experiencia.setFont(new Font("Serif", Font.PLAIN, 18));
        experiencia.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelSuperior.add(titulo);
        painelSuperior.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço vertical
        painelSuperior.add(subtitulo);
        painelSuperior.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço vertical
        painelSuperior.add(experiencia);

        // Painel Central - Placeholder para Cartas Ganhas
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        painelCentral.setBackground(new Color(30, 30, 30));
        painelCentral.setBorder(new EmptyBorder(20, 20, 20, 20));

        if (cartasGanhas != null && !cartasGanhas.isEmpty()) {
            for (Carta carta : cartasGanhas) {
                ModeloCarta modelo = new ModeloCarta(carta, jogadorGanhador, controladorJogo, "Carta Ganha!");
                modelosCartasGanhas.add(modelo);

                modelo.getBotao().addActionListener(e -> {
                    JOptionPane.showMessageDialog(null, "Você ganhou a carta: " + carta.getNome());
                });

                painelCentral.add(modelo);
            }
        } else {
            JLabel mensagem = new JLabel("Nenhuma carta foi ganha nesta partida.");
            mensagem.setForeground(Color.LIGHT_GRAY);
            mensagem.setFont(new Font("Serif", Font.ITALIC, 16));
            painelCentral.add(mensagem);
        }

        // Painel Inferior - Botão de Continuar
        JPanel painelInferior = new JPanel();
        painelInferior.setBackground(new Color(45, 45, 45));
        painelInferior.setBorder(new EmptyBorder(10, 10, 10, 10));
        painelInferior.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton botaoContinuar = new JButton("Continuar");
        botaoContinuar.setPreferredSize(new Dimension(150, 40));
        botaoContinuar.setFont(new Font("SansSerif", Font.BOLD, 18));
        botaoContinuar.setForeground(Color.WHITE);
        botaoContinuar.setBackground(new Color(70, 130, 180));
        botaoContinuar.setFocusPainted(false);
        botaoContinuar.addActionListener(e -> {
            // Lógica para continuar o jogo ou ir para o menu principal
            controladorJogo.getJanela().setTelaAtual(new TelaInicial(controladorJogo));
        });

        painelInferior.add(botaoContinuar);

        // Adiciona os painéis à tela
        this.add(painelSuperior, BorderLayout.NORTH);
        this.add(painelCentral, BorderLayout.CENTER);
        this.add(painelInferior, BorderLayout.SOUTH);

        this.revalidate();
        this.repaint();
    }
}
