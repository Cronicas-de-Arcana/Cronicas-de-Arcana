package Cartas;

import Espaço.Cemiterio;

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

    public void mostrarCaracteristicas()
    {
        System.out.println("Nome: " + nome);
        System.out.println("Custo Mana: " + custoMana);
    }

    public abstract void efeito();

    public abstract void jogar();
}
