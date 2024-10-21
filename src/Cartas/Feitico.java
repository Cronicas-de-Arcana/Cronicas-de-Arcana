package Cartas;
import Controle.*;

public class Feitico extends Carta
{
    protected String efeito;
    protected int cura;
    protected int dano;
    protected String habilidadeEspecial;
    protected double modificadorDano;

    public Feitico(String nome, int custoMana, String habilidadeEspecial, int dano, int cura, double modificadorDano)
    {
        super(nome, custoMana);
        this.efeito = efeito;
        this.dano = dano;
        this.cura = cura;
        this.habilidadeEspecial = habilidadeEspecial;
        this.modificadorDano = modificadorDano;
    }

    public double getModificadorDano()
    {
        return modificadorDano;
    }

    public void jogar()
    {
        System.out.println(getNome() + " foi sumonada no campo de batalha!");
    }

    public void efeito()
    {
        System.out.println("Habilidade especial de " + getNome() + ": " + habilidadeEspecial);
    }

    public void lancarFeiticoCriatura(Criatura alvo)
    {
        if(dano>0)
        {
            System.out.println(getNome() + " foi lançado e causou " + dano + " de dano a " + alvo.getNome());
            alvo.receberDano(dano);
        }
        else if(dano<0)
        {
            System.out.println(getNome() + " foi lançado e curou " + cura + " pontos de vida de " + alvo.getNome());
            alvo.receberCura(cura);
        }
        else if (modificadorDano != 0)
        {
            alvo.setPoder(alvo.getPoder() + modificadorDano);
            String tipo = modificadorDano > 0 ? "aumentou" : "reduziu";
            System.out.println(getNome() + " " + tipo + " o poder de " + alvo.getNome() + " em " + modificadorDano + " pontos.");
        }
    }

    public void lancarFeiticoJogador(Jogador alvo)
    {
        if(dano>0)
        {
            System.out.println(getNome() + " foi lançado e causou " + dano + " de dano a " + alvo.getNome());
            alvo.receberDano(dano);
        }
        else if(dano<0)
        {
            System.out.println(getNome() + " foi lançado e curou " + cura + " pontos de vida de " + alvo.getNome());
            alvo.receberCura(cura);
        }
    }
}
