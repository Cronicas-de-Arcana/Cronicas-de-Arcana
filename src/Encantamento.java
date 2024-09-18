public class Encantamento extends Carta
{
    private String efeitoContinuo;
    private int quantidadeRodadas;
    private int cura;
    private int dano;

    public Encantamento(String nome, int custoMana, String efeitoContinuo, int quantidadeRodadas ,int dano, int cura)
    {
        super(nome, custoMana);
        this.efeitoContinuo = efeitoContinuo;
        this.quantidadeRodadas = quantidadeRodadas;
        this.cura = cura;
        this.dano = dano;
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

    public void lancarFeiticoDano(Jogador alvo)
    {
        int i;
        for(i = 0 ; i < quantidadeRodadas; i++)
        {
            if (dano > 0)
            {
                System.out.println(getNome() + " foi lançado e causou " + dano + " de dano a " + alvo.getNome());
                alvo.receberDano(dano);
            }
        }
    }

    public void lancarFeiticoCura(Jogador alvo)
    {
        int i;
        for(i = 0 ; i < quantidadeRodadas; i++)
        {
            if (cura > 0)
            {
                System.out.println(getNome() + " foi lançado e curou " + cura + " pontos de vida de " + alvo.getNome());
                alvo.receberCura(cura);
            }
        }
    }

    public void lançarFeitiço(Jogador alvo)
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
}
