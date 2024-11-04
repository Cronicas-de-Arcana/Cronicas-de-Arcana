package Espaço;

import Cartas.Carta;

import java.util.ArrayList;
import java.util.List;

public class Cemiterio extends Espaco {

    public Cemiterio()
    {
        this.cartas = new ArrayList<>();
    }

    public void removerCarta(Carta carta)
    {
        //Pensar esse metodo
    }

    public void mostrarCartas(){
        for (int i = 0; i < this.cartas.size(); i++)
        {
            Carta carta = cartas.get(i);
            System.out.println((i + 1) + ": " + carta.getNome() + " - Custo de Mana: " + carta.getCustoMana() + "\n"+carta.getHabilidadeEspecial());
        }
        System.out.println();
    }

    public void adicionarCarta(Carta carta)
    {
        this.cartas.add(carta);
    }

    public  List<Carta> getCartas()
    {
        return this.cartas;
    }
}