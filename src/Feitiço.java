public class Feitiço extends Carta
{
    public String efeito;
    public int cura;
    public int dano;

    public Feitiço(String nome, int custoMana, String efeito, int dano, int cura)
    {
        super(nome, custoMana);
        this.efeito = efeito;
        this.dano = dano;
        this.cura = cura;
    }

    public void lançarFeitiçoDano(Jogador alvo)
    {
        if(dano>0)
        {
        System.out.println(getNome() + " foi lançado e causou " + dano + " de dano a " + alvo.getNome());
        alvo.receberDano(dano);
        }
    }

    public void lancarFeitiçoCura(Jogador alvo)
    {
        System.out.println(getNome() + " foi lançado e curou " + cura + " pontos de vida de " + alvo.getNome());
        alvo.receberCura(cura);
    }

    public void lançarFeitiço(Jogador alvo)
    {
        if (dano > 0)
        {
            lançarFeitiçoDano(alvo);
        }
        else if (cura > 0)
        {
            lancarFeitiçoCura(alvo);
        }
    }
}
