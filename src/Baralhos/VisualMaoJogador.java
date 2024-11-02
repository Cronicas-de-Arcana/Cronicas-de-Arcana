import Cartas.Carta;
import Cartas.ModeloCarta;
import Baralhos.Mao;
import Visualização.ComponenteVisual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VisualMaoJogador extends ComponenteVisual {
    private Mao mao;
    private ArrayList<ModeloCarta> modelosCartas;

    public VisualMaoJogador(Mao mao) {
        this.mao = mao;
        this.modelosCartas = new ArrayList<>();
        this.definirEstilo();
        this.renderizar();
    }

    @Override
    public void definirEstilo() {
        this.setLayout(new GridLayout(1, 0, 10, 10)); // Layout para dispor as cartas lado a lado
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
    }

    // Metodo renderizar para exibir as cartas da mão
    public void renderizar() {
        // Limpa cartas anteriores antes de renderizar as novas
        this.removeAll();
        modelosCartas.clear();

        // Itera sobre as cartas na mão e cria modelos de cartas
        for (Carta carta : mao.getCartas()) {
            ModeloCarta modelo = new ModeloCarta(carta);
            modelosCartas.add(modelo);
            this.add(modelo);  // Adiciona o modelo visual da carta ao layout
        }

        // Atualiza o layout da mão do jogador para refletir as mudanças
        revalidate();
        repaint();
    }

    // Metodo para atualizar a mão dinamicamente
    public void atualizarCartas() {
        renderizar();  // Re-renderiza toda a mão ao atualizar as cartas
    }

    // Adicionalmente, pode-se incluir métodos para adicionar/remover cartas dinamicamente
    public void adicionarCarta(Carta carta) {
        mao.adicionarCartas(carta);  // Adiciona a carta à mão
        atualizarCartas();           // Atualiza a interface para refletir a mudança
    }

    public void removerCarta(Carta carta) {
        mao.removerCarta(carta);     // Remove a carta da mão
        atualizarCartas();           // Atualiza a interface para refletir a mudança
    }
}
