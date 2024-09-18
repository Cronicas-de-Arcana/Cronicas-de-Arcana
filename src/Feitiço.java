public class Feitiço extends Carta
{
    private String efeito;
    private int cura;
    private int dano;
    private String habilidadeEspecial;

    public Feitiço(String nome, int custoMana, String habilidadeEspecial, int dano, int cura)
    {
        super(nome, custoMana);
        this.efeito = efeito;
        this.dano = dano;
        this.cura = cura;
        this.habilidadeEspecial = habilidadeEspecial;
    }

    public void jogar()
    {
        System.out.println(getNome() + " foi sumonada no campo de batalha!");
    }

    public void efeito()
    {
        System.out.println("Habilidade especial de " + getNome() + ": " + habilidadeEspecial);
    }

    public void lancarFeiticoDanoFeitico(Jogador alvo)
    {
        if(dano>0)
        {
        System.out.println(getNome() + " foi lançado e causou " + dano + " de dano a " + alvo.getNome());
        alvo.receberDano(dano);
        }
    }

    public void lancarFeiticoCuraFeitico(Jogador alvo)
    {
        System.out.println(getNome() + " foi lançado e curou " + cura + " pontos de vida de " + alvo.getNome());
        alvo.receberCura(cura);
    }

    public void lancarFeitico(Jogador alvo)
    {
        if (dano > 0)
        {
            lancarFeiticoDanoFeitico(alvo);
        }
        else if (cura > 0)
        {
            lancarFeiticoCuraFeitico(alvo);
        }
    }
}
