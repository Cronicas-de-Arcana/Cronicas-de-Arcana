package Baralhos;

import Cartas.Carta;
import Controle.Jogador;

import java.util.ArrayList;
import java.util.List;

public class Mao
{
    private List<Carta> cartas;

    public Mao()
    {
        this.cartas = new ArrayList<>();
    }

    public boolean temCartasSuficientes(int quantidade)
    {
        return cartas.size() >= quantidade;
    }

    public void adicionarCartas(Carta carta)
    {
        if (carta != null)
        {
            cartas.add(carta);
        }
        else
        {
            System.out.println("Esta carta é nula e não pode ser adicionada.");
        }
    }

    public void removerCarta(Carta carta)
    {
        if (cartas.remove(carta))
        {
            System.out.println(carta.getNome() + " foi removida da mão.");
        }
        else
        {
            System.out.println("A carta " + carta.getNome() + " não está na mão.");
        }
    }

    public boolean temCarta(Carta carta)
    {
        return cartas.contains(carta);
    }

    public List<Carta> getCartas()
    {
        return cartas;
    }

    public void mostrarCartas()
    {
        if (cartas.isEmpty())
        {
            System.out.println("Nenhuma carta na mão.");
        } else
        {
            for (int i = 0; i < cartas.size(); i++)
            {
                Carta carta = cartas.get(i);
                System.out.println((i + 1) + ": " + carta.getNome() + " - Custo de Mana: " + carta.getCustoMana());
            }
            System.out.println();
        }
    }
}