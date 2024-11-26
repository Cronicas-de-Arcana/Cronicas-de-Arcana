package Controle;

import Cartas.Carta;
import Cartas.Criatura;
import Cartas.Encantamento;
import Cartas.Feitico;
import Controle.View.ModeloTelaVitoria;
import Espaço.CampodeBatalha;

import javax.swing.*;
import java.util.ArrayList;
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

    public void validarCampoOponente() {
        Jogador jogadorAtual = controladorJogo.getJogadorAtual();
        Jogador jogadorOponente = (jogadorAtual == controladorJogo.getJogador1())
                ? controladorJogo.getJogador2()
                : controladorJogo.getJogador1();

        CampodeBatalha campoOponente = jogadorOponente.getCampoDeBatalha();

        // Verifica se o campo do oponente está vazio
        if (campoOponente.getCampo().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo de " + jogadorOponente.getNome() + " está vazio! Ataque direto permitido!");

            if (cartaAtacante instanceof Criatura atacante) {
                jogadorOponente.receberDano(atacante.getPoder());
                JOptionPane.showMessageDialog(null, jogadorOponente.getNome() + " recebeu " + atacante.getPoder() + " de dano direto!");
            } else if (cartaAtacante instanceof Feitico feitico) {
                jogadorOponente.receberDano(feitico.getDano());
                jogadorAtual.getCemiterio().adicionarCarta(feitico);
                JOptionPane.showMessageDialog(null, jogadorOponente.getNome() + " recebeu " + feitico.getDano() + " de dano direto!");
            }

            controladorJogo.registrarJogada(controladorJogo.getJogadorAtual());
            cartaAtacante = null; // Reseta a carta atacante após o ataque
            controladorJogo.mudarJogadorAtual(); // Passa para o próximo jogador
            controladorJogo.getJanela().getTelaBatalha().atualizarElementos();
            return; // Sai do metodo após validar o campo vazio
        }

        // Verifica se o campo do oponente não possui criaturas
        if (campoOponente.getCampo().stream().allMatch(carta -> carta instanceof Feitico || carta instanceof Encantamento)) {
            JOptionPane.showMessageDialog(null, "Campo de " + jogadorOponente.getNome() + " não possui criaturas! Ataque direto permitido!");

            if (cartaAtacante instanceof Criatura atacante) {
                jogadorOponente.receberDano(atacante.getPoder());
                JOptionPane.showMessageDialog(null, jogadorOponente.getNome() + " recebeu " + atacante.getPoder() + " de dano direto!");
            } else if (cartaAtacante instanceof Feitico feitico) {
                jogadorOponente.receberDano(feitico.getDano());
                jogadorAtual.getCemiterio().adicionarCarta(feitico);
                JOptionPane.showMessageDialog(null, jogadorOponente.getNome() + " recebeu " + feitico.getDano() + " de dano direto!");
            }

            controladorJogo.registrarJogada(controladorJogo.getJogadorAtual());
            cartaAtacante = null; // Reseta a carta atacante após o ataque
            controladorJogo.mudarJogadorAtual(); // Passa para o próximo jogador
            controladorJogo.getJanela().getTelaBatalha().atualizarElementos();
        }
        controladorJogo.getJogar().verificarVitoria(jogadorAtual, jogadorOponente);
    }

    public void executarAtaque() {
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

        // Verifica se a carta atacante é válida (Criatura ou Feitiço, mas não Encantamento)
        if (cartaAtacante instanceof Encantamento) {
            JOptionPane.showMessageDialog(null, "Encantamentos não podem ser usados como atacantes!");
            return;
        }

        // Lógica para Criaturas
        if (cartaAtacante instanceof Criatura atacante) {
            if (cartaAlvo instanceof Criatura alvo) {
                // Combate entre criaturas
                JOptionPane.showMessageDialog(null, "Começar ataque entre criaturas!");
                atacante.atacarCriatura(alvo);
                controladorJogo.getJanela().getTelaBatalha().atualizarElementos();

                if (alvo.getHP() <= 0) {
                    jogadorOponente.getCampoDeBatalha().removerCarta(cartaAlvo); // Remove a carta do campo do oponente
                    jogadorOponente.getCemiterio().adicionarCarta(cartaAlvo); // Adiciona carta ao cemitério do oponente
                }

                if (atacante.getHP() <= 0) {
                    campoAtual.removerCarta(cartaAtacante); // Remove a carta do campo do jogador atual
                    jogadorAtual.getCemiterio().adicionarCarta(cartaAtacante);
                }
            } else if (cartaAlvo == null) {
                // Ataque direto ao jogador
                jogadorOponente.receberDano(atacante.getPoder());
                JOptionPane.showMessageDialog(null, jogadorOponente.getNome() + " recebeu " + atacante.getPoder() + " de dano direto!");
            }
        }

        // Lógica para Feitiços
        else if (cartaAtacante instanceof Feitico feitico) {
            if (cartaAlvo instanceof Criatura alvo) {
                JOptionPane.showMessageDialog(null, "Feitiço usado contra uma criatura!");
                feitico.lancarFeiticoCriatura(alvo);
                if (alvo.getHP() <= 0) {
                    jogadorOponente.getCampoDeBatalha().removerCarta(cartaAlvo);
                    jogadorOponente.getCemiterio().adicionarCarta(cartaAlvo);
                }
                jogadorAtual.getCampoDeBatalha().removerCarta(cartaAtacante);
                jogadorAtual.getCemiterio().adicionarCarta(feitico);
            } else if (cartaAlvo == null) {
                // Ataque direto ao jogador com Feitiço
                jogadorOponente.receberDano(feitico.getDano());
                jogadorAtual.getCemiterio().adicionarCarta(feitico);
                JOptionPane.showMessageDialog(null, jogadorOponente.getNome() + " recebeu " + feitico.getDano() + " de dano direto!");
            }
        }

        // Atualiza elementos da interface após o ataque
        controladorJogo.getJanela().getTelaBatalha().atualizarElementos();

        // Após o ataque, reseta as cartas e verifica o estado do jogo
        cartaAtacante = null;
        cartaAlvo = null;
        verificarVitoria(jogador1, jogador2);
        /* Verifica se o jogo acabou
        if (jogadorOponente.getHp() <= 0) {
            JOptionPane.showMessageDialog(null, jogadorAtual.getNome() + " venceu o jogo!");
            return; // Encerra o jogo
        }*/
        controladorJogo.mudarJogadorAtual(); // Passa para o próximo jogador
    }

    /*public void iniciar()
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
    }*/

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

        Jogador jogadorAtual = new Random().nextBoolean() ? jogador1 : jogador2;
        controladorJogo.setJogadorAtual(jogadorAtual);
        JOptionPane.showMessageDialog(null, "Inicio da fase de Escolha de Cartas!");
        JOptionPane.showMessageDialog(null, jogadorAtual.getNome() + " deve escolher sua Carta", "Informação", JOptionPane.INFORMATION_MESSAGE);
        controladorJogo.getJanela().getTelaBatalha().atualizarElementos();
    }

    /*private void executarTurno(Jogador jogador1, Jogador jogador2)
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
    }*/

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
            JOptionPane.showMessageDialog(null, "O jogador foi derrotado!");
            adicionarExperiencia(jogador2, jogador1);
            ModeloTelaVitoria telaVitoria = new ModeloTelaVitoria(jogador2, getControladorJogo());
            controladorJogo.getJanela().setTelaVitoria(telaVitoria);
            controladorJogo.getJanela().mudarTela(telaVitoria);
            return true;
        }
        else if (jogador2.getHp() <= 0)
        {
            JOptionPane.showMessageDialog(null, "O jogador foi derrotado!");
            adicionarExperiencia(jogador1, jogador2);
            ModeloTelaVitoria telaVitoria = new ModeloTelaVitoria(jogador1, getControladorJogo());
            controladorJogo.getJanela().setTelaVitoria(telaVitoria);
            controladorJogo.getJanela().mudarTela(telaVitoria);
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

    public void processarEncantamentos() {
        // Processa encantamentos do Jogador 1
        processarEncantamentosJogador(jogador1);
        controladorJogo.registrarJogada(jogador1);
        controladorJogo.getJanela().getTelaBatalha().atualizarElementos();

        // Processa encantamentos do Jogador 2
        processarEncantamentosJogador(jogador2);
        controladorJogo.registrarJogada(jogador2);
        controladorJogo.getJanela().getTelaBatalha().atualizarElementos();

        if (controladorJogo.verificarJogadoresJogaram()){
            controladorJogo.setFaseJogo("ESCOLHA");
            controladorJogo.getJanela().getTelaBatalha().atualizarElementos();
            JOptionPane.showMessageDialog(null, "Fase de processamento de encantamento encerrada!");
            controladorJogo.getJogar().faseEscolha();
            controladorJogo.getJanela().getTelaBatalha().atualizarElementos();
        }
    }

    private void processarEncantamentosJogador(Jogador jogador) {
        CampodeBatalha campo = jogador.getCampoDeBatalha();

        // Valida se há cartas no campo de batalha do jogador
        if (campo.getCampo().isEmpty()) {
            JOptionPane.showMessageDialog(null, jogador.getNome() + " não possui cartas no campo de batalha.");
            return; // Sai do metodo se o campo estiver vazio
        }

        if (!possuiEncantamentos(jogador)) {
            JOptionPane.showMessageDialog(null, jogador.getNome() + " não possui encantamentos no campo de batalha.");
            return; // Sai do metodo se não houver encantamentos
        }

        Jogador adversario = (jogador == jogador1) ? jogador2 : jogador1;
        ArrayList<Carta> encantamentosParaRemover = new ArrayList<>();

        for (Carta carta : campo.getCampo()) {
            if (carta instanceof Encantamento encantamento) {
                // Aplica efeitos às criaturas no campo do adversário
                encantamento.aplicarEfeitoAoCampo(adversario);

                // Atualiza a interface com mensagens visuais
                JOptionPane.showMessageDialog(null, encantamento.getNome() + " aplicou seus efeitos!");

                // Reduz rodadas restantes e verifica se deve ser removido
                encantamento.reduzirRodadas();
                if (encantamento.getQuantidadeRodadas() <= 0) {
                    encantamentosParaRemover.add(carta);
                }
            }
        }

        // Remove encantamentos expirados e atualiza a interface
        for (Carta carta : encantamentosParaRemover) {
            campo.removerCarta(carta);
            jogador.getCemiterio().adicionarCarta(carta);
            JOptionPane.showMessageDialog(null, "Encantamento " + carta.getNome() + " expirou e foi movido para o cemitério.");
        }
    }

    private boolean possuiEncantamentos(Jogador jogador) {
        CampodeBatalha campo = jogador.getCampoDeBatalha();

        // Verifica se o campo contém algum encantamento
        for (Carta carta : campo.getCampo()) {
            if (carta instanceof Encantamento) {
                return true; // Retorna true se encontrar um encantamento
            }
        }

        return false; // Retorna false se nenhum encantamento for encontrado
    }

}
