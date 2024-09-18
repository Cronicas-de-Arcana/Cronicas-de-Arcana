
import java.util.Random;

public class Jogar {
    private Jogador jogador1;
    private Jogador jogador2;
    private CampodeBatalha campoDeBatalha;
    private Jogador jogadorAtivo;

    public Jogar(Jogador jogador1, Jogador jogador2)
    {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.campoDeBatalha = new CampodeBatalha(jogador1.getMao(), jogador1.getCemiterio(), jogador1.getDeck());
        this.jogadorAtivo = new Random().nextBoolean() ? jogador1 : jogador2; // Decide aleatoriamente quem começa
    }

    public void iniciar()
    {
        jogador1.getDeck().embaralhar();
        jogador2.getDeck().embaralhar();

        for (int i = 0; i < 5; i++) {
            jogador1.comprarCartas();
            jogador2.comprarCartas();
        }

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
        jogador.reiniciarMana();

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
        for (Carta carta : jogador.getMao().getCartas())
        {
            System.out.println(carta.getNome() + " - Custo de Mana: " + carta.getCustoMana());
        }

        for (Carta carta : jogador.getMao().getCartas())
        {
            if (carta.getCustoMana() <= jogador.getManaAtual())
            {
                campoDeBatalha.adicionarCartasAoCampo(carta);
                jogador.utilizarMana(carta.getCustoMana());
                break;
            }
        }
    }



    private void combate(Jogador jogador)
    {
        System.out.println(jogador.getNome() + ", declare suas criaturas para atacar:");

        Jogador oponente = (jogador == jogador1) ? jogador2 : jogador1;

        for (Carta carta : campoDeBatalha.getCampo())
        {
            if (carta instanceof Criatura) {
                System.out.println(carta.getNome() + " ataca!");
            }
        }
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
