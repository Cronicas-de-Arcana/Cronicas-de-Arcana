package Espaço;

import Baralhos.Deck;
import Baralhos.Mao;
import Cartas.Carta;
import Cartas.Criatura;
import Controle.Jogador;

import java.util.ArrayList;
import java.util.List;

public class CampodeBatalha extends Espaco
{
    private Mao mao;
    private Cemiterio cemiterio;
    private Deck deck;

    public CampodeBatalha(){
        this.cartas = new ArrayList<>();
    }

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
    }

    public List<Carta> getCampo()
    {
        return cartas;
    }


    public void removerCarta(Carta criatura)
    {
        if (cartas.remove(criatura)) {
            System.out.println(criatura.getNome() + " foi removida do campo de batalha e enviada ao cemitério.");
        } else {
            System.out.println(criatura.getNome() + " não está no campo de batalha.");
        }
    }

    public void mostrarCartas()
    {
        if (cartas.isEmpty())
        {
            System.out.println("Nenhuma carta no campo de Batalha.");
        }
        else
        {
            for (int i = 0; i < cartas.size(); i++)
            {
                Carta carta = cartas.get(i);
                System.out.println((i + 1) + ": " + carta.getNome() + " - Custo de Mana: " + carta.getCustoMana() + " - Habilidade: "+carta.getHabilidadeEspecial());
            }
            System.out.println();
        }
    }
}
