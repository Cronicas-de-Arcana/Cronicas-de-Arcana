package Baralhos;

import Cartas.Carta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck
{
    private List<Carta> cartas;

    public Deck(List<Carta> cartas)
    {
        if (cartas.size() < 30)
        {
            throw new IllegalArgumentException("O deck deve ter no mínimo 30 cartas");
        }
        this.cartas = new ArrayList<>(cartas);
    }

    public Deck()
    {
        this.cartas = new ArrayList<>();
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
        Carta carta = cartas.remove(cartas.size() - 1);
        System.out.println("Carta comprada: " + carta.getNome());
        return carta;
    }

    public int getTamanho() {
        return cartas.size();
    }

    public void adicionarCarta(Carta carta)
    {
        cartas.add(carta);
    }

    public void embaralhar()
    {
        Collections.shuffle(cartas);
    }

    public List<Carta> getCartas()
    {
        return cartas;
    }
}