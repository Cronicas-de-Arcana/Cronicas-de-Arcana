//Intuito dessa Classe é ser a responsavel pelo andamento do jogo integrando Front e Back

package Controle;

import Cartas.Inventario;
import Controle.View.Janela;
import Controle.View.TelaInicial;
import Controle.View.TelaInventario;
import Espaço.View.TelaBatalha;

import javax.swing.*;
import java.util.Random;

public class ControladorJogo {
    private final Jogar jogar;
    private final Jogador jogador1;
    private final Jogador jogador2;
    private Jogador jogadorAtual;
    private Janela janela;
    private final Inventario inventario;
    private String faseJogo;

    public ControladorJogo(Jogador jogador1, Jogador jogador2) {
        //Inicialização de atributos do controlador
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogador1.setControladorJogo(this);
        this.jogador2.setControladorJogo(this);
        this.jogadorAtual = jogador1;
        this.inventario = new Inventario();
        this.faseJogo = "ESCOLHA";
        this.jogar = new Jogar(jogador1, jogador2, jogador1.getCampoDeBatalha(), jogador2.getCampoDeBatalha());
        this.jogar.setControladorJogo(this);
    }

    public String getFaseJogo() { return faseJogo; }

    public void setFaseJogo(String faseJogo) { this.faseJogo = faseJogo; }

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
        janela.getTelaBatalha().atualizarElementos();
        JOptionPane.showMessageDialog(null, jogadorAtual.getNome() + " deve jogar", "Próximo Turno", JOptionPane.INFORMATION_MESSAGE);
    }

    public void iniciarPartida(){
        Jogador jogadorAtual = new Random().nextBoolean() ? jogador1 : jogador2;
        setJogadorAtual(jogadorAtual);
        JOptionPane.showMessageDialog(null, jogadorAtual.getNome() + " deve jogar", "Informação", JOptionPane.INFORMATION_MESSAGE);
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

        jogar.faseEscolha();
    }

    //Ações validas devem chamar esse metodo!!!
    public void registrarJogada(Jogador jogador) {
        if (jogador.equals(jogador1)) {
            jogador1.setJogou(true);
        } else if (jogador.equals(jogador2)) {
            jogador2.setJogou(true);
        }
    }

    //Metodo que deve validar mudança de estado do jogo!
    public boolean verificarJogadoresJogaram() {
        if (jogador1.getJogou() && jogador2.getJogou()) {
            jogador1.setJogou(false);
            jogador2.setJogou(false);
            return true; // Ambos jogaram
        }
        return false; // Ainda aguardando
    }

    public void processarEncantamentos() {
        JOptionPane.showMessageDialog(null, "Processando efeitos de encantamentos no campo...");
        jogar.processarEncantamentos(); // Chama o método central
        janela.getTelaBatalha().atualizarElementos(); // Atualiza a interface
    }


}
