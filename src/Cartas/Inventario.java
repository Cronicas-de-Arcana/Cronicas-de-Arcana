package Cartas;

import java.util.ArrayList;

public class Inventario
{
    protected ArrayList<Carta> cartasInventario = new ArrayList<>();
    //Array em que vai ficar as cartas que o player vai conquistando ao progredir os niveis
    protected Carta[][] cartasProgresso = new Carta[10][10];

    public Inventario(){
        inicializadorCartasJ1();
        inicializadorCartasJ2();
        inicializarCartasProgresso();
    }

    public ArrayList<Carta> getCartasInventario() {
        return cartasInventario;
    }

    public Carta[][] getCartasProgresso() {
        return cartasProgresso;
    }

    public void inicializarCartasProgresso(){
        cartasProgresso[0][0] = new Criatura(210, "Gigante", 3, 75, 50, 10, "Socos lentos mas fortes", false);
        cartasProgresso[0][1] = new Criatura(120, "Lobisomem", 4, 90, 100, 7, "Arranhões sucessivos.", false);
        //Temos que criar mais cartas nesses Arrays
    }

    public ArrayList <Carta> inicializadorCartasJ1()
    {
        ArrayList<Carta> deckPadraoJ1 = new ArrayList<>();

        Criatura goblin = new Criatura(120, "Goblin", 2, 50, 30, 6, "Ataques sucessivos.", false);
        deckPadraoJ1.add(goblin);

        Criatura serpenteDoCaos = new Criatura(130, "Serpente do Caos", 4, 70, 50, 7, "Veneno: Aplica envenenamento por 2 rodadas.", false);
        deckPadraoJ1.add(serpenteDoCaos);

        Criatura elfoArqueiro = new Criatura(90, "Elfo Arqueiro", 3, 60, 40, 6, "Tiro Preciso: Causa dano adicional a criaturas voadoras.", false);
        deckPadraoJ1.add(elfoArqueiro);

        Criatura minotauroSelvagem = new Criatura(160, "Minotauro Selvagem", 5, 80, 70, 9, "Investida: Dano dobrado no primeiro ataque.", false);
        deckPadraoJ1.add(minotauroSelvagem);

        Criatura zumbiDespedaçado = new Criatura(100, "Zumbi Despedaçado", 2, 50, 30, 8, "Imortalidade: Quando destruído, volta ao jogo com metade da vida.", false);
        deckPadraoJ1.add(zumbiDespedaçado);

        Criatura espectroDaNoite = new Criatura(110, "Espectro da Noite", 4, 70, 50, 5, "Assombrar: Reduz o poder da criatura inimiga em 20%.", true);
        deckPadraoJ1.add(espectroDaNoite);

        Criatura treantProtetor = new Criatura(200, "Treant Protetor", 6, 60, 100, 10, "Regeneração: Recupera 20 de vida a cada rodada.", false);
        deckPadraoJ1.add(treantProtetor);

        Criatura hidraDeMultiplasCabecas = new Criatura(180, "Hidra de Múltiplas Cabeças", 6, 90, 100, 8, "Regeneração de Cabeças: Ao ser atacada, uma cabeça adicional cresce aumentando seu poder.", false);
        deckPadraoJ1.add(hidraDeMultiplasCabecas);

        Criatura aranhaGigante = new Criatura(90, "Aranha Gigante", 3, 50, 40, 6, "Teia: Imobiliza uma criatura por 1 rodada.", false);
        deckPadraoJ1.add(aranhaGigante);

        Feitico explosaoDeGelo = new Feitico("Explosão de Gelo", 3, "Congela as criaturas inimigas por 1 rodada e causa dano.", 8, 0, 0);
        deckPadraoJ1.add(explosaoDeGelo);

        Feitico chuvaDeFogo = new Feitico("Chuva de Fogo", 4, "Causa dano em todas as criaturas inimigas.", 10, 0, 0);
        deckPadraoJ1.add(chuvaDeFogo);

        Feitico raio = new Feitico("Raio", 3, "Um pequeno raio que inflige dano a qualquer tropa.", 10, 0, 0);
        deckPadraoJ1.add(raio);

        Encantamento auraDeCura = new Encantamento("Aura de Cura", 3, "Recupera 10 de vida de todas as suas criaturas a cada rodada.", 3, 0, 10, 0);
        deckPadraoJ1.add(auraDeCura);

        Encantamento escudoDeMana = new Encantamento("Escudo de Mana", 2, "Cria um escudo que absorve 15 de dano de todas as suas criaturas.", 2, 0, 0, -15);
        deckPadraoJ1.add(escudoDeMana);

        Encantamento pocao = new Encantamento("Poção", 3, "Poção que recupera pequenas quantidades de vida rapidamente.", 2, 0, 8, 0);
        deckPadraoJ1.add(pocao);

        return deckPadraoJ1;
    }

    public ArrayList<Carta> inicializadorCartasJ2()
    {
        ArrayList<Carta> deckPadraoJ2 = new ArrayList<>();

        Criatura mago = new Criatura(120, "Mago", 3, 70, 50, 7, "Ataques de bola de fogo.", false);
        deckPadraoJ2.add(mago);

        Criatura arqueiro = new Criatura(95, "Arqueiro", 2, 60, 40, 6, "Ataques à distância com alto dano.", false);
        deckPadraoJ2.add(arqueiro);

        Criatura fenixArdente = new Criatura(150, "Fênix Ardente", 5, 80, 60, 8, "Ressurreição: Revive uma vez após ser destruída.", true);
        deckPadraoJ2.add(fenixArdente);

        Criatura golemDePedra = new Criatura(250, "Golem de Pedra", 7, 70, 120, 10, "Impenetrável: Reduz dano recebido em 30%.", false);
        deckPadraoJ2.add(golemDePedra);

        Criatura demonioDasSombras = new Criatura(135, "Demônio das Sombras", 4, 70, 50, 7, "Camuflagem: Não pode ser atacado por 2 rodadas.", true);
        deckPadraoJ2.add(demonioDasSombras);

        Criatura fadaCurandeira = new Criatura(75, "Fada Curandeira", 3, 0, 30, 5, "Cura: Recupera 50 de vida de um aliado.", true);
        deckPadraoJ2.add(fadaCurandeira);

        Criatura giganteDaMontanha = new Criatura(220, "Gigante da Montanha", 6, 100, 120, 10, "Pisada: Dano em área a criaturas terrestres.", false);
        deckPadraoJ2.add(giganteDaMontanha);

        Criatura cavaleiroEspectral = new Criatura(150, "Cavaleiro Espectral", 5, 90, 80, 8, "Carga Sombria: Dano dobrado ao atacar criaturas de luz.", false);
        deckPadraoJ2.add(cavaleiroEspectral);

        Criatura gargulaDePedra = new Criatura(110, "Gárgula de Pedra", 4, 60, 50, 6, "Escudo de Pedra: Reduz dano de ataques físicos em 25%.", true);
        deckPadraoJ2.add(gargulaDePedra);

        Feitico bolaDeFogo = new Feitico("Bola de Fogo", 3, "Causa grande dano a uma única criatura inimiga.", 15, 0, 0);
        deckPadraoJ2.add(bolaDeFogo);

        Feitico tornado = new Feitico("Tornado", 4, "Ataca todos os tipos de criaturas inimigas e causa dano.", 10, 0, 0);
        deckPadraoJ2.add(tornado);

        Feitico smite = new Feitico("Smite", 2, "Feitiço que causa dano verdadeiro a uma unidade.", 8, 0, 0);
        deckPadraoJ2.add(smite);

        Encantamento campoDeForca = new Encantamento("Campo de Força", 4, "Reduz o dano de ataques inimigos em 15 pontos.", 3, 0, 0, -15);
        deckPadraoJ2.add(campoDeForca);

        Encantamento maldicaoDaFraqueza = new Encantamento("Maldição da Fraqueza", 3, "Reduz o ataque de todas as criaturas inimigas em 10 pontos.", 2, 0, 0, -10);
        deckPadraoJ2.add(maldicaoDaFraqueza);

        Encantamento ignite = new Encantamento("Ignite", 3, "Inflige dano contínuo ao inimigo.", 2, 8, 0, 0);
        deckPadraoJ2.add(ignite);

        return deckPadraoJ2;
    }
}
