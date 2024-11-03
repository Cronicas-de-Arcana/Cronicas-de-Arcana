package Controle.View;

import Visualização.OuvinteMudancaTela;
import Visualização.Tela;

import javax.swing.*;

public class Janela extends JFrame implements OuvinteMudancaTela {
    private Tela telaAtual;

    //Construtor da Janela que rodará o jogo -> Inicia tela inicial que sera passada como argumento (main)
    public Janela(Tela telaInicial) {
        super("Crônicas de Arcana");
        this.telaAtual = telaInicial;

        // Registra Janela como observador da TelaInicial
        if (telaInicial instanceof TelaInicial) {
            ((TelaInicial) telaInicial).setOuvinteMudancaTela(this);
        }

        this.add(telaAtual);
        setContentPane(telaAtual);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }

    public void setTelaAtual(Tela novaTela) {
        this.telaAtual = novaTela;
        setContentPane(novaTela);
        revalidate();
        repaint();
    }

    @Override
    public void mudarTela(Tela novaTela) {
        setTelaAtual(novaTela);
    }

}