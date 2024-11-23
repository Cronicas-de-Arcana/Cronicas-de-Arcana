import Controle.ControladorJogo;
import Controle.Jogador;

public class MainReformulado {
    public static void main(String[] args) {
        String nomeJ1 = "Lucas";
        String nomeJ2 = "Renan";

        ControladorJogo controlador = new ControladorJogo(new Jogador(nomeJ1), new Jogador(nomeJ2));
        controlador.inicializacaoJanela();
    }
}
