package Cartas;

public class Criatura extends Carta
{
    protected int hp;
    protected int resistencia;
    protected String habilidadeEspecial;
    protected double poder;
    protected double forca;
    protected boolean voa;

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

    public boolean Voa() {
        return voa;
    }

    public void setVoa(boolean voa) {
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

    public void atacar(Criatura criaturaAlvo) {
        if (this.voa) {
            System.out.println(getNome() + " ataca " + criaturaAlvo.getNome() + " pelo ar causando " + forca * poder + " de dano.");
        } else {
            System.out.println(getNome() + " ataca diretamente o jogador " + criaturaAlvo.getNome() + ", causando " + forca * poder + " de dano.");
        }
        criaturaAlvo.receberDano((int) (forca * poder));
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
        Criatura goblin = new Criatura(120, "Goblin", 2, 90, 45, 9, "Ataques sucessivos",false);
        Criatura mago = new Criatura(200, "Mago", 3, 130, 100, 10, "Ataques de bola de fogo",false);
        Criatura arqueiro = new Criatura (95, "Arqueiro", 2, 200, 120, 8, "Ataques a longa distância com dano e penetração altos.",false);
    }
}
