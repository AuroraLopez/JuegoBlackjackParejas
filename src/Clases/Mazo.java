package Clases;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private ArrayList<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
        String[] palos = {"Espadas", "Copas", "Bastos", "Oros"};//Alternativa baraja española
        for (String palo : palos) {
            for (int i = 1; i <= 13; i++) {
                cartas.add(new Carta(i, palo));
            }
        }
        barajar();
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta sacarCarta() {
        if (cartas.isEmpty()) return null;
        return cartas.remove(0);
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }
}
