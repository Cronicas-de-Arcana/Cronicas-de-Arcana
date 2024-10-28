package Controle;

import Cartas.Carta;
import Cartas.Criatura;
import Espaço.CampodeBatalha;
import java.util.Scanner;

import java.util.Random;

public class Jogar {
    private Jogador jogador1;
    private Jogador jogador2;
    private CampodeBatalha campoDeBatalha;
    private CampodeBatalha campoJogador1;
    private CampodeBatalha campoJogador2;
    private Jogador jogadorAtivo;
    private Scanner scanner;

    public Jogar(Jogador jogador1, Jogador jogador2, CampodeBatalha campoJogador1, CampodeBatalha campoJogador2)
    {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.campoDeBatalha = new CampodeBatalha(jogador1.getMao(), jogador1.getCemiterio(), jogador1.getDeck());
        this.campoJogador1 = campoJogador1;
        this.campoJogador2 = campoJogador2;
        this.jogadorAtivo = new Random().nextBoolean() ? jogador1 : jogador2;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar()
    {
        //Cartas são embaralhadas no começo do jogo
        jogador1.getDeck().embaralhar();
        System.out.println("Cartas do Deck de "+jogador1.getNome()+" embaralhadas!\n");
        jogador2.getDeck().embaralhar();
        System.out.println("Cartas do Deck de "+jogador2.getNome()+" embaralhadas!\n");
        System.out.println("A batalha começou!");

        //Cartas são compradas do Deck já embaralhado
        for (int i = 0; i < 5; i++)
        {
            jogador1.comprarCartas();
        }
        System.out.println("Cartas de "+jogador1.getNome()+" compradas!\n");

        for (int i = 0; i < 5; i++){
            jogador2.comprarCartas();
        }
        System.out.println("Cartas de "+jogador2.getNome()+" compradas!\n");

        while (true)
        {
            executarTurno(jogadorAtivo);
            if (verificarVitoria(jogador1) || verificarVitoria(jogador2))
            {
                break;
            }
            jogadorAtivo = (jogadorAtivo == jogador1) ? jogador2 : jogador1;
        }
    }

    private void executarTurno(Jogador jogador)
    {
        System.out.println("É a vez de " + jogador.getNome());
        System.out.println("Fase de Compra: ");
        jogador.comprarCartas();

        System.out.println("Fase de mana");
        jogador.adicionarMana();

        System.out.println("Fase Principal");
        jogarCartas(jogador);

        System.out.println("Fase de Combate");
        combate(jogador);

        System.out.println(jogador.getNome() + " terminou seu turno.");


    }

    private void jogarCartas(Jogador jogador)
    {
        if (jogador.getMao().temCartasSuficientes(1)) {
            for (Carta carta : jogador.getMao().getCartas())
            {
                if (carta.getCustoMana() <= jogador.getManaAtual())
                {
                    campoDeBatalha.adicionarCartasAoCampo(carta);
                    jogador.utilizarMana(carta.getCustoMana());
                    break;
                }
            }
        } else {
            System.out.println("Não há cartas suficientes para jogar.");
        }
        System.out.println(jogador.getNome() + ", suas cartas na mão:");
        int i=0;
        for (Carta carta : jogador.getMao().getCartas())
        {
            System.out.println("Carta "+(i+1)+":"+ carta.getNome() + " - Custo de Mana: " + carta.getCustoMana());
            i++;
        }

        System.out.println("\n"+jogador.getNome() + " escolha uma carta para jogar (digite o número da carta) ou 0 para não jogar:");
        int escolha = scanner.nextInt();

        if (escolha > 0 && escolha <= jogador.getMao().getCartas().size()) {
            Carta cartaEscolhida = jogador.getMao().getCartas().get(escolha - 1);
            if (cartaEscolhida.getCustoMana() <= jogador.getManaAtual()) {
                campoDeBatalha.adicionarCartasAoCampo(cartaEscolhida);
                jogador.utilizarMana(cartaEscolhida.getCustoMana());
                jogador.getMao().removerCarta(cartaEscolhida);
                System.out.println(jogador.getNome() + " jogou a carta " + cartaEscolhida.getNome());
            } else {
                System.out.println("Mana insuficiente para jogar essa carta.");
            }
        } else {
            System.out.println("Nenhuma carta foi jogada.");
        }
    }

    private void combate(Jogador jogador)
    {
        System.out.println(jogador.getNome() + ", declare suas criaturas para atacar:");

        Jogador oponente = (jogador == jogador1) ? jogador2 : jogador1;

        for (Carta carta : campoDeBatalha.getCampo())
        {
            if (carta instanceof Criatura)
            {
                System.out.println(carta.getNome() + " ataca!");
            }
        }
    }
    public void atualizarNivel(Jogador jogador)
    {
        //10 níveis, começando do 1
        int[] experienciaPorNivel= {0, 200, 600, 1200, 1900, 2700, 3500, 4300, 5000, 6000};

        for (int i = 0; i < experienciaPorNivel.length - 1; i++)
        {
            if (jogador.getExperiencia() >= experienciaPorNivel[i])
            {
                jogador.setNivel(i + 1);
                break;
            }
        }
    }

    public void adicionarExperiencia(Jogador vencedor, Jogador perdedor)
    {
        vencedor.experiencia += 300;
        perdedor.experiencia += 100;

        atualizarNivel(vencedor);
        atualizarNivel(perdedor);
    }

    private boolean verificarVitoria(Jogador jogador)
    {
        if (jogador.getHp() <= 0) {
            System.out.println(jogador.getNome() + " foi derrotado!");
            return true;
        }

        return false;
    }
}
