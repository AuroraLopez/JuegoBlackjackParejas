import java.util.ArrayList;
import java.util.Collections;

public class Baraja {

    private ArrayList<Carta> cartas = new ArrayList<>();

    public Baraja() {
        generarBaraja();
    }

    private void generarBaraja() {
        for (Palo palo : Palo.values()) {
            for (Valor valor : Valor.values()) {
                cartas.add(new Carta(palo, valor));
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta robar() {
        if (cartas.size() > 0) {
            return cartas.remove(0);
        }
        return null;
    }
}
