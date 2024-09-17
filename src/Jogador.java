public class Jogador
{
    private String nome;
    private int hp;
    private int mana;
    private int manaAtual;

    public Jogador(String nome, int hp, int mana)
    {
        this.nome = nome;
        this.hp = hp;
        this.mana = mana;
        this.manaAtual = 3;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getMana()
    {
        return mana;
    }

    public int getManaAtual()
    {
        return manaAtual;
    }

    public void receberDano(int dano)
    {
        this.hp -= dano;
        if (this.hp <= 0)
        {
            System.out.println(getNome() + " foi derrotado!");
        }
        else
        {
            System.out.println(getNome() + " recebeu " + dano + " de dano. HP restante: " + this.hp);
        }
    }

    public void receberCura(int cura) {
        this.hp += cura;
        System.out.println(nome + " foi curado em " + cura + " pontos de vida. Vida atual: " + this.hp);
    }

    public void adicionarMana()
    {
        this.manaAtual++;
    }

    public void utilizarMana(int custoMana)
    {
        this.manaAtual -= custoMana;
    }
}
