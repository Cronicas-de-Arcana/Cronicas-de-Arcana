package Controle;

import Baralhos.Deck;
import Baralhos.Mao;
import Cartas.Carta;
import Cartas.Inventario;
import Espaço.CampodeBatalha;
import Espaço.Cemiterio;

import java.util.Scanner;

public class Jogador
{
    private String nome;
    private int hp;
    private int mana;
    private int manaAtual;
    protected int nivel;
    protected double experiencia;
    protected Deck deck;
    protected Mao mao;
    protected Cemiterio cemiterio;
    private CampodeBatalha campoDeBatalha;
    private Inventario inventario;

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
        this.nivel = 1;
        this.experiencia = 0;
        this.inventario = new Inventario();
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

    public double getExperiencia() {
        return experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void comprarCartas()
    {
        if (deck.verificarDeckVazio())
        {
            System.out.println("Não existem mais cartas no deck para " + nome + "!");
            return;
        }
        Carta cartaComprada = deck.comprarCarta();
        if (cartaComprada != null)
        {
            mao.adicionarCartas(cartaComprada);
        }
        else
        {
            System.out.println("Não foi possível comprar a carta "+ cartaComprada.getNome() + ".");
        }
    }

    public Carta escolherCarta(){

        //Cartas da mão são mostradas
        System.out.println("Cartas na mão de "+ this.getNome()+"\n");
        this.getMao().mostrarCartas();
        System.out.println("Quantidade de mana: "+this.getManaAtual());

        //Jogador escolhe indice da carta
        Scanner sc = new Scanner(System.in);
        System.out.println(this.getNome()+ "Escolha uma carta: ");
        int cartaEscolhida = sc.nextInt()-1;

        //Retorno de carta escolhida
        return this.getMao().getCartas().get(cartaEscolhida);
    }

    public Carta escolherCartaCampo(Jogador jogador){

        //Cartas do campo são mostradas
        System.out.println("Cartas no campo de "+ jogador.getNome()+"\n");
        jogador.getCampoDeBatalha().mostrarCartas();

        //Jogador escolhe indice da carta
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma carta: ");
        int cartaEscolhida = sc.nextInt()-1;

        return jogador.getCampoDeBatalha().getCampo().get(cartaEscolhida);
    }

    public void jogarCartaNoCampo(Carta carta)
    {
        if (mao.temCarta(carta))
        {
            this.campoDeBatalha.adicionarCarta(carta);
            this.mao.removerCarta(carta);
            System.out.println(carta.getNome()+" lançada no campo de batalha!");
            this.manaAtual -= carta.getCustoMana();
        }
        else
        {
            System.out.println("A carta " + carta.getNome() + " não está na mão.");
        }
    }

    public void enviarAoCemiterio(Carta carta)
    {
        cemiterio.adicionarCarta(carta);
        System.out.println(carta.getNome() + " foi enviada ao cemitério.");
    }

    public CampodeBatalha getCampoDeBatalha(){
        return this.campoDeBatalha;
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
        System.out.println("Nível de mana: " + this.manaAtual+"\n");
    }

    public void utilizarMana(int custoMana)
    {
        this.manaAtual -= custoMana;
    }

    public void defender(Carta atacante)
    {
        System.out.println(getNome() + " defende com " + atacante.getNome());
    }

    public void atualizarNivel()
    {
        //10 níveis, começando do 1
        int[] experienciaPorNivel= {0, 200, 600, 1200, 1900, 2700, 3500, 4300, 5000, 6000};

        for (int i = 0; i < experienciaPorNivel.length; i++)
        {
            if (this.getExperiencia() >= experienciaPorNivel[i])
            {
                this.setNivel(i + 1);
                break;
            }
        }
    }

    public void adicionarCartasProgresso(){
        int nivelAtual = this.getNivel();
        Carta[] cartasParaAdicionar = inventario.getCartasProgresso()[nivelAtual-1];

        for (Carta carta: cartasParaAdicionar){
            this.inventario.getCartasInventario().add(carta);
        }
    }
}