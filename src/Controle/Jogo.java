package Controle;

import Cartas.Carta;
import Cartas.Criatura;
import Espaço.CampodeBatalha;
import Controle.Jogador;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.List;

public class Jogo
{
    private Jogador jogador1;
    private Jogador jogador2;
    private CampodeBatalha campoDeBatalha;
    private Jogador jogadorAtual;
    private CampodeBatalha campoJogador1;
    private CampodeBatalha campoJogador2;
    private Scanner scanner;


    public Jogo(Jogador jogador1, Jogador jogador2, CampodeBatalha campoJogador1, CampodeBatalha campoJogador2))
    {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.campoJogador1 = campoJogador1;
        this.campoJogador2 = campoJogador2;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar()
    {
        boolean rodarJogo = true;

        while (rodarJogo)
        {

            this.campoDeBatalha = new CampodeBatalha(jogador1.getMao(), jogador1.getCemiterio(), jogador1.getDeck());

            System.out.println("O jogo começou! Boa sorte, " + jogador1.getNome() + " e " + jogador2.getNome() + "!");

            this.jogadorAtual = new Random().nextBoolean() ? jogador1 : jogador2;

            jogador1.getDeck().embaralhar();
            jogador2.getDeck().embaralhar();

            boolean jogoFinalizado = false;

            while(!jogoFinalizado)
            {
                executarTurno(jogadorAtual);
                if (verificarVitoria(jogador1) || verificarVitoria(jogador2))
                {
                    break;
                }
                jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;

                System.out.println("Deseja iniciar uma nova partida? (0 para sim, 1 para não)");
                int escolha = scanner.nextInt();

                if (escolha != 0) {
                    rodarJogo = false;
                    System.out.println("Obrigado por jogar!");
                }
            }
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
        System.out.println("                             ");
    }

    private void jogarCartas(Jogador jogador)
    {
        System.out.println(jogador.getNome() + ", suas cartas na mão:");
        for (int i =0; i < jogador.getMao().getCartas().size() ; i++)
        {
            Carta carta = jogador.getMao().getCartas().get(i);
            System.out.println((i + 1) + ": " + carta.getNome() + " - Custo de Mana: " + carta.getCustoMana());
        }

        System.out.println("Escolha uma carta para jogar (digite o número da carta) ou 0 para não jogar:");
        int escolha = scanner.nextInt();

        if (escolha > 0 && escolha <= jogador.getMao().getCartas().size())
        {
            Carta cartaEscolhida = jogador.getMao().getCartas().get(escolha - 1);
            if (cartaEscolhida.getCustoMana() <= jogador.getManaAtual())
            {
                campoDeBatalha.adicionarCartasAoCampo(cartaEscolhida);
                jogador.utilizarMana(cartaEscolhida.getCustoMana());
                jogador.getMao().removerCarta(cartaEscolhida);
                System.out.println(jogador.getNome() + " jogou a carta " + cartaEscolhida.getNome());
            } else
            {
                System.out.println("Mana insuficiente para jogar essa carta.");
            }
        }
        else
        {
            System.out.println("Nenhuma carta foi jogada.");
        }
    }

    private void combate(Jogador atacante)
    {
        System.out.println(atacante.getNome() + ", declare suas criaturas para atacar:");
        Jogador defensor = (atacante == jogador1) ? jogador2 : jogador1;

        List<Criatura> criaturasAtacantes = campoDeBatalha.getCriaturasNoCampo(atacante);
        if (criaturasAtacantes.isEmpty()) {
            System.out.println("Nenhuma criatura no campo para atacar.");
            return;
        }

        List<Criatura> criaturasEscolhidas = new ArrayList<>();
        for (int i = 0; i < criaturasAtacantes.size(); i++)
        {
            Criatura criatura = criaturasAtacantes.get(i);
            System.out.println((i + 1) + ": " + criatura.getNome() + " - Poder: " + criatura.getPoder());
        }

        System.out.println("Escolha criaturas para atacar (digite os números separados por vírgula, ou 0 para não atacar):");
        String input = scanner.next();
        if (!input.equals("0"))
        {
            String[] escolhas = input.split(",");
            for (String escolha : escolhas)
            {
                int index = Integer.parseInt(escolha.trim()) - 1;
                if (index >= 0 && index < criaturasAtacantes.size())
                {
                    criaturasEscolhidas.add(criaturasAtacantes.get(index));
                }
            }
        }

        if (criaturasEscolhidas.isEmpty())
        {
            System.out.println("Nenhuma criatura atacou.");
            return;
        }

        System.out.println(defensor.getNome() + ", escolha suas criaturas para bloquear:");
        List<Criatura> criaturasBloqueadoras = new ArrayList<>();
        List<Criatura> criaturasNoCampoDefensor = campoDeBatalha.getCriaturasNoCampo(defensor);
        for (int i = 0; i < criaturasNoCampoDefensor.size(); i++)
        {
            Criatura criatura = criaturasNoCampoDefensor.get(i);
            System.out.println((i + 1) + ": " + criatura.getNome() + " - Resistencia: " + criatura.getResistencia());
        }

        System.out.println("Escolha criaturas para bloquear (digite os números separados por vírgula, ou 0 para não bloquear):");
        input = scanner.next();

        if (!input.equals("0"))
        {
            String[] escolhas = input.split(",");
            for (String escolha : escolhas) {
                int index = Integer.parseInt(escolha.trim()) - 1;
                if (index >= 0 && index < criaturasNoCampoDefensor.size()) {
                    criaturasBloqueadoras.add(criaturasNoCampoDefensor.get(index));
                }
            }
        }

        for (int i = 0; i < criaturasEscolhidas.size(); i++)
        {
            Criatura atacanteCriatura = criaturasEscolhidas.get(i);
            if (i < criaturasBloqueadoras.size())
            {
                Criatura bloqueadorCriatura = criaturasBloqueadoras.get(i);
                System.out.println(atacanteCriatura.getNome() + " ataca " + bloqueadorCriatura.getNome());
                bloquearCriatura(atacanteCriatura, bloqueadorCriatura, atacante, defensor);

            }
            else
            {
                System.out.println(atacanteCriatura.getNome() + " ataca " + defensor.getNome() + " diretamente!");
                atacanteCriatura.atacarJogador(defensor);
            }
        }
        if (defensor.getHp() <= 0) {
            System.out.println(defensor.getNome() + " foi derrotado!");
            verificarVitoria(atacante);
        }
    }

    public void bloquearCriatura(Criatura atacante, Criatura bloqueador, Jogador jogadorAtacante, Jogador jogadorDefensor) {
        bloqueador.receberDano(atacante.getPoder());
        atacante.receberDano(bloqueador.getPoder());

        if (bloqueador.getResistencia() <= 0) {
            System.out.println(bloqueador.getNome() + " foi destruído.");
            jogadorDefensor.getCemiterio().adicionarCartasNoCemiterio(bloqueador);
            jogadorDefensor.getCampoDeBatalha().removerCartaDoCampo(bloqueador); // Corrigido aqui
        }

        if (atacante.getResistencia() <= 0) {
            System.out.println(atacante.getNome() + " foi destruído.");
            jogadorAtacante.getCemiterio().adicionarCartasNoCemiterio(atacante);
            jogadorAtacante.getCampoDeBatalha().removerCartaDoCampo(atacante); // Corrigido aqui
        }
    }

    private boolean verificarVitoria(Jogador jogador)
    {
        if (jogador.getHp() <= 0)
        {
            System.out.println(jogador.getNome() + " foi derrotado!");
            return true;
        }
        if (jogador.getDeck().verificarDeckVazio())
        {
            System.out.println(jogador.getNome() + " foi derrotado por ficar sem cartas no deck!");
            return true;
        }
        return false;
    }
}