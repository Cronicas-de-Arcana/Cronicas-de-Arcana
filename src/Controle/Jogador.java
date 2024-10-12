package Controle;

import Baralhos.Deck;
import Baralhos.Mao;
import Cartas.Carta;
import Espaço.CampodeBatalha;
import Espaço.Cemiterio;

import java.util.ArrayList;

public class Jogador
{
    private String nome;
    private int hp;
    protected Deck deck;
    protected Mao mao;
    protected Cemiterio cemiterio;
    private CampodeBatalha campoDeBatalha;
    private int mana;
    private int manaAtual;
    protected Nivel nivel;
    private ArrayList<Carta> inventario;

    public Jogador(String nome, Deck deck, int hp, int mana, int manaAtual)
    {
        this.nome = nome;
        this.deck = deck;
        this.mao = new Mao();
        this.cemiterio = new Cemiterio();
        this.campoDeBatalha = new CampodeBatalha(mao, cemiterio, deck);
        this.hp = hp;
        this.mana = mana;
        this.manaAtual = manaAtual;
        this.nivel = new Nivel();

        System.out.println("Comprando cartas iniciais...");
        for (int i = 0; i < 5; i++)
        {
            Carta cartaComprada = deck.comprarCarta();
            mao.adicionarCartas(cartaComprada);
        }
    }

    public void jogarCartaNoCampo(Carta carta)
    {
        if (mao.temCarta(carta))
        {
            campoDeBatalha.adicionarCartasAoCampo(carta);
        }
        else
        {
            System.out.println("A carta " + carta.getNome() + " não está na mão.");
        }
    }


    public void comprarCartas()
    {
        Carta cartaComprada = deck.comprarCarta();
        if (deck.verificarDeckVazio())
        {
            System.out.println("Não existem mais cartas no deck para " + nome + "!");
            return;
        }
        if (cartaComprada != null)
        {
            mao.adicionarCartas(cartaComprada);
            System.out.println(nome + " comprou a carta: " + cartaComprada.getNome());
        }
        else
        {
            System.out.println("Não foi possível comprar uma carta.");
        }
    }

    public void jogarCarta(Carta carta)
    {
        if (mao.temCarta(carta))
        {
            campoDeBatalha.adicionarCartasAoCampo(carta);
            mao.removerCarta(carta);
            System.out.println(nome + " jogou a carta: " + carta.getNome());
        }
        else
        {
            System.out.println("A carta " + carta.getNome() + " não está na mão de " + nome + ".");
        }
    }

    public void enviarAoCemiterio(Carta carta)
    {
        cemiterio.adicionarCartasNoCemiterio(carta);
        System.out.println(carta.getNome() + " foi enviada ao cemitério.");
    }

    public String getNome()
    {
        return nome;
    }

    public int getHp()
    {
        return hp;
    }

    public Deck getDeck()
    {
        return deck;
    }

    public Mao getMao()
    {
        return mao;
    }

    public Cemiterio getCemiterio()
    {
        return cemiterio;
    }

    public int getMana()
    {
        return mana;
    }

    public int getManaAtual()
    {
        return manaAtual;
    }

    public void subirNivel()
    {
        nivel.ganharNivel();
    }

    public int getNivel()
    {
        return nivel.getNivelAtual();
    }

    public void mostrarNivel()
    {
        nivel.mostrarNivel();
    }

    public void receberDano(int dano)
    {
        this.hp -= dano;
        if (this.hp <= 0)
        {
            System.out.println(getNome() + " foi derrotado!");
        }
        else
        {
            System.out.println(getNome() + " recebeu " + dano + " de dano. HP restante: " + this.hp);
        }
    }

    public void receberCura(int cura)
    {
        this.hp += cura;
        System.out.println(nome + " foi curado em " + cura + " pontos de vida. Vida atual: " + this.hp);
    }

    public void adicionarMana()
    {
        this.manaAtual++;
    }

    public void utilizarMana(int custoMana)
    {
        this.manaAtual -= custoMana;
    }

    public void defender(Carta atacante)
    {
        System.out.println(getNome() + " defende com " + atacante.getNome());
    }
}