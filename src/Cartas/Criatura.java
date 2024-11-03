package Cartas;
import Controle.Jogador;

public class Criatura extends Carta
{
    protected int hp;
    protected int resistencia;
    protected double poder;
    protected double forca;
    protected boolean voa;

    public Criatura(int hp, String nome, int custoMana, double poder, int resistencia, String habilidadeEspecial, boolean voa)
    {
        super(nome, custoMana);
        this.hp = hp;
        this.resistencia = resistencia;
        this.habilidadeEspecial = habilidadeEspecial;
        this.poder = poder;
        this.forca = forca;
        this.voa = voa;
    }

    public int getHP()
    {
        return hp;
    }

    public int getResistencia()
    {
        return resistencia;
    }

    public String getHabilidadeEspecial()
    {
        return habilidadeEspecial;
    }

    public double getPoder()
    {
        return poder;
    }

    public void setPoder(double valor)
    {

    }

    public double getForca()
    {
        return forca;
    }

    public boolean Voa()
    {
        return voa;
    }

    public void setVoa(boolean voa)
    {
        this.voa = voa;
    }

    public void receberDano(int dano)
    {
        int danoAbsorvido = Math.min(dano, resistencia);
        resistencia -= danoAbsorvido;
        System.out.println(getNome() + " recebeu " + dano + " de dano. Dano absorvido pela resistência: " + danoAbsorvido + ". Resistência atual: " + resistencia);

        if (resistencia <= 0)
        {
            // Dano que excedeu a resistência
            int danoRestante = dano - danoAbsorvido;
            hp -= danoRestante;

            if (hp <= 0)
            {
                System.out.println(getNome() + " foi abatido!");
            }
            else
            {
                System.out.println(getNome() + " recebeu " + danoRestante + " de dano. HP atual: " + hp);
            }
        }
    }

    public void atacarCriatura(Criatura criaturaAlvo)
    {
        if (this.voa)
        {
            System.out.println(getNome() + " ataca " + criaturaAlvo.getNome() + " pelo ar causando " + forca * poder + " de dano.");
        }
        else
        {
            System.out.println(getNome() + " ataca diretamente o jogador " + criaturaAlvo.getNome() + ", causando " + forca * poder + " de dano.");
        }
        criaturaAlvo.receberDano((int) (forca * poder));
    }

    public void atacarJogador(Jogador jogadorAlvo)
    {
        if (this.voa)
        {
            System.out.println(getNome() + " ataca " + jogadorAlvo.getNome() + " pelo ar causando " + forca * poder + " de dano.");
        }
        else
        {
            System.out.println(getNome() + " ataca diretamente o jogador " + jogadorAlvo.getNome() + ", causando " + forca * poder + " de dano.");
        }
        jogadorAlvo.receberDano((int) (forca * poder));
    }

    public void receberCura(int cura)
    {
        this.hp += cura;
        System.out.println(getNome() + " se curou em " + cura + " pontos de vida. Vida atual: " + this.hp);
    }

    //Decidir se devemos manter esse metodo
    public void efeito()
    {
        System.out.println("Habilidade especial de " + getNome() + ": " + habilidadeEspecial);
    }

    public void criaturasPadrao()
    {
        Criatura goblin = new Criatura(120, "Goblin", 2, 9, 90, "Ataques sucessivos",false);
        Criatura mago = new Criatura(150, "Mago", 3, 13, 100, "Ataques de bola de fogo",false);
        Criatura arqueiro = new Criatura (95, "Arqueiro", 2, 20, 80, "Ataques a longa distância com dano e penetração altos.",false);
    }


}
