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
        cartasProgresso[0][0] = new Criatura(210, "Gigante", 3, 25, 100, "Socos lentos mas fortes.", false);
        cartasProgresso[0][1] = new Feitico("Explosão Arcana", 2, "Dano leve em uma criatura inimiga.", 15, 0, 0);
        cartasProgresso[0][2] = new Criatura(150, "Lobisomem", 4, 30, 70, "Arranhões sucessivos.", false);
        cartasProgresso[0][3] = new Encantamento("Escudo Elemental", 3, "Reduz dano recebido em 10 pontos por 3 turnos.", 3, 0, 0, -10);
        cartasProgresso[0][4] = new Criatura(160, "Serpente do Pântano", 3, 30, 65, "Aterrorizante em águas rasas.", true);
        cartasProgresso[0][5] = new Feitico("Chamas Rastejantes", 3, "Inflige dano contínuo por 3 rodadas.", 12, 0, 0);
        cartasProgresso[0][6] = new Criatura(200, "Guerreiro Ancestral", 4, 40, 80, "Lutador com técnicas milenares.", false);
        cartasProgresso[0][7] = new Encantamento("Aura de Regeneração", 3, "Recupera 5 de vida a cada turno por 3 turnos.", 3, 0, 5, 0);
        cartasProgresso[0][8] = new Criatura(180, "Roc Implacável", 4, 45, 70, "Pássaro gigante de ataque feroz.", true);
        cartasProgresso[0][9] = new Feitico("Lança de Gelo", 3, "Causa 20 de dano e reduz velocidade de ataque.", 20, 0, 0);

        // Nível 2 - Criaturas mais estratégicas, com maior resistência e dano.
        cartasProgresso[1][0] = new Criatura(250, "Elemental da Rocha", 5, 50, 110, "Resistente como as montanhas.", false);
        cartasProgresso[1][1] = new Feitico("Impacto Glacial", 4, "Congela e causa dano a uma criatura.", 25, 0, 0);
        cartasProgresso[1][2] = new Criatura(200, "Fera Etérea", 4, 40, 90, "Caminha entre dimensões.", true);
        cartasProgresso[1][3] = new Encantamento("Barreira Arcana", 4, "Absorve até 20 de dano por 2 turnos.", 2, 0, 0, -20);
        cartasProgresso[1][4] = new Criatura(190, "Treant Protetor Ancião", 5, 35, 100, "Defensor da floresta sagrada.", false);
        cartasProgresso[1][5] = new Feitico("Torrente de Raios", 4, "Dano a todos os inimigos no campo.", 15, 0, 0);
        cartasProgresso[1][6] = new Criatura(260, "Leviatã do Abismo", 6, 50, 120, "Comanda os oceanos profundos.", true);
        cartasProgresso[1][7] = new Encantamento("Coroa da Tempestade", 4, "Aumenta o ataque de aliados em 10 por 2 turnos.", 2, 10, 0, 0);
        cartasProgresso[1][8] = new Criatura(170, "Espectro de Sombras", 4, 35, 70, "Silencioso e letal.", true);
        cartasProgresso[1][9] = new Feitico("Erosão Sombria", 4, "Inflige 20 de dano e reduz defesa do alvo.", 20, 0, 0);

        // Nível 3 - Criaturas de poder extremo para os níveis mais altos.
        cartasProgresso[2][0] = new Criatura(300, "Dragão Ancião", 6, 70, 150, "Domina o céu com sua presença.", true);
        cartasProgresso[2][1] = new Feitico("Inferno Ardente", 5, "Dano massivo em todas as criaturas inimigas.", 30, 0, 0);
        cartasProgresso[2][2] = new Criatura(260, "Fenrir", 6, 55, 130, "Predador alfa lendário.", false);
        cartasProgresso[2][3] = new Encantamento("Escudo de Chamas Eternas", 5, "Absorve até 30 de dano por 3 turnos.", 3, 0, 0, -30);
        cartasProgresso[2][4] = new Criatura(240, "Besta Infernal", 5, 60, 100, "Criatura do submundo.", false);
        cartasProgresso[2][5] = new Feitico("Ruptura Celestial", 5, "Dano verdadeiro em uma criatura e no oponente.", 40, 0, 0);
        cartasProgresso[2][6] = new Criatura(280, "Cavaleiro Dragão", 6, 65, 140, "Fusão perfeita entre homem e dragão.", false);
        cartasProgresso[2][7] = new Encantamento("Chama Divina", 5, "Causa 15 de dano ao oponente por turno por 2 turnos.", 2, 15, 0, 0);
        cartasProgresso[2][8] = new Criatura(250, "Fênix de Gelo", 6, 50, 120, "Renasce das cinzas congeladas.", true);
        cartasProgresso[2][9] = new Feitico("Colapso Temporal", 6, "Reduz o custo de mana das suas cartas por 2 turnos.", 0, 0, 0);

        //Temos que criar mais cartas nesses Arrays
    }

    public ArrayList<Carta> inicializadorCartasJ1() {
        ArrayList<Carta> deckPadraoJ1 = new ArrayList<>();

        deckPadraoJ1.add(new Criatura(120, "Goblin", 2, 50, 30, "Um goblin escolhido por sua gangue.", false));
        deckPadraoJ1.add(new Criatura(130, "Serpente do Caos", 4, 70, 50, "Serpente gigante poderosa.", false));
        deckPadraoJ1.add(new Criatura(90, "Elfo Arqueiro", 3, 60, 40, "Um elfo que conseguiu dominar a arte do tiro.", false));
        deckPadraoJ1.add(new Criatura(160, "Minotauro Selvagem", 5, 80, 70, "Diretamente da grécia para Arcana.", false));
        deckPadraoJ1.add(new Criatura(100, "Zumbi Despedaçado", 2, 50, 30, "Veio diretamente do cemitério para o campo de batalha.", false));
        deckPadraoJ1.add(new Criatura(110, "Espectro da Noite", 4, 70, 50, "Criatura sombria da noite.", true));
        deckPadraoJ1.add(new Criatura(200, "Treant Protetor", 6, 60, 100, "Criado primeiramente para proteção, agora também quer atacar.", false));
        deckPadraoJ1.add(new Criatura(180, "Hidra de Múltiplas Cabeças", 6, 90, 100, "Criatura super resistente.", false));
        deckPadraoJ1.add(new Criatura(90, "Aranha Gigante", 3, 50, 40, "Gosta de fazer seus inimigos de presa.", false));
        deckPadraoJ1.add(new Criatura(130, "Lobisomem Furioso", 3, 75, 50, "Tome cuidado em dias de lua cheia.", false));
        deckPadraoJ1.add(new Criatura(140, "Dragão de Lava", 6, 85, 100, "Dragão adaptado para vulcões.", true));
        deckPadraoJ1.add(new Criatura(110, "Orc Berserker", 2, 65, 40, "Um orc saiu de controle e agora quer enfrentar todo mundo.", false));
        deckPadraoJ1.add(new Criatura(90, "Sátiro Ilusório", 3, 50, 30, "Tome cuidado com suas ilusões.", false));
        deckPadraoJ1.add(new Criatura(160, "Manticora Assassina", 5, 80, 90, "Criada para matar.", true));
        deckPadraoJ1.add(new Criatura(110, "Guardião das Sombras", 4, 70, 60, "Antigo rival do espectro da noite.", true));
        deckPadraoJ1.add(new Criatura(100, "Leopardo Alado", 3, 60, 30, "Não basta ser rápido por terra, agora querem dominar o ar.", true));
        deckPadraoJ1.add(new Criatura(150, "Ogros de Batalha", 5, 70, 80, "Força bruta.", false));
        deckPadraoJ1.add(new Criatura(200, "Elemental da Terra", 6, 60, 100, "Cria da mãe natureza.", false));
        deckPadraoJ1.add(new Criatura(80, "Assassino Fantasma", 2, 60, 30, "Ataque Sorrateiro.", true));

        deckPadraoJ1.add(new Feitico("Explosão de Gelo", 3, "Tão gelada que emite dano.", 8, 0, 0));
        deckPadraoJ1.add(new Feitico("Chuva de Fogo", 4, "Causa dano em todos os tipos de criaturas inimigas.", 10, 0, 0));
        deckPadraoJ1.add(new Feitico("Raio", 3, "Um pequeno raio que inflige dano a qualquer tropa.", 10, 0, 0));
        deckPadraoJ1.add(new Feitico("Explosão Arcana", 3, "Dano mágico de origem desconhecida.", 12, 0, 0));
        deckPadraoJ1.add(new Feitico("Chamas Místicas", 4, "Causa grande dano a uma criatura inimiga.", 15, 0, 0));
        deckPadraoJ1.add(new Feitico("Toque Curativo", 2, "Recupera vida de uma criatura aliada.", 0, 10, 0));
        deckPadraoJ1.add(new Feitico("Maldade Incandescente", 5, "Dano mágico alto.", 18, 0, 0));
        deckPadraoJ1.add(new Feitico("Erupção Sombria", 4, "Dano médio em todos os inimigos.", 14, 0, 0));

        deckPadraoJ1.add(new Encantamento("Aura de Cura", 3, "Recupera 10 de vida de todas as suas criaturas a cada rodada.", 3, 0, 10, 0));
        deckPadraoJ1.add(new Encantamento("Escudo de Mana", 2, "Cria um escudo que absorve 15 de dano de todas as suas criaturas.", 2, 0, 0, -15));
        deckPadraoJ1.add(new Encantamento("Poção", 3, "Poção que recupera pequenas quantidades de vida por turnos.", 2, 0, 8, 0));
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
        deckPadraoJ2.add(new Criatura(150, "Fênix Ardente", 5, 80, 60, "Ave flamejante.", true));
        deckPadraoJ2.add(new Criatura(250, "Golem de Pedra", 7, 70, 120, "Criatura resistente esculpida na rocha.", false));
        deckPadraoJ2.add(new Criatura(135, "Demônio das Sombras", 4, 70, 50, "Criatura sombria que assombra seus inimigos.", true));
        deckPadraoJ2.add(new Criatura(75, "Fada Curandeira", 3, 0, 30, "Pequena fada mágica com poderes de cura.", true));
        deckPadraoJ2.add(new Criatura(220, "Gigante da Montanha", 6, 100, 120, "Criatura colossal das montanhas.", false));
        deckPadraoJ2.add(new Criatura(150, "Cavaleiro Espectral", 5, 90, 80, "Guerreiro sombrio em uma armadura assombrada.", false));
        deckPadraoJ2.add(new Criatura(110, "Gárgula de Pedra", 4, 60, 50, "Estátua viva com força sobrenatural.", false));
        deckPadraoJ2.add(new Criatura(180, "Serpente de Fogo", 5, 90, 70, "Serpente ardente que espalha destruição.", false));
        deckPadraoJ2.add(new Criatura(130, "Bárbaro Enfurecido", 3, 75, 55, "Guerreiro selvagem que luta sem piedade.", false));
        deckPadraoJ2.add(new Criatura(140, "Bruxa das Sombras", 4, 80, 40, "Mística das sombras que conjura feitiços.", false));
        deckPadraoJ2.add(new Criatura(160, "Ciclope Selvagem", 6, 100, 80, "Gigante de um olho só, cheio de fúria.", false));
        deckPadraoJ2.add(new Criatura(190, "Kraken do Abismo", 7, 90, 110, "Monstro marítimo vindo das profundezas.", false));
        deckPadraoJ2.add(new Criatura(85, "Espectro Veloz", 2, 60, 30, "Espírito ágil e difícil de capturar.", false));
        deckPadraoJ2.add(new Criatura(115, "Mestre de Espadas", 4, 85, 60, "Espadachim habilidoso com ataques precisos.", false));
        deckPadraoJ2.add(new Criatura(90, "Lobo das Sombras", 3, 50, 40, "Predador noturno com olhos brilhantes.", false));
        deckPadraoJ2.add(new Criatura(130, "Corvo Negro", 3, 55, 35, "Ave sombria que espreita seus alvos.", true));
        deckPadraoJ2.add(new Criatura(200, "Titã das Rochas", 6, 70, 100, "Gigante feito de pedra e força pura.", false));

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
