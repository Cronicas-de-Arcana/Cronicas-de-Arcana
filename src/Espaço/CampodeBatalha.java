package Espaço;

import Baralhos.Deck;
import Baralhos.Mao;
import Cartas.Carta;

import java.util.ArrayList;
import java.util.List;

public class CampodeBatalha
{
    private List<Carta> campoDeBatalha;
    private Mao mao;
    private Cemiterio cemiterio;
    private Deck deck;

    public CampodeBatalha(Mao mao, Cemiterio cemiterio, Deck deck)
    {
        this.campoDeBatalha = new ArrayList<>();
        this.mao = mao;
        this.cemiterio = cemiterio;
        this.deck = deck;
    }

    public void adicionarCartasAoCampo(Carta carta)
    {
        campoDeBatalha.add(carta);
        mao.removerCarta(carta);
        System.out.println(carta.getNome() + " foi colocada no campo de batalha.");
    }

    public void removerCartaDoCampo(Carta carta)
    {
        if (campoDeBatalha.remove(carta))
        {
            cemiterio.adicionarCartasNoCemiterio(carta);
            System.out.println(carta.getNome() + " foi removida do campo de batalha.");
        }
        else
        {
            System.out.println(carta.getNome() + " não está no campo de batalha.");
        }
    }

    public void comprarCarta()
    {
        Carta cartaComprada = deck.comprarCarta();
        if (cartaComprada != null)
        {
            mao.adicionarCartas(cartaComprada);
            System.out.println("Cartas.Carta comprada do deck: " + cartaComprada.getNome());
        }
    }

    public List<Carta> getCampo()
    {
        return campoDeBatalha;
    }
}
