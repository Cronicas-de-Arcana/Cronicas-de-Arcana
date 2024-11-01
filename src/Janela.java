import Baralhos.ModeloMaoJogador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame {
    private JPanel painelPrincipal;     // Painel que contém todas as telas
    private CardLayout layout;          // Gerenciador de layout

    public Janela() {
        super("Crônicas de Arcana");
        layout = new CardLayout();
        painelPrincipal = new JPanel(layout);

        // Atributos da janela
        setBounds(620, 210, 900, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(68, 41, 170));

        // Adiciona as telas ao painel principal
        painelPrincipal.add(gerarPainelInicial(), "TelaInicial");
        painelPrincipal.add(gerarPainelBatalha(), "TelaBatalha");

        // Adiciona o painel principal à janela
        add(painelPrincipal);

        setVisible(true);
    }

    private JPanel gerarPainelInicial() {
        JPanel painelInicial = new JPanel(new BorderLayout());

        // Criando e desenhando título do jogo na tela principal
        Font fonteInicio = new Font("Book Antiqua", Font.PLAIN, 30);
        JLabel titulo = new JLabel("Crônicas de Arcana", JLabel.CENTER);
        titulo.setFont(fonteInicio);
        titulo.setForeground(new Color(255, 255, 255));

        // Criar botão de Iniciar
        JButton botaoIniciar = new JButton("Iniciar partida");
        botaoIniciar.setPreferredSize(new Dimension(280, 50));
        botaoIniciar.setForeground(new Color(255, 255, 255));
        botaoIniciar.setBackground(Color.BLACK);
        botaoIniciar.setFont(fonteInicio);
        botaoIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muda para a Visualização.Tela de Batalha quando o botão "Iniciar" é clicado
                layout.show(painelPrincipal, "TelaBatalha");
            }
        });

        // Painel superior para o título
        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centraliza o título
        tituloPanel.setBackground(new Color(68, 41, 170)); // Cor do fundo do painel
        tituloPanel.add(titulo);

        // Painel central para o botão
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80)); // Centraliza o botão
        botaoPanel.setBackground(new Color(68, 41, 170)); // Cor do fundo do painel
        botaoPanel.add(botaoIniciar);

        // Adicionando os painéis à tela
        painelInicial.add(tituloPanel, BorderLayout.NORTH);
        painelInicial.add(botaoPanel, BorderLayout.CENTER);

        return painelInicial;
    }

    private JPanel gerarPainelBatalha() {
        JPanel painelBatalha = new JPanel(new BorderLayout()); // Usando BorderLayout para melhor organização

        // Criando botões para cada região
        JPanel Norte = new JPanel();
        JPanel Sul = new JPanel();
        JButton Leste = new JButton("Contador de Rodada e Timer");
        JButton Oeste = new JButton("Cemitério");
        JButton Centro = new JButton("Area de batalha");

        // Configurando tamanhos para que os botões ocupem a área total
        Norte.setPreferredSize(new Dimension(0, 190));  // Ocupar toda a largura, altura ajustada
        Norte.setBackground(new Color(55, 118, 255));
        Sul.setPreferredSize(new Dimension(0, 190));    // Ocupar toda a largura, altura ajustada
        Sul.setBackground(new Color(251, 75, 75));
        Leste.setPreferredSize(new Dimension(210, 0));  // Ocupar toda a altura, largura ajustada
        Oeste.setPreferredSize(new Dimension(210, 0));  // Ocupar toda a altura, largura ajustada

        ModeloMaoJogador modelo1 = new ModeloMaoJogador();
        ModeloMaoJogador modelo2 = new ModeloMaoJogador();
        Norte.add(modelo1);
        Sul.add(modelo2);

        // Adicionando botões a cada região do BorderLayout
        painelBatalha.add(Norte, BorderLayout.NORTH);
        painelBatalha.add(Sul, BorderLayout.SOUTH);
        painelBatalha.add(Leste, BorderLayout.EAST);
        painelBatalha.add(Oeste, BorderLayout.WEST);
        painelBatalha.add(Centro, BorderLayout.CENTER);

        return painelBatalha;
    }

    //Main pra teste e visualização
    public static void main(String[] args) {
        new Janela();
    }
}
