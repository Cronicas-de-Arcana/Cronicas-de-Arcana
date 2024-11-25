package Cartas;
import Controle.Jogador;
import Espaço.Cemiterio;
import Espaço.CampodeBatalha;

import javax.swing.*;

public class Criatura extends Carta
{
    protected int hp;
    protected int resistencia;
    protected int poder;
    protected boolean voa;

    public Criatura(int hp, String nome, int custoMana, int poder, int resistencia, String habilidadeEspecial, boolean voa)
    {
        super(nome, custoMana);
        this.hp = hp;
        this.resistencia = resistencia;
        this.habilidadeEspecial = habilidadeEspecial;
        this.poder = poder;
        this.voa = voa;
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

    public void setPoder(double valor)
    {

    }

    public boolean Voa()
    {
        return voa;
    }

    public void receberDano(int dano)
    {
        int danoAbsorvido = Math.min(dano, resistencia);
        resistencia -= danoAbsorvido;
        JOptionPane.showMessageDialog(null, getNome() + " recebeu " + dano + " de dano. Dano absorvido pela resistência: " + danoAbsorvido + ". Resistência atual: " + resistencia);

        if (resistencia <= 0)
        {
            int danoRestante = dano - danoAbsorvido;
            hp -= danoRestante;

            if (hp <= 0)
            {
                JOptionPane.showMessageDialog(null, getNome() + " foi abatido!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, getNome() + " recebeu " + danoRestante + " de dano. HP atual: " + hp);
            }
        }
    }


    public void atacarCriatura(Criatura criaturaAlvo)
    {
        if (this.voa)
        {
            JOptionPane.showMessageDialog(null, getNome() + " ataca " + criaturaAlvo.getNome() + " pelo ar causando " + poder + " de dano.", "Ataque Aéreo", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, getNome() + " ataca diretamente " + criaturaAlvo.getNome() + ", causando " + poder + " de dano.", "Ataque Direto", JOptionPane.INFORMATION_MESSAGE);

        }
        criaturaAlvo.receberDano((int) (poder));
    }

    public void atacarJogador(Jogador jogadorAlvo)
    {
        if (this.voa)
        {
            System.out.println(getNome() + " ataca " + jogadorAlvo.getNome() + " pelo ar causando " + poder + " de dano.");
        }
        else
        {
            System.out.println(getNome() + " ataca diretamente o jogador " + jogadorAlvo.getNome() + ", causando " + poder + " de dano.");
        }
        jogadorAlvo.receberDano(poder);
    }

    public void receberCura(int cura)
    {
        this.hp += cura;
        System.out.println(getNome() + " se curou em " + cura + " pontos de vida. Vida atual: " + this.hp);
    }
}
