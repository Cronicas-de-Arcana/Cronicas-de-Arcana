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
        cartasProgresso[0][0] = new Criatura(210, "Gigante", 3, 25, 100, "Socos lentos mas fortes", false);
        cartasProgresso[0][1] = new Criatura(150, "Lobisomem", 4, 30, 70, "Arranhões sucessivos.", false);
        //Temos que criar mais cartas nesses Arrays
    }

    public ArrayList<Carta> inicializadorCartasJ1() {
        ArrayList<Carta> deckPadraoJ1 = new ArrayList<>();

        deckPadraoJ1.add(new Criatura(120, "Goblin", 2, 50, 30, "Ataques sucessivos.", false));
        deckPadraoJ1.add(new Criatura(130, "Serpente do Caos", 4, 70, 50, "Veneno: Aplica envenenamento por 2 rodadas.", false));
        deckPadraoJ1.add(new Criatura(90, "Elfo Arqueiro", 3, 60, 40, "Tiro Preciso: Causa dano adicional a criaturas voadoras.", false));
        deckPadraoJ1.add(new Criatura(160, "Minotauro Selvagem", 5, 80, 70, "Investida: Dano dobrado no primeiro ataque.", false));
        deckPadraoJ1.add(new Criatura(100, "Zumbi Despedaçado", 2, 50, 30, "Imortalidade: Quando destruído, volta ao jogo com metade da vida.", false));
        deckPadraoJ1.add(new Criatura(110, "Espectro da Noite", 4, 70, 50, "Assombrar: Reduz o poder da criatura inimiga em 20%.", true));
        deckPadraoJ1.add(new Criatura(200, "Treant Protetor", 6, 60, 100, "Regeneração: Recupera 20 de vida a cada rodada.", false));
        deckPadraoJ1.add(new Criatura(180, "Hidra de Múltiplas Cabeças", 6, 90, 100, "Regeneração de Cabeças: Ao ser atacada, uma cabeça adicional cresce aumentando seu poder.", false));
        deckPadraoJ1.add(new Criatura(90, "Aranha Gigante", 3, 50, 40, "Teia: Imobiliza uma criatura por 1 rodada.", false));
        deckPadraoJ1.add(new Criatura(130, "Lobisomem Furioso", 3, 75, 50, "Fúria Lunar: Ganha +5 de ataque à noite.", false));
        deckPadraoJ1.add(new Criatura(180, "Dragão de Lava", 6, 85, 100, "Queimadura: Causa 5 de dano por rodada a quem o atacar.", true));
        deckPadraoJ1.add(new Criatura(110, "Orc Berserker", 2, 65, 40, "Enfurecido: Ganha +2 de ataque após cada ataque.", false));
        deckPadraoJ1.add(new Criatura(90, "Sátiro Ilusório", 3, 50, 30, "Desviar: Chance de evitar ataques diretos.", false));
        deckPadraoJ1.add(new Criatura(160, "Manticora Assassina", 5, 80, 90, "Ataque Venenoso: Aplica veneno ao inimigo.", true));
        deckPadraoJ1.add(new Criatura(110, "Guardião das Sombras", 4, 70, 60, "Escuridão: Reduz ataque inimigo em 5 ao atacá-lo.", true));
        deckPadraoJ1.add(new Criatura(100, "Leopardo Alado", 3, 60, 30, "Aperto Rápido: Dano adicional em criaturas lentas.", true));
        deckPadraoJ1.add(new Criatura(150, "Ogros de Batalha", 5, 70, 80, "Força Bruta: Ignora 10 de defesa inimiga.", false));
        deckPadraoJ1.add(new Criatura(200, "Elemental da Terra", 6, 60, 100, "Resistência Natural: Reduz dano físico recebido em 10.", false));
        deckPadraoJ1.add(new Criatura(80, "Assassino Fantasma", 2, 60, 30, "Ataque Sorrateiro: Ataca antes de oponente com velocidade menor.", true));

        deckPadraoJ1.add(new Feitico("Explosão de Gelo", 3, "Congela as criaturas inimigas por 1 rodada e causa dano.", 8, 0, 0));
        deckPadraoJ1.add(new Feitico("Chuva de Fogo", 4, "Causa dano em todas as criaturas inimigas.", 10, 0, 0));
        deckPadraoJ1.add(new Feitico("Raio", 3, "Um pequeno raio que inflige dano a qualquer tropa.", 10, 0, 0));
        deckPadraoJ1.add(new Feitico("Explosão Arcana", 3, "Dano mágico em área.", 12, 0, 0));
        deckPadraoJ1.add(new Feitico("Chamas Místicas", 4, "Causa grande dano a uma criatura inimiga.", 15, 0, 0));
        deckPadraoJ1.add(new Feitico("Toque Curativo", 2, "Recupera vida de uma criatura aliada.", 0, 10, 0));
        deckPadraoJ1.add(new Feitico("Maldade Incandescente", 5, "Dano mágico alto.", 18, 0, 0));
        deckPadraoJ1.add(new Feitico("Erupção Sombria", 4, "Dano médio em todos os inimigos.", 14, 0, 0));

        deckPadraoJ1.add(new Encantamento("Aura de Cura", 3, "Recupera 10 de vida de todas as suas criaturas a cada rodada.", 3, 0, 10, 0));
        deckPadraoJ1.add(new Encantamento("Escudo de Mana", 2, "Cria um escudo que absorve 15 de dano de todas as suas criaturas.", 2, 0, 0, -15));
        deckPadraoJ1.add(new Encantamento("Poção", 3, "Poção que recupera pequenas quantidades de vida rapidamente.", 2, 0, 8, 0));
        deckPadraoJ1.add(new Encantamento("Escudo Sombrio", 3, "Reduz o dano recebido em 8 pontos.", 3, 0, 0, -8));
        deckPadraoJ1.add(new Encantamento("Bênção da Vida", 2, "Recupera 8 de vida a cada rodada.", 2, 0, 8, 0));
        deckPadraoJ1.add(new Encantamento("Aura Vingativa", 3, "Causa dano ao atacante.", 2, 8, 0, 0));
        deckPadraoJ1.add(new Encantamento("Proteção Mágica", 4, "Reduz dano mágico recebido em 10 pontos.", 3, 0, 0, -10));
        deckPadraoJ1.add(new Encantamento("Poder Antigo", 5, "Aumenta ataque de uma criatura aliada em 5 pontos.", 3, 5, 0, 0));

        return deckPadraoJ1;
    }

    public ArrayList<Carta> inicializadorCartasJ2() {
        ArrayList<Carta> deckPadraoJ2 = new ArrayList<>();

        deckPadraoJ2.add(new Criatura(120, "Mago", 3, 70, 50, "Ataques de bola de fogo.", false));
        deckPadraoJ2.add(new Criatura(95, "Arqueiro", 2, 60, 40, "Ataques à distância com alto dano.", false));
        deckPadraoJ2.add(new Criatura(150, "Fênix Ardente", 5, 80, 60, "Ressurreição: Revive uma vez após ser destruída.", true));
        deckPadraoJ2.add(new Criatura(250, "Golem de Pedra", 7, 70, 120, "Impenetrável: Reduz dano recebido em 30%.", false));
        deckPadraoJ2.add(new Criatura(135, "Demônio das Sombras", 4, 70, 50, "Camuflagem: Não pode ser atacado por 2 rodadas.", true));
        deckPadraoJ2.add(new Criatura(75, "Fada Curandeira", 3, 0, 30, "Cura: Recupera 50 de vida de um aliado.", true));
        deckPadraoJ2.add(new Criatura(220, "Gigante da Montanha", 6, 100, 120, "Pisada: Dano em área a criaturas terrestres.", false));
        deckPadraoJ2.add(new Criatura(150, "Cavaleiro Espectral", 5, 90, 80, "Carga Sombria: Dano dobrado ao atacar criaturas de luz.", false));
        deckPadraoJ2.add(new Criatura(110, "Gárgula de Pedra", 4, 60, 50, "Escudo de Pedra: Reduz dano de ataques físicos em 25%.", true));
        deckPadraoJ2.add(new Criatura(180, "Serpente de Fogo", 5, 90, 70, "Escama de Fogo: Reflete 10 de dano ao atacante.", false));
        deckPadraoJ2.add(new Criatura(130, "Bárbaro Enfurecido", 3, 75, 55, "Fúria: Ganha +3 de ataque após cada rodada.", false));
        deckPadraoJ2.add(new Criatura(140, "Bruxa das Sombras", 4, 80, 40, "Enfraquecimento: Reduz o ataque do inimigo em 10 por 2 rodadas.", false));
        deckPadraoJ2.add(new Criatura(160, "Ciclope Selvagem", 6, 100, 80, "Tiro Poderoso: Causa dano em área ao atacar.", false));
        deckPadraoJ2.add(new Criatura(190, "Kraken do Abismo", 7, 90, 110, "Tentáculos: Imobiliza uma criatura por 2 rodadas.", false));
        deckPadraoJ2.add(new Criatura(85, "Espectro Veloz", 2, 60, 30, "Furtividade: Evita o primeiro ataque de cada rodada.", true));
        deckPadraoJ2.add(new Criatura(115, "Mestre de Espadas", 4, 85, 60, "Combo: Pode atacar duas vezes em uma rodada.", false));
        deckPadraoJ2.add(new Criatura(90, "Lobo das Sombras", 3, 50, 40, "Alvo Duplo: Ataca uma criatura adicional.", false));
        deckPadraoJ2.add(new Criatura(130, "Corvo Negro", 3, 55, 35, "Predador das Alturas: Dano extra a criaturas voadoras.", true));
        deckPadraoJ2.add(new Criatura(200, "Titã das Rochas", 6, 70, 100, "Força Imensa: Reduz defesa inimiga em 5 ao atacá-lo.", false));

        deckPadraoJ2.add(new Feitico("Bola de Fogo", 3, "Causa grande dano a uma única criatura inimiga.", 15, 0, 0));
        deckPadraoJ2.add(new Feitico("Tornado", 4, "Ataca todos os tipos de criaturas inimigas e causa dano.", 10, 0, 0));
        deckPadraoJ2.add(new Feitico("Smite", 2, "Feitiço que causa dano verdadeiro a uma unidade.", 8, 0, 0));
        deckPadraoJ2.add(new Feitico("Impacto de Lava", 4, "Dano em área a todas as criaturas inimigas.", 12, 0, 0));
        deckPadraoJ2.add(new Feitico("Raio Celestial", 5, "Causa dano alto em uma criatura.", 18, 0, 0));
        deckPadraoJ2.add(new Feitico("Cura Sagrada", 3, "Recupera vida de uma criatura aliada.", 0, 10, 0));
        deckPadraoJ2.add(new Feitico("Relâmpago Veloz", 3, "Causa dano rápido e direto ao inimigo.", 12, 0, 0));
        deckPadraoJ2.add(new Feitico("Dilúvio Arcano", 5, "Dano em todas as criaturas inimigas.", 15, 0, 0));

        deckPadraoJ2.add(new Encantamento("Campo de Força", 4, "Reduz o dano de ataques inimigos em 15 pontos.", 3, 0, 0, -15));
        deckPadraoJ2.add(new Encantamento("Maldição da Fraqueza", 3, "Reduz o ataque de todas as criaturas inimigas em 10 pontos.", 2, 0, 0, -10));
        deckPadraoJ2.add(new Encantamento("Ignite", 3, "Inflige dano contínuo ao inimigo.", 2, 8, 0, 0));
        deckPadraoJ2.add(new Encantamento("Escudo de Chamas", 3, "Reduz dano físico recebido em 10 pontos.", 3, 0, 0, -10));
        deckPadraoJ2.add(new Encantamento("Aura de Vida", 2, "Recupera 8 de vida a cada rodada.", 2, 0, 8, 0));
        deckPadraoJ2.add(new Encantamento("Proteção Divina", 3, "Reduz o dano recebido em 12 pontos.", 2, 0, 0, -12));
        deckPadraoJ2.add(new Encantamento("Armadura de Luz", 5, "Absorve dano recebido por um aliado.", 3, 0, 0, -15));
        deckPadraoJ2.add(new Encantamento("Essência Sombria", 4, "Causa dano ao atacante.", 3, 5, 0, 0));

        return deckPadraoJ2;
    }

}
