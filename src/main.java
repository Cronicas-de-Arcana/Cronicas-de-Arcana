public class main
{
    public static void main(String[] args)
    {
        Deck deckJogador1 = new Deck();
        deckJogador1.adicionarCarta(new Criatura(35,"Goblin",3, 10,2.5,25,"Ataques rápidos"));

        deckJogador1.adicionarCarta(new Feitico("Raio",3,"Um pequeno raio cai do céu infligindo dano à qualquer tipo de tropa(voadora ou terrestre)",15,0));

        deckJogador1.adicionarCarta(new Encantamento("Poção",4,"Uma poção mágica desenvolvida pelo antigo mago Ryze capaz de recuperar pequenas quantidades de vida em um curto período de tempo",2,0,10));
        for (int i = 0; i < 13; i++)
        {
            deckJogador1.adicionarCarta(new Criatura(10,"Clones",2, 10,1,10,"Simples clones de soldados que já foram derrotados."));
        }

        Deck deckJogador2 = new Deck();
        deckJogador2.adicionarCarta(new Criatura(25,"Arqueiro",3, 20,1.2,15,"Ataques que atacam tropas voadoras."));

        deckJogador2.adicionarCarta(new Feitico("Smite", 2, "Feitiço direcionado à unidade que causa dano verdadeiro à tropa.",10, 0));

        deckJogador2.adicionarCarta(new Encantamento("Ignite", 3, "É o encantamento de atear fogo em seu inimigo, lhe causando dano durante um curto período de tempo", 2,12,0));

        for (int i = 0; i < 12; i++)
        {
            deckJogador2.adicionarCarta(new Criatura(10,"Soldados de areia",2, 10,1,10,"Simples soldados que obedecem fielmente ao antigo rei Azir."));
        }

        Jogador jogador1 = new Jogador("K1ngz",deckJogador1,100,10,3);
        Jogador jogador2 = new Jogador("Will", deckJogador2, 100,10,3);

        Jogo jogo = new Jogo(jogador1, jogador2);
        jogo.iniciar();
    }
}