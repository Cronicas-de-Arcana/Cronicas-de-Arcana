import Baralhos.Deck;
import Cartas.Inventario;
import Controle.ControladorJogo;
import Controle.Jogador;

import java.util.Scanner;

//Classe voltada para testes de interface e integração do front com back
//Usar ela pra testar a interface
public class MainInterface {
    public static void main(String[] args) {
        // Dados para teste
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        Deck deckJ1 = new Deck(inventario.inicializadorCartasJ1());
        Deck deckJ2 = new Deck(inventario.inicializadorCartasJ2());
        Jogador jogador1 = new Jogador("Lucas", deckJ1, 50, 10, 3, scanner);
        Jogador jogador2 = new Jogador("Renan", deckJ2, 50, 10, 3, scanner);

        // Inicializa o controlador, que deve abrir a tela inicial
        ControladorJogo controladorJogo = new ControladorJogo(jogador1, jogador2);
        controladorJogo.inicializacaoJanela();
    }
}
