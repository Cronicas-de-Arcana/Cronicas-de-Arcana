import Baralhos.Deck;
import Baralhos.Mao;
import Cartas.ControleDeCartas;
import Cartas.Criatura;
import Cartas.Encantamento;
import Cartas.Feitico;
import Controle.Jogador;
import Controle.Jogar;
import Espaço.CampodeBatalha;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //Coletando info para gerar Jogadores
        System.out.print("Insira o nome do Jogador 1: ");
        String nomeJogador1 = scanner.nextLine();
        System.out.print("Insira o nome do Jogador 2: ");
        String nomeJogador2 = scanner.nextLine();

        ControleDeCartas controleDeCartas = new ControleDeCartas();

        Deck deckJ1 = new Deck(controleDeCartas.inicializadorCartasJ1());
        Deck deckJ2 = new Deck(controleDeCartas.inicializadorCartasJ2());

        Mao maoJogador1 = new Mao();
        Mao maoJogador2 = new Mao();

        Jogador jogador1 = new Jogador(nomeJogador1, deckJ1, 50, 10, 3);
        Jogador jogador2 = new Jogador(nomeJogador2, deckJ2, 50, 10 , 3);

        CampodeBatalha campoJogador1 = new CampodeBatalha(maoJogador1, jogador1.getCemiterio(), deckJ1);
        CampodeBatalha campoJogador2 = new CampodeBatalha(maoJogador2, jogador2.getCemiterio(), deckJ2);


        for (int i = 0; i < 3; i++)
        {
            campoJogador1.comprarCarta();
        }

        for (int i = 0; i < 3; i++)
        {
            campoJogador2.comprarCarta();
        }

        System.out.println("Cartas na mão do " + jogador1.getNome() + ":");
        maoJogador1.mostrarCartas();

        System.out.println("Cartas na mão do " + jogador2.getNome() + ":");
        maoJogador2.mostrarCartas();

        Jogar jogar = new Jogar(jogador1, jogador2,campoJogador1,campoJogador2);
        jogar.iniciar();
    }
}