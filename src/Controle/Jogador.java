package Controle;

import Baralhos.Deck;
import Baralhos.Mao;
import Cartas.Carta;
import Cartas.Criatura;
import Cartas.Encantamento;
import Cartas.Inventario;
import Espaço.CampodeBatalha;
import Espaço.Cemiterio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
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
    private Scanner scanner;
    protected List<Encantamento> encantamentosAtivos = new ArrayList<>();
    private ControladorJogo controladorJogo;

    public Jogador(String nome){
        this.nome = nome;
        this.mao = new Mao();
        this.cemiterio = new Cemiterio();
        this.campoDeBatalha = new CampodeBatalha();
        this.hp = 50;
        this.manaAtual = 10;
        this.nivel = 1;
        this.experiencia = 0;
        this.scanner = new Scanner(System.in);
    }

    public Jogador(String nome, Deck deck, int hp, int mana, int manaAtual, Scanner scanner)
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
        this.scanner = scanner;
    }

    public ControladorJogo getControladorJogo() {
        return controladorJogo;
    }

    public void setControladorJogo(ControladorJogo controladorJogo) {
        this.controladorJogo = controladorJogo;
    }

    public void setDeck(Deck deck){
        this.deck = deck;
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

    public Inventario getInventario() {
        return inventario;
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
            this.mao.adicionarCartas(cartaComprada);
            this.getDeck().getCartas().remove(cartaComprada);
            this.controladorJogo.getJanela().getTelaBatalha().atualizarMaos();
        }
        else
        {
            System.out.println("Não foi possível comprar a carta "+ nome + ".");
        }
    }

    public Carta escolherCartaMao(Jogador jogador)
    {
        mao.mostrarCartas();

        if (mao.getCartas().isEmpty())
        {
            System.out.println("Nenhuma carta na mão.");
            return null;
        }

        while (true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Escolha uma carta da mão para atacar (digite o número) ou 0 para não escolher: ");
            int cartaEscolhida = sc.nextInt();

            if (cartaEscolhida < 0 || cartaEscolhida >= mao.getCartas().size())
            {
                System.out.println("Escolha inválida. Tente novamente.");
            }
            else if (cartaEscolhida == 0)
            {
                break;
            }
            else
            {
                return mao.getCartas().get(cartaEscolhida);
            }
        }
        return null;
    }

    public Carta escolherCartaCampo(Jogador jogador)
    {
        if (jogador.getCampoDeBatalha().getCampo().isEmpty())
        {
            return null;
        }

        while(true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Escolha uma carta do campo para atacar (digite o número) ou 0 para não escolher: ");
            int cartaEscolhida = sc.nextInt() - 1;

            if (cartaEscolhida < 0 || cartaEscolhida >= jogador.getCampoDeBatalha().getCampo().size())
            {
                System.out.println("Escolha inválida. Tente novamente.");
            }
            else if (cartaEscolhida == 0)
            {
                break;
            }
            else
            {
                return jogador.getCampoDeBatalha().getCampo().get(cartaEscolhida);
            }
        }
        return null;
    }

    public void jogarCartasNoCampo()
    {
        System.out.println(this.getNome() + ", suas cartas na mão:");

        while (true)
        {
            int i = 0;
            for (Carta carta : this.mao.getCartas())
            {
                System.out.println("Carta " + (i + 1) + ": " + carta.getNome() + " - Custo de Mana: " + carta.getCustoMana() + " - Habilidade: " + carta.getHabilidadeEspecial());
                i++;
            }

            System.out.println("\n" + this.nome + " escolha uma carta para jogar (digite o número da carta) ou 0 para não jogar:");
            int escolha = this.scanner.nextInt();

            if (escolha == 0)
            {
                System.out.println("Nenhuma carta foi jogada. Encerrando a fase de invocação.\n");
                break;
            }

            if (escolha > 0 && escolha <= this.mao.getCartas().size())
            {
                Carta cartaEscolhida = this.mao.getCartas().get(escolha - 1);

                if (cartaEscolhida.getCustoMana() <= this.manaAtual)
                {
                    if (cartaEscolhida instanceof Criatura)
                    {
                        this.campoDeBatalha.adicionarCarta(cartaEscolhida);
                        System.out.println(this.getNome() + " invocou " + cartaEscolhida.getNome() + " no campo de batalha!");
                        this.utilizarMana(cartaEscolhida.getCustoMana());
                        this.mao.removerCarta(cartaEscolhida);
                        this.getControladorJogo().getJanela().getTelaBatalha().atualizarElementos();
                    }
                    else
                    {
                        System.out.println("Você só pode invocar cartas que sejam criaturas. Escolha novamente.\n");
                        continue;
                    }
                }
                else
                {
                    System.out.println("Mana insuficiente para jogar essa carta. Escolha novamente.\n");
                    continue;
                }
            }
            else
            {
                System.out.println("Escolha inválida. Tente novamente.");
                continue;
            }

            System.out.println("Deseja jogar outra carta? (s/n)");
            String resposta = this.scanner.next();

            if (!resposta.equalsIgnoreCase("s"))
            {
                System.out.println("Fim da fase de invocação de cartas para "+ nome +".\n");
                break;
            }
        }
    }

    public void processarEncantamentos()
    {
        for (int i = 0; i < encantamentosAtivos.size(); i++)
        {
            Encantamento encantamento = encantamentosAtivos.get(i);
            if (encantamento.getQuantidadeRodadas() > 0)
            {
                Object alvo = encantamento.getAlvo();
                if (alvo != null)
                {
                    encantamento.aplicarEfeito(alvo);
                    encantamento.reduzirRodadas();
                }
            }

            if (encantamento.getQuantidadeRodadas() <= 0)
            {
                encantamentosAtivos.remove(i);
                i--;
                System.out.println("O encantamento " + encantamento.getNome() + " terminou.");
            }
        }
    }


    public void adicionarEncantamentoAtivo(Encantamento encantamento)
    {
        encantamentosAtivos.add(encantamento);
    }

    public void enviarAoCemiterio(Carta carta)
    {
        cemiterio.adicionarCarta(carta);
        System.out.println(carta.getNome() + " foi enviada ao cemitério.");
    }

    public CampodeBatalha getCampoDeBatalha()
    {
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
        manaAtual++;
        JOptionPane.showMessageDialog(null, "+1 de Mana!");
        controladorJogo.getJanela().getTelaBatalha().atualizarElementos();
    }

    public void utilizarMana(int custoMana)
    {
        manaAtual -= custoMana;
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

    public void adicionarCartasProgresso()
    {
        int nivelAtual = this.getNivel();
        Carta[] cartasParaAdicionar = inventario.getCartasProgresso()[nivelAtual-1];

        for (Carta carta: cartasParaAdicionar){
            this.inventario.getCartasInventario().add(carta);
        }
    }
}