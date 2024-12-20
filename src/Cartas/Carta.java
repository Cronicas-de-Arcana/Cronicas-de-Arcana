package Cartas;

public abstract class Carta
{
    protected String nome;
    protected int custoMana;
    protected String habilidadeEspecial;

    public Carta(String nome, int custoMana)
    {
        this.nome = nome;
        this.custoMana = custoMana;
    }

    public int getCustoMana()
    {
        return custoMana;
    }

    public String getNome()
    {
        return nome;
    }

    public String getHabilidadeEspecial() {
        return habilidadeEspecial;
    }
}
