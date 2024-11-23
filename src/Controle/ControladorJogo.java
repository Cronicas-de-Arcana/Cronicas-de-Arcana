//Intuito dessa Classe é ser a responsavel pelo andamento do jogo integrando Front e Back

package Controle;

import Cartas.Inventario;
import Controle.View.Janela;
import Controle.View.TelaInicial;
import Controle.View.TelaInventario;
import Espaço.View.TelaBatalha;

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
        jogar.iniciarPartida();
    }

    public void mostrarTelaInventario(Jogador jogadorAtual){
        TelaInventario telaInventario = new TelaInventario(this, jogadorAtual);
        this.janela.setTelaAtual(telaInventario);
    }

    public void inicializacaoMaos(){
        //Embaralhar Decks
        jogador1.getDeck().embaralhar();
        jogador2.getDeck().embaralhar();

        //Compra inicial das 5 cartas
        for (int i=0; i<5; i++){
            jogador1.comprarCartas();
            jogador2.comprarCartas();
        }

        this.jogar = new Jogar(jogador1, jogador2, jogador1.getCampoDeBatalha(), jogador2.getCampoDeBatalha());
        this.jogar.setControladorJogo(this);
    }
}
