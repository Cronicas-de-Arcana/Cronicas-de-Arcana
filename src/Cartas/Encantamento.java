package Cartas;
import Controle.*;

public class Encantamento extends Carta
{
    protected String efeitoContinuo;
    protected int quantidadeRodadas;
    protected int cura;
    protected int dano;
    protected double modificadorDano;

    public Encantamento(String nome, int custoMana, String efeitoContinuo, int quantidadeRodadas ,int dano, int cura, double modificadorDano)
    {
        super(nome, custoMana);
        this.efeitoContinuo = efeitoContinuo;
        this.quantidadeRodadas = quantidadeRodadas;
        this.cura = cura;
        this.dano = dano;
        this.modificadorDano = modificadorDano;
    }

    public void jogar()
    {
        System.out.println(getNome() + " foi sumonada no campo de batalha!");
    }

    public void efeito()
    {
        System.out.println("Habilidade especial de " + getNome() + ": " + efeitoContinuo);
    }

    public String getEfeitoContinuo()
    {
        return efeitoContinuo;
    }

    public int getQuantidadeRodadas()
    {
        return quantidadeRodadas;
    }

    public int getCura()
    {
        return cura;
    }

    public int getDano()
    {
        return dano;
    }

    public double getModificadorDano()
    {
        return modificadorDano;
    }

    public void lancarEncantamentoCriatura(Criatura alvo)
    {
        for (int i = 0; i < quantidadeRodadas; i++)
        {
            if (dano > 0) {
                System.out.println(getNome() + " causou " + dano + " de dano a " + alvo.getNome() + "por" + quantidadeRodadas + "rodadas.");
                alvo.receberDano(dano);
            } else if (cura > 0)
            {
                System.out.println(getNome() + " curou " + cura + " pontos de vida de " + alvo.getNome() + "por" + quantidadeRodadas + "rodadas.");
                alvo.receberCura(cura);
            }
            else if (modificadorDano != 0)
            {
                alvo.setPoder(alvo.getPoder() + modificadorDano);
                String tipo = modificadorDano > 0 ? "aumentou" : "reduziu";
                System.out.println(getNome() + " " + tipo + " o poder de " + alvo.getNome() + " em " + modificadorDano + " por " + quantidadeRodadas + " rodadas.");
            }
        }
    }

    public void lancarEncantamentoJogador(Jogador alvo)
    {
        for (int i = 0; i < quantidadeRodadas; i++)
        {
            if (dano > 0) {
                System.out.println(getNome() + " causou " + dano + " de dano a " + alvo.getNome() + "por" + quantidadeRodadas + "rodadas.");
                alvo.receberDano(dano);
            } else if (cura > 0) {
                System.out.println(getNome() + " curou " + cura + " pontos de vida de " + alvo.getNome() + "por" + quantidadeRodadas + "rodadas.");
                alvo.receberCura(cura);
            }
        }
    }
}