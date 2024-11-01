package Visualização;

import javax.swing.*;

public class JanelaReal extends JFrame {
    private Tela telaAtual;

    //Construtor da Janela que rodará o jogo -> Inicia tela inicial que sera passada como argumento (main)
    public JanelaReal(Tela telaInicial) {
        this.setLayout(telaInicial.getLayout());
        this.telaAtual = telaInicial;
        setContentPane(telaAtual);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setVisible(true);
    }

    public void setTelaAtual(Tela telaAtual) {
        this.setLayout(telaAtual.getLayout());
        this.removeAll();
        this.telaAtual = telaAtual;
        setContentPane(telaAtual);
        revalidate();
        repaint();
    }
}
