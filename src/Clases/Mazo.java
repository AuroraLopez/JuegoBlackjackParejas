package Clases;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {

    private ArrayList<Carta> cartas = new ArrayList<>();

    // Constructor de mazo
    public Mazo() {
        generarBaraja();
        barajar();
    }

    // Función para generar la baraja
    private void generarBaraja() {
        for (Palo p : Palo.values()) {
            for (Valor v : Valor.values()) {
                cartas.add(new Carta(p, v));
            }
        }
    }

    // Función para barajar
    public void barajar() {
        Collections.shuffle(cartas);
    }

    // Función para quitar carta de una baraja al sacarla en mano
    public Carta sacarCarta() {
        return cartas.remove(0);
    }
}
