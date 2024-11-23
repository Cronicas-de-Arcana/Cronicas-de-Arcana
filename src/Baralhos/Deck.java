package Baralhos;

import Cartas.Carta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck
{
    protected List<Carta> cartas;

    public List<Carta> getCartas()
    {
        return cartas;
    }

    public int getTamanho()
    {
        return cartas.size();
    }

    public boolean verificarDeckVazio()
    {
        return cartas.isEmpty();
    }

    public Carta comprarCarta()
    {
        if (verificarDeckVazio())
        {
            System.out.println("O deck está vazio");
            return null;
        }
        else
        {
            Carta carta = cartas.remove(cartas.size() - 1);
            System.out.println(carta.getNome());
            return carta;
        }
    }

    public void embaralhar()
    {
        Collections.shuffle(cartas);
    }

    public Deck(ArrayList<Carta> cartas)
    {
        this.cartas = cartas;
    }

    public void adicionarCarta(Carta carta)
    {
        cartas.add(carta);
    }

}