package Controle;

import Cartas.Carta;
import Cartas.Criatura;
import Cartas.Encantamento;
import Cartas.Feitico;
import Espaço.CampodeBatalha;

import javax.swing.*;
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
    private ControladorJogo controladorJogo;
    private Carta cartaAtacante;
    private Carta cartaAlvo;

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

    public ControladorJogo getControladorJogo() {
        return controladorJogo;
    }

    public void setControladorJogo(ControladorJogo controladorJogo) {
        this.controladorJogo = controladorJogo;
    }

    public Jogador getJogadorAtivo(){
        return jogadorAtivo;
    }

    public Carta getCartaAtacante() {
        return cartaAtacante;
    }

    public void setCartaAtacante(Carta cartaAtacante) {
        this.cartaAtacante = cartaAtacante;
    }

    public Carta getCartaAlvo() {
        return cartaAlvo;
    }

    public void setCartaAlvo(Carta cartaAlvo) {
        this.cartaAlvo = cartaAlvo;
    }

    public void validarCampoOponente(){
        Jogador jogadorAtual = controladorJogo.getJogadorAtual();
        Jogador jogadorOponente = (jogadorAtual == controladorJogo.getJogador1())
                ? controladorJogo.getJogador2()
                : controladorJogo.getJogador1();

        CampodeBatalha campoOponente = jogadorOponente.getCampoDeBatalha();

        if (campoOponente.getCampo().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo de " + jogadorOponente.getNome() + " está vazio!\n Jogador rececebe ataque direto!");
            if (cartaAtacante instanceof Criatura atacante) {
                jogadorOponente.receberDano(atacante.getPoder());
                JOptionPane.showMessageDialog(null, jogadorOponente.getNome() + " recebeu " + atacante.getPoder() + " de dano direto!");
            } else if (cartaAtacante instanceof Feitico feitico) {
                jogadorOponente.receberDano(feitico.getDano());
                jogadorAtual.getCemiterio().adicionarCarta(feitico);
                JOptionPane.showMessageDialog(null, jogadorOponente.getNome() + " recebeu " + feitico.getDano() + " de dano direto!");
            }
            cartaAtacante = null;
        }
        controladorJogo.getJanela().getTelaBatalha().atualizarElementos();
    }

    public void executarAtaque()
    {
        if (cartaAtacante == null && cartaAlvo == null) {
            JOptionPane.showMessageDialog(null, "Certifique-se de que um atacante e um alvo foram selecionados antes de iniciar o ataque!");
            return;
        }

        Jogador jogadorAtual = controladorJogo.getJogadorAtual();
        Jogador jogadorOponente = (jogadorAtual == controladorJogo.getJogador1())
                ? controladorJogo.getJogador2()
                : controladorJogo.getJogador1();

        CampodeBatalha campoOponente = jogadorOponente.getCampoDeBatalha();
        CampodeBatalha campoAtual = jogadorAtual.getCampoDeBatalha();

        // Verifica se a carta atacante é uma criatura
        if (cartaAtacante instanceof Criatura atacante) {
            if (cartaAlvo instanceof Criatura alvo) {
                // Combate entre criaturas
                JOptionPane.showMessageDialog(null, "Começar ataque!");
                atacante.atacarCriatura(alvo);
                controladorJogo.getJanela().getTelaBatalha().atualizarElementos();

                if (alvo.getHP() <= 0) {
                    jogadorOponente.getCampoDeBatalha().removerCarta(cartaAlvo);// Remove a carta do campo do oponente
                    jogadorOponente.getCemiterio().adicionarCarta(cartaAlvo); //Adiciona carta no cemitério do oponente
                    JOptionPane.showMessageDialog(null, alvo.getNome() + " foi destruído!");
                }

                if (atacante.getHP() <= 0) {
                    campoAtual.removerCarta(cartaAtacante); // Remove a carta do campo do jogador atual
                    JOptionPane.showMessageDialog(null, atacante.getNome() + " foi destruído!");
                }
            } else if (cartaAlvo == null) {
                // Ataque direto ao jogador
                jogadorOponente.receberDano(atacante.getPoder());
                JOptionPane.showMessageDialog(null, jogadorOponente.getNome() + " recebeu " + atacante.getPoder() + " de dano direto!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "A carta atacante precisa ser uma criatura!");
        }

        controladorJogo.getJanela().getTelaBatalha().atualizarElementos();
        // Após o ataque, reseta as cartas e avança para o próximo turno
        cartaAtacante = null;
        cartaAlvo = null;

        // Verifica se o jogo acabou
        if (jogadorOponente.getHp() <= 0) {
            JOptionPane.showMessageDialog(null, jogadorAtual.getNome() + " venceu o jogo!");
            return; // Encerra o jogo
        }

        controladorJogo.mudarJogadorAtual(); // Passa para o próximo jogador
    }

    public void iniciar()
    {
        jogador1.getDeck().embaralhar();
        System.out.println("\nCartas do Deck de " + jogador1.getNome() + " embaralhadas!");
        jogador2.getDeck().embaralhar();
        System.out.println("\nCartas do Deck de " + jogador2.getNome() + " embaralhadas!");
        System.out.println("\nA batalha começou!");

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

        while(true)
        {
            executarTurno(jogador1, jogador2);
            if (verificarVitoria(jogador1, jogador2) || verificarVitoria(jogador2, jogador1))
            {
                break;
            }
        }
    }

    public void faseEscolha()
    {
        controladorJogo.setFaseJogo("ESCOLHA");

        //Jogadores compram cartas
        jogador1.comprarCartas();
        jogador2.comprarCartas();

        //Jogadores recebem mana
        JOptionPane.showMessageDialog(null, "jogadores recebem 1 de mana");
        jogador1.adicionarMana();
        jogador2.adicionarMana();

        controladorJogo.setControleDeEscolhas(0);
        Jogador jogadorAtual = new Random().nextBoolean() ? jogador1 : jogador2;
        controladorJogo.setJogadorAtual(jogadorAtual);
        JOptionPane.showMessageDialog(null, "Inicio da fase de Escolha de Cartas!");
        JOptionPane.showMessageDialog(null, jogadorAtual.getNome() + " deve escolher sua Carta", "Informação", JOptionPane.INFORMATION_MESSAGE);
        controladorJogo.getJanela().getTelaBatalha().atualizarElementos();
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
        System.out.println("Combate iniciado entre " + jogador.getNome() + " e " + jogadorAlvo.getNome() + "!\n");

        if (jogadorAlvo.getCampoDeBatalha().getCampo().isEmpty())
        {
            System.out.println(jogadorAlvo.getNome() + " não tem criaturas no campo de batalha!\n");
            System.out.println(jogador.getNome() + ", você pode atacar diretamente!\n");
            jogador.getCampoDeBatalha().mostrarCartas();
            Carta cartaAtacante = jogador.escolherCartaCampo(jogador);

            System.out.println(jogador.getNome() + " você também pode atacar com um feitiço ou encantamento!\n");
            Carta cartaAtacante2 = jogador.escolherCartaMao(jogador);

            if (cartaAtacante != null)
            {
                ((Criatura) cartaAtacante).atacarJogador(jogadorAlvo);
            }
            else
            {
                System.out.println("Nenhuma criatura escolhida.");
            }

            if (cartaAtacante2 != null)
            {
                if (cartaAtacante2 instanceof Feitico)
                {
                    ((Feitico) cartaAtacante2).lancarFeiticoJogador(jogadorAlvo);
                }
                else if (cartaAtacante2 instanceof Encantamento)
                {
                    ((Encantamento) cartaAtacante2).lancarEncantamentoJogador(jogadorAlvo);
                }
            }
            else
            {
                System.out.println("Nenhum feitiço ou encantamento escolhido.");
            }
        }
        else
        {
            System.out.println("Cartas no campo de " + jogadorAlvo.getNome() + ":");
            jogadorAlvo.getCampoDeBatalha().mostrarCartas();
            System.out.println(jogador.getNome() + ", escolha qual criatura atacar:");
            Carta cartaDefensora = jogadorAlvo.escolherCartaCampo(jogadorAlvo);

            System.out.println("\n" + jogador.getNome() + ", declare suas criaturas para atacar:");
            jogador.getCampoDeBatalha().mostrarCartas();
            Carta cartaAtacante = jogador.escolherCartaCampo(jogador);

            System.out.println("\n" + jogador.getNome() + " você também pode atacar com um feitiço ou encantamento!\n");
            Carta cartaAtacante2 = jogador.escolherCartaMao(jogador);

            if (cartaAtacante != null)
            {
                double dano = (((Criatura) cartaAtacante).getPoder() - ((Criatura) cartaDefensora).getHP());
                ((Criatura) cartaAtacante).atacarCriatura((Criatura)cartaDefensora);
                if (((Criatura)cartaDefensora).getHP() <= 0)
                {
                    campoDeBatalha.removerCarta(cartaAtacante);
                    jogadorAlvo.receberDano(dano);
                }
            }
            else
            {
                System.out.println("Nenhuma criatura escolhida.");
            }

            if (cartaAtacante2 != null)
            {
                if (cartaAtacante2 instanceof Feitico)
                {
                    double dano = (((Feitico) cartaAtacante2).getDano() - ((Criatura) cartaDefensora).getHP());
                    ((Feitico) cartaAtacante2).lancarFeiticoCriatura((Criatura)cartaDefensora);
                    if (((Criatura)cartaDefensora).getHP() <= 0)
                    {
                        campoDeBatalha.removerCarta(cartaAtacante);
                        jogadorAlvo.receberDano(dano);

                    }
                }
                else if (cartaAtacante2 instanceof Encantamento)
                {
                    double dano = (((Feitico) cartaAtacante2).getDano() - ((Criatura) cartaDefensora).getHP());
                    ((Encantamento) cartaAtacante2).lancarEncantamentoCriatura((Criatura)cartaDefensora);
                    if (((Criatura)cartaDefensora).getHP() <= 0)
                    {
                        campoDeBatalha.removerCarta(cartaAtacante);
                        jogadorAlvo.receberDano(dano);
                    }
                }
            }
            else
            {
                System.out.println("Nenhum feitiço ou encantamento escolhido.");
            }
        }
    }

    private boolean verificarVitoria(Jogador jogador1, Jogador jogador2)
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
