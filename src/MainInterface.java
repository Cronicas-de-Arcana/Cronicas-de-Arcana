import Baralhos.Deck;
import Cartas.Inventario;
import Controle.ControladorJogo;
import Controle.Jogador;

import java.util.Scanner;

//Classe voltada para testes de interface
public class MainInterface {
    public static void main(String[] args) {
        // Dados para teste
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        Deck deckJ1 = new Deck(inventario.inicializadorCartasJ1());
        Deck deckJ2 = new Deck(inventario.inicializadorCartasJ2());
        Jogador jogador1 = new Jogador("Jogador 1", deckJ1, 100, 10, 2, scanner);
        Jogador jogador2 = new Jogador("Jogador 2", deckJ2, 100, 10, 2, scanner);

        // Inicializa o controlador, que deve abrir a tela inicial
        ControladorJogo controladorJogo = new ControladorJogo(jogador1, jogador2);
    }
}
