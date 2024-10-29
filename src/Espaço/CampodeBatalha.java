package Espaço;

import Baralhos.Deck;
import Baralhos.Mao;
import Cartas.Carta;
import Cartas.Criatura;
import Controle.Jogador;

import java.util.ArrayList;
import java.util.List;

public class CampodeBatalha {
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
        return campoDeBatalha;
    }

    public void mostrarCartasCampo(){
        if (campoDeBatalha.isEmpty())
        {
            System.out.println("Nenhuma carta no campo de Batalha.");
        } else
        {
            for (int i = 0; i < campoDeBatalha.size(); i++)
            {
                Carta carta = campoDeBatalha.get(i);
                System.out.println((i + 1) + ": " + carta.getNome() + "\n"+carta.getHabilidadeEspecial());
            }
            System.out.println();
        }
    }


    public List<Criatura> getCriaturasNoCampo(Jogador jogador)
    {
        List<Criatura> criaturasNoCampo = new ArrayList<>();
        for (Carta carta : campoDeBatalha) {
            if (carta instanceof Criatura)
            {
                criaturasNoCampo.add((Criatura) carta);
            }
        }
        return criaturasNoCampo;
    }
}
