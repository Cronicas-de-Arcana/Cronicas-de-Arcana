package Baralhos;

import Cartas.Criatura;
import Cartas.ModeloCarta;

import javax.swing.*;
import java.awt.*;

public class ModeloMaoJogador extends JPanel {

    public ModeloMaoJogador() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(new Color(0, 0, 0, 0));
        JPanel espacamento = new JPanel();
        espacamento.setBackground(new Color(0, 0, 0, 0));

        Criatura arqueiro = new Criatura (95, "Arqueiro", 2, 200, 120, 8, "Ataques a longa distância com dano e penetração altos.",false);
        Criatura goblin = new Criatura(120, "Goblin", 2, 90, 45, 9, "Ataques sucessivos",false);

        this.add(ModeloCarta.gerarCartaCriatura(arqueiro));
        this.add(espacamento);
        this.add(ModeloCarta.gerarCartaCriatura(goblin));
    }
}
