//Intuito dessa Classe é ser a responsavel pelo andamento do jogo integrando Front e Back

package Controle;

import Cartas.Carta;
import Cartas.Inventario;
import Controle.View.Janela;
import Controle.View.TelaInicial;
import Controle.View.TelaInventario;
import Espaço.View.TelaBatalha;

import javax.swing.*;
import java.util.Random;

public class ControladorJogo {
    private Jogar jogar;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private Janela janela;
    private Inventario inventario;

    public ControladorJogo(Jogador jogador1, Jogador jogador2) {
        //Inicialização de atributos do controlador
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogador1.setControladorJogo(this);
        this.jogador2.setControladorJogo(this);
        this.jogadorAtual = jogador1;
        this.inventario = new Inventario();
        this.jogar = new Jogar(jogador1, jogador2, jogador1.getCampoDeBatalha(), jogador2.getCampoDeBatalha());
        this.jogar.setControladorJogo(this);
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(Jogador jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public Jogar getJogar() {
        return jogar;
    }

    public Janela getJanela() {
        return janela;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void inicializacaoJanela(){
        // Cria a Janela e define TelaInicial como a primeira tela
        TelaInicial telaInicial = new TelaInicial(this);
        this.janela = new Janela(telaInicial);
        telaInicial.setOuvinteMudancaTela(this.janela);  // Registra a Janela como ouvinte
    }

    public void mostrarTelaBatalha(){
        TelaBatalha telaBatalha = new TelaBatalha(this.jogador1, this.jogador2, this);
        this.janela.setTelaBatalha(telaBatalha);
        this.janela.setTelaAtual(telaBatalha);
    }

    public void mostrarTelaInventario(Jogador jogadorAtual){
        TelaInventario telaInventario = new TelaInventario(this, jogadorAtual);
        this.janela.setTelaAtual(telaInventario);
    }

    public void mudarJogadorAtual(){
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        JOptionPane.showMessageDialog(null, jogadorAtual.getNome() + " deve jogar", "Próximo Turno", JOptionPane.INFORMATION_MESSAGE);
    }

    public void iniciarPartida(){
        Jogador jogadorAtual = new Random().nextBoolean() ? jogador1 : jogador2;
        setJogadorAtual(jogadorAtual);
        JOptionPane.showMessageDialog(null, jogadorAtual.getNome() + " deve jogar", "Informação", JOptionPane.INFORMATION_MESSAGE);

        executarTurno(jogadorAtual);
    }

    public void inicializacaoMaos(){
        //Embaralhar Decks
        jogador1.getDeck().embaralhar();
        jogador2.getDeck().embaralhar();

        //Compra inicial das 5 cartas pelos jogadores
        for (int i=0; i<4; i++){
            jogador1.comprarCartas();
            jogador2.comprarCartas();
        }

        //inicio de partida
        iniciarPartida();
    }

    public void executarTurno(Jogador jogadorAtual){
        //Jogador deve comprar cartas - atualização de tela acontece
        jogadorAtual.comprarCartas();
        //Jogador recebe +1 de mana - atualização de tela acontece
        jogadorAtual.adicionarMana();
        //Aqui o jogador escolhe a carta, isso acontece direto pela interface e pelo botao da carta!
        jogadorAtual.escolherCartaMao();
    }

    public void jogarCarta(Carta carta, Jogador jogador) {
        if (jogador != jogadorAtual) {
            JOptionPane.showMessageDialog(null, "Não é seu turno!", "Ação Inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (carta.getCustoMana() > jogador.getManaAtual()) {
            JOptionPane.showMessageDialog(null, "Mana insuficiente para jogar esta carta.", "Ação Inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Jogar a carta no campo de batalha
        jogador.getCampoDeBatalha().adicionarCarta(carta);
        jogador.utilizarMana(carta.getCustoMana());
        jogador.getMao().removerCarta(carta);

        // Atualizar a interface
        janela.getTelaBatalha().atualizarElementos();
        mudarJogadorAtual();
    }

}
