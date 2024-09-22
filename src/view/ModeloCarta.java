package view;

import javax.swing.*;
import java.awt.*;

public class ModeloCarta extends JPanel {
    private int largura, altura;

    public ModeloCarta(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(largura, altura));

        JLabel nome = new JLabel("Nome");
        nome.setMaximumSize(new Dimension(this.largura, this.altura/5));
        nome.setBorder(BorderFactory.createLineBorder(Color.black));
        nome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel tipo = new JLabel("Terrestre");
        tipo.setMaximumSize(new Dimension(this.largura, this.altura/5));
        tipo.setBorder(BorderFactory.createLineBorder(Color.black));
        tipo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel custoMana = new JLabel("Custo Mana");
        custoMana.setMaximumSize(new Dimension(this.largura, this.altura/5));
        custoMana.setBorder(BorderFactory.createLineBorder(Color.black));
        custoMana.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descricao = new JLabel("Descricao da habilidade");
        descricao.setMaximumSize(new Dimension(this.largura, this.altura/5));
        descricao.setBorder(BorderFactory.createLineBorder(Color.black));
        descricao.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton habilidade = new JButton("Atacar");
        habilidade.setMaximumSize(new Dimension(this.largura, this.altura/5));
        habilidade.setBorder(BorderFactory.createLineBorder(Color.black));
        habilidade.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(nome);
        add(tipo);
        add(custoMana);
        add(descricao);
        add(habilidade);
    }

    //Main pra teste e vizualização
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cartas Jogador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(240, 420);

        JPanel painelAmostra = new JPanel();
        ModeloCarta exemplo = new ModeloCarta(150, 180);

        painelAmostra.add(exemplo);
        frame.getContentPane().add(BorderLayout.CENTER, painelAmostra);

        frame.setVisible(true);
    }
}
