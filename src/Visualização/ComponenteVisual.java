package Visualização;

import javax.swing.*;
import Cartas.Carta;
import Baralhos.Mao;
import Controle.Jogador;

abstract public class ComponenteVisual extends JPanel {

    public void renderizar(){}

    public void renderizar(Carta carta){}

    public void renderizar(Mao mao){}

    public void renderizar(Jogador jogador){}

    public abstract void definirEstilo();

}