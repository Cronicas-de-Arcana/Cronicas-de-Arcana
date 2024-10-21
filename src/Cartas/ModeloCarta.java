package Cartas;

import javax.swing.*;
import java.awt.*;

public class ModeloCarta extends JPanel {
    private int largura, altura;

    public ModeloCarta(int largura, int altura, Criatura cartaModelo) {
        this.largura = largura;
        this.altura = altura;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(largura, altura));

        JLabel nome = new JLabel(cartaModelo.getNome());
        nome.setMaximumSize(new Dimension(this.largura, this.altura/5));
        nome.setBorder(BorderFactory.createLineBorder(Color.black));
        nome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel tipo = new JLabel("Terrestre");
        tipo.setMaximumSize(new Dimension(this.largura, this.altura/5));
        tipo.setBorder(BorderFactory.createLineBorder(Color.black));
        tipo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel custoMana = new JLabel(String.valueOf(cartaModelo.getCustoMana()));
        custoMana.setMaximumSize(new Dimension(this.largura, this.altura/5));
        custoMana.setBorder(BorderFactory.createLineBorder(Color.black));
        custoMana.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descricao = new JLabel(cartaModelo.getHabilidadeEspecial());
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

    //Metodo que gera o modelo da carta
    public static ModeloCarta gerarCartaCriatura(Criatura criatura) {
        int largura = 150, altura = 190;

        return new ModeloCarta(largura, altura, criatura);
    }

    //Main pra teste e vizualização
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cartas Controle.Jogador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(240, 420);

        Criatura goblin = new Criatura(120, "Goblin", 2, 90, 45, 9, "Ataques sucessivos",false);
        JPanel painelAmostra = new JPanel();

        painelAmostra.add(ModeloCarta.gerarCartaCriatura(goblin));
        frame.getContentPane().add(BorderLayout.CENTER, painelAmostra);

        frame.setVisible(true);
    }
}
