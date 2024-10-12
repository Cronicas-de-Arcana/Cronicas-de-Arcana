package Cartas;

public abstract class Carta
{
    protected String nome;
    protected int custoMana;

    public Carta(String nome, int custoMana)
    {
        this.nome = nome;
        this.custoMana = custoMana;
    }

    public String getNome()
    {
        return nome;
    }

    public int getCustoMana()
    {
        return custoMana;
    }

    public abstract void efeito();

    public abstract void jogar();
}