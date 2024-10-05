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

        Criatura arqueiro = new Criatura(25,"Arqueiro",3, 20,1.2,15,"Ataques que atacam tropas voadoras.");
        Criatura goblin = new Criatura(35,"Goblin",3, 10,2.5,25,"Ataques rápidos");


        this.add(ModeloCarta.gerarCartaCriatura(arqueiro));
        this.add(espacamento);
        this.add(ModeloCarta.gerarCartaCriatura(goblin));
    }
}
