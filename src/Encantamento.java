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

    public void lancarFeitico(Jogador alvo)
    {
        for (int i = 0; i < quantidadeRodadas; i++) {
            if (dano > 0) {
                System.out.println(getNome() + " causou " + dano + " de dano a " + alvo.getNome());
                alvo.receberDano(dano);
            } else if (cura > 0) {
                System.out.println(getNome() + " curou " + cura + " pontos de vida de " + alvo.getNome());
                alvo.receberCura(cura);
            }
        }
    }
}
