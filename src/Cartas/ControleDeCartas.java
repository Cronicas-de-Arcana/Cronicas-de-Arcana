package Cartas;

import java.util.ArrayList;

public class ControleDeCartas {

    //Podemos tornar esses decks decks padrão dos jogadores
    public ArrayList <Carta> inicializadorCartasJ1(){
        ArrayList<Carta> deckPadraoJ1 = new ArrayList<>();

        Criatura goblin = new Criatura(120, "Goblin", 2, 90, 45, 9, "Ataques sucessivos",false);
        deckPadraoJ1.add(goblin);
        Criatura serpenteDoCaos = new Criatura(130, "Serpente do Caos", 5, 120, 80, 10, "Veneno: Aplica envenenamento por 2 rodadas", false);
        deckPadraoJ1.add(serpenteDoCaos);
        Criatura elfoArqueiro = new Criatura(90, "Elfo Arqueiro", 3, 110, 60, 8, "Tiro Preciso: Causa dano adicional a criaturas voadoras", false);
        deckPadraoJ1.add(elfoArqueiro);
        Criatura minotauroSelvagem = new Criatura(160, "Minotauro Selvagem", 6, 130, 140, 12, "Investida: Dano dobrado no primeiro ataque", false);
        deckPadraoJ1.add(minotauroSelvagem);
        Criatura zumbiDespedaçado = new Criatura(100, "Zumbi Despedaçado", 3, 80, 60, 10, "Imortalidade: Quando destruído, volta ao jogo com metade da vida", false);
        deckPadraoJ1.add(zumbiDespedaçado);
        Criatura espectroDaNoite = new Criatura(110, "Espectro da Noite", 4, 120, 70, 7, "Assombrar: Reduz o poder da criatura inimiga em 20%", true);
        deckPadraoJ1.add(espectroDaNoite);
        Criatura treantProtetor = new Criatura(200, "Treant Protetor", 7, 80, 160, 14, "Regeneração: Recupera 30 de vida a cada rodada", false);
        deckPadraoJ1.add(treantProtetor);
        Criatura hidraDeMultiplasCabecas = new Criatura(180, "Hidra de Múltiplas Cabeças", 7, 170, 150, 12, "Regeneração de Cabeças: Ao ser atacada, uma cabeça adicional cresce aumentando seu poder", false);
        deckPadraoJ1.add(hidraDeMultiplasCabecas);
        Criatura aranhaGigante = new Criatura(90, "Aranha Gigante", 4, 100, 70, 8, "Teia: Imobiliza uma criatura por 1 rodada", false);
        deckPadraoJ1.add(aranhaGigante);

        Feitico explosaoDeGelo = new Feitico("Explosão de Gelo", 4, "Congela as criaturas inimigas por 1 rodada e causa dano", 10, 0, 0);
        deckPadraoJ1.add(explosaoDeGelo);
        Feitico chuvaDeFogo = new Feitico("Chuva de Fogo", 5, "Causa dano em todas as criaturas inimigas", 20, 0, 0);
        deckPadraoJ1.add(chuvaDeFogo);
        Feitico raio = new Feitico("Raio", 3, "Um pequeno raio cai do céu infligindo dano à qualquer tipo de tropa(voadora ou terrestre)", 15, 0, 0);
        deckPadraoJ1.add(raio);

        Encantamento auraDeCura = new Encantamento("Aura de Cura", 4, "Recupera 20 de vida de todas as suas criaturas a cada rodada", 3, 0, 20, 0);
        deckPadraoJ1.add(auraDeCura);
        Encantamento escudoDeMana = new Encantamento("Escudo de Mana", 3, "Cria um escudo que absorve 30 de dano de todas as suas criaturas", 2, 0, 0, -30);
        deckPadraoJ1.add(escudoDeMana);
        Encantamento pocao = new Encantamento("Poção", 4, "Uma poção mágica desenvolvida pelo antigo mago Ryze capaz de recuperar pequenas quantidades de vida em um curto período de tempo", 2, 0, 10, 0);
        deckPadraoJ1.add(pocao);

        return deckPadraoJ1;
    }

    public ArrayList<Carta> inicializadorCartasJ2(){
        ArrayList <Carta> deckPadraoJ2 = new ArrayList<>();

        Criatura mago = new Criatura(200, "Mago", 3, 130, 100, 10, "Ataques de bola de fogo", false);
        deckPadraoJ2.add(mago);
        Criatura arqueiro = new Criatura(95, "Arqueiro", 2, 200, 120, 8, "Ataques a longa distância com dano e penetração altos.", false);
        deckPadraoJ2.add(arqueiro);
        Criatura fenixArdente = new Criatura(150, "Fênix Ardente", 6, 150, 90, 10, "Ressurreição: Revive uma vez após ser destruída", true);
        deckPadraoJ2.add(fenixArdente);
        Criatura golemDePedra = new Criatura(250, "Golem de Pedra", 8, 100, 200, 15, "Impenetrável: Reduz dano recebido em 30%", false);
        deckPadraoJ2.add(golemDePedra);
        Criatura demonioDasSombras = new Criatura(135, "Demônio das Sombras", 5, 140, 70, 9, "Camuflagem: Não pode ser atacado por 2 rodadas", true);
        deckPadraoJ2.add(demonioDasSombras);
        Criatura fadaCurandeira = new Criatura(75, "Fada Curandeira", 4, 0, 50, 6, "Cura: Recupera 50 de vida de um aliado", true);
        deckPadraoJ2.add(fadaCurandeira);
        Criatura giganteDaMontanha = new Criatura(220, "Gigante da Montanha", 7, 160, 180, 13, "Pisada: Dano em área a criaturas terrestres", false);
        deckPadraoJ2.add(giganteDaMontanha);
        Criatura cavaleiroEspectral = new Criatura(150, "Cavaleiro Espectral", 6, 140, 100, 10, "Carga Sombria: Dano dobrado ao atacar criaturas de luz", false);
        deckPadraoJ2.add(cavaleiroEspectral);
        Criatura gargulaDePedra = new Criatura(110, "Gárgula de Pedra", 5, 120, 90, 9, "Escudo de Pedra: Reduz dano de ataques físicos em 25%", true);
        deckPadraoJ2.add(gargulaDePedra);

        Feitico bolaDeFogo = new Feitico("Bola de Fogo", 3, "Causa grande dano a uma única criatura inimiga", 25, 0, 0);
        deckPadraoJ2.add(bolaDeFogo);
        Feitico tornado = new Feitico("Tornado", 4, "Ataca todas os tipos de criaturas inimigas e causa dano", 20, 0, 0);
        deckPadraoJ2.add(tornado);
        Feitico smite = new Feitico("Smite", 2, "Feitiço direcionado à unidade que causa dano verdadeiro à tropa.", 10, 0, 0);
        deckPadraoJ2.add(smite);

        Encantamento campoDeForca = new Encantamento("Campo de Força", 5, "Reduz o dano de ataques inimigos em 25 pontos", 3, 0, 0, -25);
        deckPadraoJ2.add(campoDeForca);
        Encantamento maldicaoDaFraqueza = new Encantamento("Maldição da Fraqueza", 4, "Reduz o ataque de todas as criaturas inimigas em 20 pontos", 2, 0, 0, -20);
        deckPadraoJ2.add(maldicaoDaFraqueza);
        Encantamento ignite = new Encantamento("Ignite", 3, "É o encantamento de atear fogo em seu inimigo, lhe causando dano durante um curto período de tempo", 2, 12, 0, 0);
        deckPadraoJ2.add(ignite);

        return deckPadraoJ2;
    }

}
