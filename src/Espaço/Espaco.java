package Espaço;

import Cartas.Carta;

import java.util.List;

abstract public class Espaco {
    protected List<Carta> cartas;

    abstract void removerCarta(Carta carta);

    abstract void mostrarCartas();

    abstract void adicionarCarta(Carta carta);
}
