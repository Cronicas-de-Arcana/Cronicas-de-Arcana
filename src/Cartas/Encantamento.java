package Cartas;
import Controle.Jogador;
import Espaço.Cemiterio;
import Espaço.CampodeBatalha;

public class Encantamento extends Carta
{
    protected int quantidadeRodadas;
    protected int cura;
    protected int dano;
    protected double modificadorDano;
    private Object alvo;

    public Encantamento(String nome, int custoMana, String habilidadeEspecial, int quantidadeRodadas ,int dano, int cura, double modificadorDano)
    {
        super(nome, custoMana);
        this.habilidadeEspecial = habilidadeEspecial;
        this.quantidadeRodadas = quantidadeRodadas;
        this.cura = cura;
        this.dano = dano;
        this.modificadorDano = modificadorDano;
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

    public double getModificadorDano()
    {
        return modificadorDano;
    }

    public Object getAlvo()
    {
        return alvo;
    }

    public void reduzirRodadas()
    {
        quantidadeRodadas--;
    }

    public void lancarEncantamentoCriatura(Criatura alvo)
    {
        this.alvo = alvo;
        if (quantidadeRodadas > 0)
        {
            if (dano > 0)
            {
                System.out.println(getNome() + " causou " + dano + " de dano a " + alvo.getNome() + " por " + quantidadeRodadas + " rodadas.");
                alvo.receberDano(dano);
            }
            else if (cura > 0)
            {
                System.out.println(getNome() + " curou " + cura + " pontos de vida de " + alvo.getNome() + " por " + quantidadeRodadas + " rodadas.");
                alvo.receberCura(cura);
            }
            else if (modificadorDano != 0)
            {
                alvo.setPoder(alvo.getPoder() + modificadorDano);
                String tipo = modificadorDano > 0 ? "aumentou" : "reduziu";
                System.out.println(getNome() + " " + tipo + " o poder de " + alvo.getNome() + " em " + modificadorDano + " por " + quantidadeRodadas + " rodadas.");
            }
        }
    }

    public void lancarEncantamentoJogador(Jogador alvo)
    {
        this.alvo = alvo;
        if (quantidadeRodadas > 0)
        {
            if (dano > 0)
            {
                System.out.println(getNome() + " causou " + dano + " de dano a " + alvo.getNome() + " por " + quantidadeRodadas + " rodadas.");
                alvo.receberDano(dano);
            }
            else if (cura > 0)
            {
                System.out.println(getNome() + " curou " + cura + " pontos de vida de " + alvo.getNome() + " por " + quantidadeRodadas + " rodadas.");
                alvo.receberCura(cura);
            }
            else
            {
                System.out.println("O efeito não pode ser aplicado.");
            }
        }
    }

    public void aplicarEfeito(Object alvo)
    {
        if (alvo instanceof Criatura)
        {
            Criatura criaturaAlvo = (Criatura) alvo;
            this.lancarEncantamentoCriatura(criaturaAlvo);
        }
        else if (alvo instanceof Jogador)
        {
            Jogador jogadorAlvo = (Jogador) alvo;
            this.lancarEncantamentoJogador(jogadorAlvo);
        }
    }

    public void aplicarEfeitoAoCampo(Jogador adversario) {
        // Itera pelas criaturas no campo do adversário
        for (Carta carta : adversario.getCampoDeBatalha().getCampo()) {
            if (carta instanceof Criatura criatura) {
                // Aplica os efeitos de dano, cura ou modificador de dano
                if (dano > 0) {
                    criatura.receberDano(dano);
                    System.out.println(getNome() + " causou " + dano + " de dano a " + criatura.getNome());
                }
                if (cura > 0) {
                    criatura.receberCura(cura);
                    System.out.println(getNome() + " curou " + cura + " pontos de vida de " + criatura.getNome());
                }
                if (modificadorDano != 0) {
                    criatura.setPoder(criatura.getPoder() + modificadorDano);
                    String tipo = (modificadorDano > 0) ? "aumentou" : "reduziu";
                    System.out.println(getNome() + " " + tipo + " o poder de " + criatura.getNome() + " em " + modificadorDano);
                }
            }
        }
    }

}