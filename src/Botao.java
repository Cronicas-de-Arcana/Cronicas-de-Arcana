import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Botao extends JButton {

    //Construtor que recebe String a ser disposta no botão
    public Botao(String texto, int largura, int altura, Color corBotao, Color corBorda){
        super (texto);
        this.setPreferredSize(new Dimension(largura, altura)); //Definir tamanho do botao
        this.setBackground(corBotao);
        this.setOpaque(true);
        this.setBorder(new LineBorder(corBorda));
        this.setFocusPainted(false);
    }

    //metodo para configurações padrão
    public void configPadrao() {
        //Criar configurações padrão do botão
    }

    //metodo para atribuir função ao botão
    public void adicionarAcao (ActionListener l){
        super.addActionListener(l);
    }
}
