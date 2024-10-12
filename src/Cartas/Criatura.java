package Cartas;

public class Criatura extends Carta
{
    protected int hp;
    protected int resistencia;
    protected String habilidadeEspecial;
    protected double poder;
    protected double forca;
    private boolean voa;

    public Criatura(int hp, String nome, int custoMana, double poder, double forca, int resistencia, String habilidadeEspecial, boolean voa)
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

    public double getForca()
    {
        return forca;
    }

    public boolean getVoa()
    {
        return voa;
    }

    public void setVoa(boolean voa)
    {
        this.voa = voa;
    }

    public void jogar()
    {
        System.out.println(getNome() + " foi sumonada no campo de batalha!");
    }

    public void efeito()
    {
        System.out.println("Habilidade especial de " + getNome() + ": " + habilidadeEspecial);
    }

    public void atacar(Criatura alvo)
    {
        if (this.voa)
        {
            System.out.println(getNome() + " ataca " + alvo.getNome() + " pelo ar causando " + poder*forca + " de dano.");
        } else {
            System.out.println(getNome() + " ataca " + alvo.getNome() + " causando " + poder*forca + " de dano.");
        }
        System.out.println(getNome() + " ataca " + alvo.getNome() + " causando " + poder*forca + " de dano.");
        alvo.receberDano((int) (poder*forca));
    }

    public void receberDano(int dano)
    {
        resistencia -= dano;
        System.out.println(getNome() + " recebeu " + dano + " de dano. Resistência atual: " + resistencia);
        if (resistencia <= 0)
        {
            hp += resistencia;
            if (hp <= 0)
            {
                System.out.println(getNome() + " foi abatido!");
            }
        }
    }

    public void receberCura(int cura)
    {
        this.hp += cura;
        System.out.println(getNome() + " se curou em " + cura + " pontos de vida. Vida atual: " + this.hp);
    }

    public void criaturasPadrao(){
        Criatura goblin = new Criatura(120, "Goblin", 2, 4.5, 9, 80, "Ataques sucessivos",false);
        Criatura mago = new Criatura(200, "Mago", 3, 13, 4, 100, "Ataques de bola de fogo",false);
        Criatura arqueiro = new Criatura (95, "Arqueiro", 2, 8, 8, 80, "Ataques a longa distância com dano e penetração altos.",false);
        Criatura dragaoGuerreiro = new Criatura (105, "Dragão guerreiro", 6, 20, 12, 120, "Ataques pelo ar.",true);
    }
}
