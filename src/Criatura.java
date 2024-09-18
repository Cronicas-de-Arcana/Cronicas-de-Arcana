public class Criatura extends Carta
{
    private int hp;
    private int resistencia;
    private String habilidadeEspecial;
    private int poder;
    private int forca;

    public Criatura(int hp, String nome, int custoMana, int poder, int resistencia, String habilidadeEspecial)
    {
        super(nome, custoMana);
        this.hp = hp;
        this.resistencia = resistencia;
        this.habilidadeEspecial = habilidadeEspecial;
        this.poder = poder;
        this.forca = forca;
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

    public int getPoder()
    {
        return poder;
    }

    public int getForca()
    {
        return forca;
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
        System.out.println(getNome() + " ataca " + alvo.getNome() + " causando " + poder*forca + " de dano");
        alvo.receberDano(poder*forca);
    }

    public void receberDano(int dano)
    {
        resistencia -= dano;
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
}