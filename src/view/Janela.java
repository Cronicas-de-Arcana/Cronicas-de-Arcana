package view;
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
        painelPrincipal.add(gerarTelaPrincipal(), "TelaPrincipal");

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
        JButton botaoIniciar = new JButton("Iniciar");
        botaoIniciar.setPreferredSize(new Dimension(200, 50));
        botaoIniciar.setForeground(new Color(255, 255, 255));
        botaoIniciar.setBackground(Color.BLACK);
        botaoIniciar.setFont(fonteInicio);
        botaoIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muda para a Tela Principal quando o botão "Iniciar" é clicado
                layout.show(painelPrincipal, "TelaPrincipal");
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

    private JPanel gerarTelaPrincipal() {
        JPanel painelPrincipal = new JPanel(new BorderLayout()); // Usando BorderLayout para melhor organização
        painelPrincipal.setBackground(new Color(255, 255, 255)); // Cor de fundo da tela principal

        // Texto na tela principal
        JLabel label = new JLabel("Bem-vindo à Tela Principal", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 24));
        painelPrincipal.add(label, BorderLayout.NORTH); // Coloca o texto na parte superior

        // Criar botão "Voltar"
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(200, 50));
        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Volta para a Tela Inicial
                layout.show(Janela.this.painelPrincipal, "TelaInicial");
            }
        });

        // Painel para centralizar o botão "Voltar"
        JPanel botaoPanel = new JPanel();
        botaoPanel.add(botaoVoltar);
        painelPrincipal.add(botaoPanel, BorderLayout.CENTER); // Coloca o botão no centro

        return painelPrincipal;
    }
}