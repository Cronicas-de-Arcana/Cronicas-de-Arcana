package Visualização;

import javax.swing.*;
import Cartas.Carta;
import Baralhos.Mao;

abstract public class ComponenteVisual extends JPanel {

    public void renderizar(){}

    public void renderizar(Carta carta){}

    public void renderizar(Mao mao){}

    public abstract void definirEstilo();

}