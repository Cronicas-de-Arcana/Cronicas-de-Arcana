import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck
{
    private List<Carta> cartas;

    public Deck(List<Carta> cartas)
    {
        if (cartas.size() < 30)
        {
            throw new IllegalArgumentException("O deck deve ter no mínimo 30 cartas");
        }
        this.cartas = new ArrayList<>(cartas);
        Collections.shuffle(this.cartas);
    }

    public Deck()
    {
        this.cartas = new ArrayList<>();
    }

    public boolean verificarDeckVazio()
    {
        return cartas.isEmpty();
    }

    public Carta comprarCarta()
    {
        if (verificarDeckVazio())
        {
            System.out.println("O deck está vazio");
        }
        return cartas.remove(0);
    }

    public int getTamanho() {
        return cartas.size();
    }

    public void adicionarCarta(Carta carta)
    {
        cartas.add(carta);
    }

    public void embaralhar()
    {
        Collections.shuffle(cartas);
    }

    public List<Carta> getCartas()
    {
        return cartas;
    }
}