package Cartas;

import java.util.ArrayList;

public class Inventario
{
    protected ArrayList<Carta> cartasInventario = new ArrayList<>();
    //Array em que vai ficar as cartas que o player vai conquistando ao progredir os niveis
    protected Carta[][] cartasProgresso = new Carta[10][10];

    public Inventario()
    {
        inicializadorCartasJ1();
        inicializadorCartasJ2();
        inicializadorCartasJ3();
        inicializadorCartasJ4();
        inicializarCartasProgresso();
    }

    public ArrayList<Carta> getCartasInventario() {
        return cartasInventario;
    }

    public Carta[][] getCartasProgresso() {
        return cartasProgresso;
    }

    public void inicializarCartasProgresso()
    {
        // Nível 1 - Progresso inicial, criaturas levemente mais fortes que as básicas.
        cartasProgresso[0][0] = new Criatura(21, "Gigante", 3, 3, 5, "Socos lentos mas fortes.", false);
        cartasProgresso[0][1] = new Feitico("Explosão Arcana", 2, "Dano leve em uma criatura inimiga.", 15, 0, 0);
        cartasProgresso[0][2] = new Criatura(15, "Lobisomem", 4, 3, 3, "Arranhões sucessivos.", false);
        cartasProgresso[0][3] = new Encantamento("Escudo Elemental", 3, "Reduz dano recebido em 10 pontos por 3 turnos.", 3, 0, 0, -10);
        cartasProgresso[0][4] = new Criatura(16, "Serpente do Pântano", 3, 3, 4, "Aterrorizante em águas rasas.", true);
        cartasProgresso[0][5] = new Feitico("Chamas Rastejantes", 3, "Inflige dano contínuo por 3 rodadas.", 12, 0, 0);
        cartasProgresso[0][6] = new Criatura(20, "Guerreiro Ancestral", 4, 4, 4, "Lutador com técnicas milenares.", false);
        cartasProgresso[0][7] = new Encantamento("Aura de Regeneração", 3, "Recupera 5 de vida a cada turno por 3 turnos.", 3, 0, 5, 0);
        cartasProgresso[0][8] = new Criatura(18, "Roc Implacável", 4, 4, 3, "Pássaro gigante de ataque feroz.", true);
        cartasProgresso[0][9] = new Feitico("Lança de Gelo", 3, "Causa 20 de dano e reduz velocidade de ataque.", 20, 0, 0);

        // Nível 2 - Criaturas mais estratégicas, com maior resistência e dano.
        cartasProgresso[1][0] = new Criatura(25, "Elemental da Rocha", 5, 5, 6, "Resistente como as montanhas.", false);
        cartasProgresso[1][1] = new Feitico("Impacto Glacial", 4, "Congela e causa dano a uma criatura.", 25, 0, 0);
        cartasProgresso[1][2] = new Criatura(20, "Fera Etérea", 4, 4, 4, "Caminha entre dimensões.", true);
        cartasProgresso[1][3] = new Encantamento("Barreira Arcana", 4, "Absorve até 20 de dano por 2 turnos.", 2, 0, 0, -20);
        cartasProgresso[1][4] = new Criatura(19, "Treant Protetor Ancião", 5, 3, 5, "Defensor da floresta sagrada.", false);
        cartasProgresso[1][5] = new Feitico("Torrente de Raios", 4, "Dano a todos os inimigos no campo.", 15, 0, 0);
        cartasProgresso[1][6] = new Criatura(26, "Leviatã do Abismo", 6, 5, 6, "Comanda os oceanos profundos.", true);
        cartasProgresso[1][7] = new Encantamento("Coroa da Tempestade", 4, "Aumenta o ataque de aliados em 10 por 2 turnos.", 2, 10, 0, 0);
        cartasProgresso[1][8] = new Criatura(17, "Espectro de Sombras", 4, 4, 4, "Silencioso e letal.", true);
        cartasProgresso[1][9] = new Feitico("Erosão Sombria", 4, "Inflige 20 de dano e reduz defesa do alvo.", 20, 0, 0);

        // Nível 3 - Criaturas de poder extremo para os níveis mais altos.
        cartasProgresso[2][0] = new Criatura(30, "Dragão Ancião", 6, 4, 7, "Domina o céu com sua presença.", true);
        cartasProgresso[2][1] = new Feitico("Inferno Ardente", 5, "Dano massivo em todas as criaturas inimigas.", 30, 0, 0);
        cartasProgresso[2][2] = new Criatura(26, "Fenrir", 6, 5, 7, "Predador alfa lendário.", false);
        cartasProgresso[2][3] = new Encantamento("Escudo de Chamas Eternas", 5, "Absorve até 30 de dano por 3 turnos.", 3, 0, 0, -30);
        cartasProgresso[2][4] = new Criatura(24, "Besta Infernal", 5, 6, 5, "Criatura do submundo.", false);
        cartasProgresso[2][5] = new Feitico("Ruptura Celestial", 5, "Dano verdadeiro em uma criatura e no oponente.", 40, 0, 0);
        cartasProgresso[2][6] = new Criatura(28, "Cavaleiro Dragão", 6, 6, 7, "Fusão perfeita entre homem e dragão.", false);
        cartasProgresso[2][7] = new Encantamento("Chama Divina", 5, "Causa 15 de dano ao oponente por turno por 2 turnos.", 2, 15, 0, 0);
        cartasProgresso[2][8] = new Criatura(25, "Fênix de Gelo", 6, 5, 6, "Renasce das cinzas congeladas.", true);
        cartasProgresso[2][9] = new Feitico("Colapso Temporal", 6, "Reduz o custo de mana das suas cartas por 2 turnos.", 0, 0, 0);

        //Temos que criar mais cartas nesses Arrays
    }

    public ArrayList<Carta> inicializadorCartasJ1() {
        ArrayList<Carta> deckPadraoJ1 = new ArrayList<>();

        deckPadraoJ1.add(new Criatura(12, "Goblin", 2, 5, 1, "Um goblin escolhido por sua gangue.", false));
        deckPadraoJ1.add(new Criatura(13, "Serpente do Caos", 4, 7, 2, "Serpente gigante poderosa.", false));
        deckPadraoJ1.add(new Criatura(9, "Elfo Arqueiro", 3, 6, 2, "Um elfo que conseguiu dominar a arte do tiro.", false));
        deckPadraoJ1.add(new Criatura(16, "Minotauro Selvagem", 5, 8, 3, "Diretamente da grécia para Arcana.", false));
        deckPadraoJ1.add(new Criatura(10, "Zumbi Despedaçado", 2, 5, 2, "Veio diretamente do cemitério para o campo de batalha.", false));
        deckPadraoJ1.add(new Criatura(11, "Espectro da Noite", 4, 70, 50, "Criatura sombria da noite.", true));
        deckPadraoJ1.add(new Criatura(20, "Treant Protetor", 6, 6, 5, "Criado primeiramente para proteção, agora também quer atacar.", false));
        deckPadraoJ1.add(new Criatura(18, "Hidra de Múltiplas Cabeças", 6, 9, 5, "Criatura super resistente.", false));
        deckPadraoJ1.add(new Criatura(9, "Aranha Gigante", 3, 5, 2, "Gosta de fazer seus inimigos de presa.", false));
        deckPadraoJ1.add(new Criatura(13, "Lobisomem Furioso", 3, 7, 2, "Tome cuidado em dias de lua cheia.", false));
        deckPadraoJ1.add(new Criatura(14, "Dragão de Lava", 6, 8, 5, "Dragão adaptado para vulcões.", true));
        deckPadraoJ1.add(new Criatura(11, "Orc Berserker", 2, 6, 2, "Um orc saiu de controle e agora quer enfrentar todo mundo.", false));
        deckPadraoJ1.add(new Criatura(9, "Sátiro Ilusório", 3, 5, 2, "Tome cuidado com suas ilusões.", false));
        deckPadraoJ1.add(new Criatura(16, "Manticora Assassina", 5, 8, 4, "Criada para matar.", true));
        deckPadraoJ1.add(new Criatura(11, "Guardião das Sombras", 4, 7, 3, "Antigo rival do espectro da noite.", true));
        deckPadraoJ1.add(new Criatura(10, "Leopardo Alado", 3, 6, 2, "Não basta ser rápido por terra, agora querem dominar o ar.", true));
        deckPadraoJ1.add(new Criatura(15, "Ogros de Batalha", 5, 7, 4, "Força bruta.", false));
        deckPadraoJ1.add(new Criatura(20, "Elemental da Terra", 6, 6, 5, "Cria da mãe natureza.", false));
        deckPadraoJ1.add(new Criatura(8, "Assassino Fantasma", 2, 6, 1, "Ataque Sorrateiro.", true));

        deckPadraoJ1.add(new Feitico("Explosão de Gelo", 3, "Tão gelada que emite dano.", 8, 0, 0));
        deckPadraoJ1.add(new Feitico("Chuva de Fogo", 4, "Causa dano em todos os tipos de criaturas inimigas.", 10, 0, 0));
        deckPadraoJ1.add(new Feitico("Raio", 3, "Um pequeno raio que inflige dano a qualquer tropa.", 8, 0, 0));
        deckPadraoJ1.add(new Feitico("Explosão Arcana", 3, "Dano mágico de origem desconhecida.", 10, 0, 0));
        deckPadraoJ1.add(new Feitico("Chamas Místicas", 4, "Causa grande dano a uma criatura inimiga.", 10, 0, 0));
        deckPadraoJ1.add(new Feitico("Toque Curativo", 2, "Recupera vida de uma criatura aliada.", 0, 5, 0));
        deckPadraoJ1.add(new Feitico("Maldade Incandescente", 5, "Dano mágico alto.", 15, 0, 0));
        deckPadraoJ1.add(new Feitico("Erupção Sombria", 4, "Dano médio em todos os inimigos.", 12, 0, 0));

        deckPadraoJ1.add(new Encantamento("Aura de Cura", 3, "Recupera 10 de vida de todas as suas criaturas a cada rodada.", 3, 0, 10, 0));
        deckPadraoJ1.add(new Encantamento("Escudo de Mana", 2, "Cria um escudo que absorve 4 de dano de todas as suas criaturas.", 2, 0, 0, -4));
        deckPadraoJ1.add(new Encantamento("Poção", 3, "Poção que recupera pequenas quantidades de vida por turnos.", 2, 0, 8, 0));
        deckPadraoJ1.add(new Encantamento("Escudo Sombrio", 3, "Reduz o dano recebido em 4 pontos.", 3, 0, 0, -4));
        deckPadraoJ1.add(new Encantamento("Bênção da Vida", 2, "Recupera 8 de vida a cada rodada.", 2, 0, 8, 0));
        deckPadraoJ1.add(new Encantamento("Aura Vingativa", 3, "Causa dano ao atacante.", 2, 5, 0, 0));
        deckPadraoJ1.add(new Encantamento("Proteção Mágica", 4, "Reduz dano mágico recebido em 5 pontos.", 3, 0, 0, -5));
        deckPadraoJ1.add(new Encantamento("Poder Antigo", 5, "Aumenta ataque de uma criatura aliada em 5 pontos.", 3, 5, 0, 0));

        return deckPadraoJ1;
    }

    public ArrayList<Carta> inicializadorCartasJ2() {
        ArrayList<Carta> deckPadraoJ2 = new ArrayList<>();

        deckPadraoJ2.add(new Criatura(12, "Mago", 3, 70, 50, "Ataques de bola de fogo.", false));
        deckPadraoJ2.add(new Criatura(9, "Arqueiro", 2, 60, 40, "Ataques à distância com alto dano.", false));
        deckPadraoJ2.add(new Criatura(15, "Fênix Ardente", 5, 80, 60, "Ave flamejante.", true));
        deckPadraoJ2.add(new Criatura(25, "Golem de Pedra", 7, 70, 120, "Criatura resistente esculpida na rocha.", false));
        deckPadraoJ2.add(new Criatura(13, "Demônio das Sombras", 4, 70, 50, "Criatura sombria que assombra seus inimigos.", true));
        deckPadraoJ2.add(new Criatura(7, "Fada Curandeira", 3, 0, 30, "Pequena fada mágica com poderes de cura.", true));
        deckPadraoJ2.add(new Criatura(22, "Gigante da Montanha", 6, 100, 120, "Criatura colossal das montanhas.", false));
        deckPadraoJ2.add(new Criatura(15, "Cavaleiro Espectral", 5, 90, 80, "Guerreiro sombrio em uma armadura assombrada.", false));
        deckPadraoJ2.add(new Criatura(11, "Gárgula de Pedra", 4, 60, 50, "Estátua viva com força sobrenatural.", false));
        deckPadraoJ2.add(new Criatura(18, "Serpente de Fogo", 5, 90, 70, "Serpente ardente que espalha destruição.", false));
        deckPadraoJ2.add(new Criatura(13, "Bárbaro Enfurecido", 3, 75, 55, "Guerreiro selvagem que luta sem piedade.", false));
        deckPadraoJ2.add(new Criatura(14, "Bruxa das Sombras", 4, 80, 40, "Mística das sombras que conjura feitiços.", false));
        deckPadraoJ2.add(new Criatura(16, "Ciclope Selvagem", 6, 100, 80, "Gigante de um olho só, cheio de fúria.", false));
        deckPadraoJ2.add(new Criatura(19, "Kraken do Abismo", 7, 90, 110, "Monstro marítimo vindo das profundezas.", false));
        deckPadraoJ2.add(new Criatura(9, "Espectro Veloz", 2, 60, 30, "Espírito ágil e difícil de capturar.", false));
        deckPadraoJ2.add(new Criatura(11, "Mestre de Espadas", 4, 85, 60, "Espadachim habilidoso com ataques precisos.", false));
        deckPadraoJ2.add(new Criatura(9, "Lobo das Sombras", 3, 50, 40, "Predador noturno com olhos brilhantes.", false));
        deckPadraoJ2.add(new Criatura(13, "Corvo Negro", 3, 55, 35, "Ave sombria que espreita seus alvos.", true));
        deckPadraoJ2.add(new Criatura(20, "Titã das Rochas", 6, 70, 100, "Gigante feito de pedra e força pura.", false));

        deckPadraoJ2.add(new Feitico("Bola de Fogo", 3, "Causa grande dano a uma única criatura inimiga.", 15, 0, 0));
        deckPadraoJ2.add(new Feitico("Tornado", 4, "Causa dano a todas as criaturas inimigas.", 10, 0, 0));
        deckPadraoJ2.add(new Feitico("Smite", 2, "Feitiço que fere diretamente uma criatura.", 8, 0, 0));
        deckPadraoJ2.add(new Feitico("Impacto de Lava", 4, "Explosão de lava que atinge várias criaturas.", 12, 0, 0));
        deckPadraoJ2.add(new Feitico("Raio Celestial", 5, "Golpe poderoso que afeta uma criatura.", 18, 0, 0));
        deckPadraoJ2.add(new Feitico("Cura Sagrada", 3, "Recupera vida de uma criatura.", 0, 10, 0));
        deckPadraoJ2.add(new Feitico("Relâmpago Veloz", 3, "Golpe direto em uma criatura ou jogador.", 12, 0, 0));
        deckPadraoJ2.add(new Feitico("Dilúvio Arcano", 5, "Ataque mágico que afeta várias criaturas.", 15, 0, 0));

        deckPadraoJ2.add(new Encantamento("Campo de Força", 4, "Aumenta a resistência de uma criatura.", 3, 0, 0, 0));
        deckPadraoJ2.add(new Encantamento("Maldição da Fraqueza", 3, "Enfraquece o ataque de uma criatura inimiga.", 2, 0, 0, 0));
        deckPadraoJ2.add(new Encantamento("Ignite", 3, "Causa dano contínuo ao alvo.", 2, 8, 0, 0));
        deckPadraoJ2.add(new Encantamento("Escudo de Chamas", 3, "Protege contra dano físico.", 3, 0, 0, 0));
        deckPadraoJ2.add(new Encantamento("Aura de Vida", 2, "Recupera vida de uma criatura em cada rodada.", 2, 0, 8, 0));
        deckPadraoJ2.add(new Encantamento("Proteção Divina", 3, "Reduz o dano recebido por uma criatura.", 2, 0, 0, 0));
        deckPadraoJ2.add(new Encantamento("Armadura de Luz", 5, "Fortalece a defesa de uma criatura.", 3, 0, 0, 0));
        deckPadraoJ2.add(new Encantamento("Essência Sombria", 4, "Causa dano ao atacante em represália.", 3, 5, 0, 0));

        return deckPadraoJ2;
    }

    public ArrayList<Carta> inicializadorCartasJ3()
    {
        ArrayList<Carta> deckPadraoJ3 = new ArrayList<>();
        return deckPadraoJ3;
    }

    public ArrayList<Carta> inicializadorCartasJ4()
    {
        ArrayList<Carta> deckPadraoJ4 = new ArrayList<>();
        return deckPadraoJ4;
    }
}
