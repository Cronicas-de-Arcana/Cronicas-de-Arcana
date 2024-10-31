package Espaço;

import Baralhos.Deck;
import Baralhos.Mao;
import Cartas.Carta;
import Cartas.Criatura;
import Controle.Jogador;

import java.util.ArrayList;
import java.util.List;

public class CampodeBatalha extends Espaco {
    private Mao mao;
    private Cemiterio cemiterio;
    private Deck deck;

    public CampodeBatalha(Mao mao, Cemiterio cemiterio, Deck deck)
    {
        this.cartas = new ArrayList<>();
        this.mao = mao;
        this.cemiterio = cemiterio;
        this.deck = deck;
    }

    public void adicionarCarta(Carta carta)
    {
        cartas.add(carta);
        mao.removerCarta(carta);
        System.out.println(carta.getNome() + " foi colocada no campo de batalha.");
    }

    public void removerCarta(Carta carta)
    {
        if (cartas.remove(carta))
        {
            cemiterio.adicionarCarta(carta);
            System.out.println(carta.getNome() + " foi removida do campo de batalha.");
        }
        else
        {
            System.out.println(carta.getNome() + " não está no campo de batalha.");
        }
    }

    public void comprarCarta()
    {
        if (!deck.verificarDeckVazio())
        {
            Carta cartaComprada = deck.comprarCarta();
            mao.adicionarCartas(cartaComprada);
        }
        else
        {
            System.out.println("Não existem mais cartas no deck");
        }
    }

    public List<Carta> getCampo()
    {
        return cartas;
    }

    public void mostrarCartas(){
        if (cartas.isEmpty())
        {
            System.out.println("Nenhuma carta no campo de Batalha.");
        } else
        {
            for (int i = 0; i < cartas.size(); i++)
            {
                Carta carta = cartas.get(i);
                System.out.println((i + 1) + ": " + carta.getNome() + "\n"+carta.getHabilidadeEspecial());
            }
            System.out.println();
        }
    }


    public List<Criatura> getCriaturasNoCampo(Jogador jogador)
    {
        List<Criatura> criaturasNoCampo = new ArrayList<>();
        for (Carta carta : cartas) {
            if (carta instanceof Criatura)
            {
                criaturasNoCampo.add((Criatura) carta);
            }
        }
        return criaturasNoCampo;
    }
}
