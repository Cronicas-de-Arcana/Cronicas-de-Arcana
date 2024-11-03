//Intuito dessa Classe é ser a responsavel pelo andamento do jogo integrando Front e Back

package Controle;

import Baralhos.Deck;
import Cartas.Inventario;
import Controle.View.Janela;
import Controle.View.TelaInicial;
import Espaço.View.TelaBatalha;

import javax.swing.*;
import java.util.Scanner;

public class ControladorJogo {
    private Jogar jogar;
    private Jogador jogador1;
    private Jogador jogador2;
    private Janela janela;

    public ControladorJogo(Jogador jogador1, Jogador jogador2) {
        //Inicialização de atributos do controlador
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogar = new Jogar(jogador1, jogador2,jogador1.getCampoDeBatalha(), jogador2.getCampoDeBatalha());

        // Cria a Janela e define TelaInicial como a primeira tela
        TelaInicial telaInicial = new TelaInicial(this);
        this.janela = new Janela(telaInicial);
        telaInicial.setOuvinteMudancaTela(this.janela);  // Registra a Janela como ouvinte
        this.iniciarJogo();
    }

    public void iniciarJogo(){
        this.jogar.iniciar(); // Inicia a partida no Backend
    }

    public void mostrarTelaBatalha(){
        TelaBatalha telaBatalha = new TelaBatalha(this.jogador1, this.jogador2);
        this.janela.setTelaAtual(telaBatalha);
    }
}
