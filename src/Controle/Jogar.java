package Controle;

import Cartas.Carta;
import Cartas.Criatura;
import Cartas.Encantamento;
import Cartas.Feitico;
import Espaço.CampodeBatalha;

import java.util.List;
import java.util.Scanner;

import java.util.Random;

public class Jogar
{
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
        // Cartas são embaralhadas no começo do jogo
        jogador1.getDeck().embaralhar();
        System.out.println("\nCartas do Deck de " + jogador1.getNome() + " embaralhadas!");
        jogador2.getDeck().embaralhar();
        System.out.println("\nCartas do Deck de " + jogador2.getNome() + " embaralhadas!");
        System.out.println("\nA batalha começou!");

        // 4 cartas são compradas do Deck já embaralhado, 1 será comprada quando a rodada começar
        System.out.println("\nCartas de " + jogador1.getNome() + " sorteadas:");
        for (int i = 0; i < 4; i++)
        {
            jogador1.comprarCartas();
        }

        System.out.println("\nCartas de " + jogador2.getNome() + " sorteadas:");
        for (int i = 0; i < 4; i++)
        {
            jogador2.comprarCartas();
        }

        while (true)
        {
            executarTurno(jogador1, jogador2);
            if (verificarVitoria(jogador1, jogador2) || verificarVitoria(jogador2, jogador1))
            {
                break;
            }
        }
    }

    private void executarTurno(Jogador jogador1, Jogador jogador2)
    {
        System.out.println("\nFase de Compra");
        System.out.println("\nCarta que " + jogador1.getNome() + " comprou:");
        jogador1.comprarCartas();
        System.out.println("\nCarta que " + jogador2.getNome() + " comprou:");
        jogador2.comprarCartas();

        System.out.println("\nFase de mana:\n");
        jogador1.adicionarMana();
        System.out.println("Nível de mana de " + jogador1.getNome() + ":" + jogador1.getManaAtual());
        jogador2.adicionarMana();
        System.out.println("Nível de mana de " + jogador2.getNome() + ":" + jogador2.getManaAtual() + "\n");

        // Preparação do campo de batalha usando o novo método
        System.out.println("Preparação do campo de Batalha!\n");
        jogador1.jogarCartasNoCampo();
        jogador2.jogarCartasNoCampo();

        System.out.println("Fase de Combate:");
        combate(jogador1, jogador2);
        combate(jogador2, jogador1);
        jogador1.processarEncantamentos();
        jogador2.processarEncantamentos();

        System.out.println("Terminou o turno.");
    }

    private void combate(Jogador jogador, Jogador jogadorAlvo)
    {
        System.out.println("Combate iniciado entre " + jogador.getNome() + " e " + jogadorAlvo.getNome() + "!");

        if (jogadorAlvo.getCampoDeBatalha().getCampo().isEmpty())
        {
            System.out.println(jogadorAlvo.getNome() + " não tem criaturas no campo de batalha. Você pode atacar diretamente!");

            System.out.println(jogador.getNome() + ", você pode atacar diretamente.");

            jogador.getCampoDeBatalha().mostrarCartas();
            Carta cartaEscolhida = jogador.escolherCartaCampo(jogador);

            System.out.println(jogadorAlvo.getNome() + " você também pode atacar com um feitiço ou encantamento!");

            jogador.getMao().mostrarCartas();
            Carta cartaEscolhida2 = jogador.escolherCartaMao(jogador);

            while(true)
            {
                if (cartaEscolhida != null)
                {
                    ((Criatura)cartaEscolhida).atacarJogador(jogadorAlvo);
                    break;
                }
                else
                {
                    System.out.println("Nenhuma criatura escolhida.");
                }
            }

            while(true)
            {
                if (cartaEscolhida2 != null)
                {
                    if (cartaEscolhida2 instanceof Feitico)
                    {
                        ((Feitico) cartaEscolhida2).lancarFeiticoJogador(jogadorAlvo);
                        break;
                    }
                    else if (cartaEscolhida2 instanceof Encantamento)
                    {
                        ((Encantamento) cartaEscolhida2).lancarEncantamentoJogador(jogadorAlvo);
                        break;
                    }
                }
                else
                {
                    System.out.println("Nenhum feitiço ou encantamento escolhido.");
                }
            }
        }
        else
        {
            System.out.println("Cartas no campo de " + jogadorAlvo.getNome() + ":");
            jogadorAlvo.getCampoDeBatalha().mostrarCartas();
            System.out.println(jogador.getNome() + ", escolha qual criatura atacar:");
            Carta cartaDefensora = jogadorAlvo.escolherCartaCampo(jogadorAlvo);

            System.out.println(jogador.getNome() + ", declare suas criaturas para atacar:");
            jogador.getCampoDeBatalha().mostrarCartas();
            Carta cartaAtacante = jogador.escolherCartaCampo(jogador);


            System.out.println(jogadorAlvo.getNome() + " você também pode atacar com um feitiço ou encantamento!");
            jogador.getMao().mostrarCartas();
            Carta cartaEscolhida2 = jogador.escolherCartaMao(jogador);

            while(true)
            {
                if (cartaAtacante instanceof Criatura && cartaDefensora instanceof Criatura)
                {
                    ((Criatura) cartaAtacante).atacar((Criatura)cartaDefensora);
                    break;
                }
                else
                {
                    System.out.println("Escolha inválida para ataque, escolha novamente.");
                }
            }

            while(true)
            {
                if (cartaEscolhida2 != null)
                {
                    if (cartaEscolhida2 instanceof Feitico)
                    {
                        ((Feitico) cartaEscolhida2).lancarFeiticoCriatura((Criatura)cartaDefensora);
                        break;
                    }
                    else if (cartaEscolhida2 instanceof Encantamento)
                    {
                        ((Encantamento) cartaEscolhida2).lancarEncantamentoCriatura((Criatura)cartaDefensora);
                        break;
                    }
                }
                else
                {
                    System.out.println("Nenhum feitiço ou encantamento escolhido.");
                }
            }
        }
    }


    private boolean verificarVitoria(Jogador jogador1 , Jogador jogador2)
    {
        if (jogador1.getHp() <= 0)
        {
            System.out.println(jogador1.getNome() + " foi derrotado!");
            adicionarExperiencia(jogador2, jogador1);
            return true;
        }
        else if (jogador2.getHp() <= 0)
        {
            System.out.println(jogador2.getNome() + " foi derrotado!");
            adicionarExperiencia(jogador1, jogador2);
            return true;
        }
        return false;
    }

    public void adicionarExperiencia(Jogador vencedor, Jogador perdedor)
    {
        vencedor.experiencia += 300;
        perdedor.experiencia += 100;

        vencedor.atualizarNivel();
        perdedor.atualizarNivel();
    }
}
