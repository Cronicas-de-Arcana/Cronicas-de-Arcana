/*public class Feitiço extends Carta
{
    private String efeito;
    private int cura;
    private int dano;

    public Feitiço(String nome, int custoMana, String efeito, int dano, int cura)
    {
        super(nome, custoMana);
        this.efeito = efeito;
        this.dano = dano;
        this.cura = cura;
    }

    public void lancarFeiticoDano(Jogador alvo)
    {
        if(dano>0)
        {
        System.out.println(getNome() + " foi lançado e causou " + dano + " de dano a " + alvo.getNome());
        alvo.receberDano(dano);
        }
    }

    public void lancarFeiticoCura(Jogador alvo)
    {
        System.out.println(getNome() + " foi lançado e curou " + cura + " pontos de vida de " + alvo.getNome());
        alvo.receberCura(cura);
    }

    public void lancarFeitico(Jogador alvo)
    {
        if (dano > 0)
        {
            lancarFeiticoDano(alvo);
        }
        else if (cura > 0)
        {
            lancarFeiticoCura(alvo);
        }
    }
}*/
