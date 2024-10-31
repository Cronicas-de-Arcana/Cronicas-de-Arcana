import Baralhos.Deck;
import Cartas.Inventario;
import Controle.Jogador;
import Controle.Jogar;
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

        Inventario inventarioGeral = new Inventario();

        Deck deckJ1 = new Deck(inventarioGeral.inicializadorCartasJ1());
        Deck deckJ2 = new Deck(inventarioGeral.inicializadorCartasJ2());

        Jogador jogador1 = new Jogador(nomeJogador1, deckJ1, 50, 10, 3);
        Jogador jogador2 = new Jogador(nomeJogador2, deckJ2, 50, 10 , 3);

        Jogar jogar = new Jogar(jogador1, jogador2,jogador1.getCampoDeBatalha(),jogador2.getCampoDeBatalha());
        jogar.iniciar();
    }
}