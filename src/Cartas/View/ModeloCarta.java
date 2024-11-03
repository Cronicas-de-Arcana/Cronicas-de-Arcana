package Cartas.View;

import Cartas.Carta;
import Cartas.Criatura;
import Cartas.Encantamento;
import Cartas.Feitico;
import Visualização.ComponenteVisual;

import javax.swing.*;
import java.awt.*;

public class ModeloCarta extends ComponenteVisual {

    public ModeloCarta(Carta carta) {
        this.definirEstilo();
        this.renderizar(carta);
    }

    @Override
    public void definirEstilo() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(30, 30, 30));
        this.setBorder(BorderFactory.createLineBorder(Color.white));
        setPreferredSize(new Dimension(160, 140));
        setMaximumSize(new Dimension(180, 140));
    }

    @Override
    public void renderizar(Carta carta) {
        Font fontePadrao = new Font("Arial", Font.BOLD, 12);

        // Estilo campo do nome
        JLabel nomeCarta = new JLabel(carta.getNome());
        nomeCarta.setFont(fontePadrao);
        nomeCarta.setForeground(Color.WHITE);
        nomeCarta.setAlignmentX(CENTER_ALIGNMENT);  // Centralização

        // Estilo campo do custo da mana
        JLabel custoMana = new JLabel("Custo de mana: " + carta.getCustoMana());
        custoMana.setFont(fontePadrao);
        custoMana.setForeground(Color.WHITE);
        custoMana.setAlignmentX(CENTER_ALIGNMENT);  // Centralização

        this.add(nomeCarta);
        this.add(custoMana);

        // Espaçamento entre campos
        this.add(Box.createVerticalStrut(10));

        // Configurações específicas de cada tipo de carta
        switch (carta) {
            case Criatura criatura -> {
                JLabel hpLabel = new JLabel("HP: " + criatura.getHP());
                JLabel poderLabel = new JLabel("Poder: " + criatura.getPoder());
                JLabel resistenciaLabel = new JLabel("Resistência: " + criatura.getResistencia());

                // Aplicando o estilo de centralização e fonte para cada atributo
                hpLabel.setFont(fontePadrao);
                hpLabel.setForeground(Color.WHITE);
                hpLabel.setAlignmentX(CENTER_ALIGNMENT);

                poderLabel.setFont(fontePadrao);
                poderLabel.setForeground(Color.WHITE);
                poderLabel.setAlignmentX(CENTER_ALIGNMENT);

                resistenciaLabel.setFont(fontePadrao);
                resistenciaLabel.setForeground(Color.WHITE);
                resistenciaLabel.setAlignmentX(CENTER_ALIGNMENT);

                this.add(hpLabel);
                this.add(poderLabel);
                this.add(resistenciaLabel);
            }
            case Feitico feitico -> {
                JLabel danoLabel = new JLabel("Dano: " + feitico.getDano());
                JLabel curaLabel = new JLabel("Cura: " + feitico.getCura());
                JLabel modificadorDanoLabel = new JLabel("Modificador de Dano: " + feitico.getModificadorDano());

                // Aplicando o estilo de centralização e fonte para cada atributo
                danoLabel.setFont(fontePadrao);
                danoLabel.setForeground(Color.WHITE);
                danoLabel.setAlignmentX(CENTER_ALIGNMENT);

                curaLabel.setFont(fontePadrao);
                curaLabel.setForeground(Color.WHITE);
                curaLabel.setAlignmentX(CENTER_ALIGNMENT);

                modificadorDanoLabel.setFont(fontePadrao);
                modificadorDanoLabel.setForeground(Color.WHITE);
                modificadorDanoLabel.setAlignmentX(CENTER_ALIGNMENT);

                this.add(danoLabel);
                this.add(curaLabel);
                this.add(modificadorDanoLabel);
            }
            case Encantamento encantamento -> {
                JLabel quantidadeRodadasLabel = new JLabel("Duração: " + encantamento.getQuantidadeRodadas() + " rodadas");
                JLabel modificadorDanoLabel = new JLabel("Modificador de Dano: " + encantamento.getModificadorDano());

                // Aplicando o estilo de centralização e fonte para cada atributo
                quantidadeRodadasLabel.setFont(fontePadrao);
                quantidadeRodadasLabel.setForeground(Color.WHITE);
                quantidadeRodadasLabel.setAlignmentX(CENTER_ALIGNMENT);

                modificadorDanoLabel.setFont(fontePadrao);
                modificadorDanoLabel.setForeground(Color.WHITE);
                modificadorDanoLabel.setAlignmentX(CENTER_ALIGNMENT);

                this.add(quantidadeRodadasLabel);
                this.add(modificadorDanoLabel);
            }
            default -> {
            }
        }

        JButton botaoAtaque = new JButton("Ataque (provisório)");
        botaoAtaque.setAlignmentX(CENTER_ALIGNMENT);
        this.add(botaoAtaque);

        // Adicionando espaço entre os elementos para melhor visualização
        this.add(Box.createVerticalGlue());
    }
}
