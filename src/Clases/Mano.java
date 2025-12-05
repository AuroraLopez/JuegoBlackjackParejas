package Clases;

import java.util.ArrayList;

public class Mano {

    private ArrayList<Carta> cartas = new ArrayList<>();

    // Pedir carta
    public void agregarCarta(Carta c) {
        cartas.add(c);
    }

    // Devolver todas las cartas al mazo
    public void limpiar() {
        cartas.clear();
    }

    // Tener la puntuación para mayor facilidad
    public int getPuntuacion() {
        int total = 0;
        int ases = 0;
        // Bucle para contabilizar ttodas las cartas de la mano
        for (Carta c : cartas) {
            int valor = c.getValorNumerico();
            if (c.getValor() == Valor.AS) ases++;
            total += valor;
        }

        // Ajustar As de 11 a 1
        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }

        return total;
    }

    // Devuleve las cartas
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    // Imprime el valor de la mano
    @Override
    public String toString() {
        return cartas.toString() + " (Puntos: " + getPuntuacion() + ")";
    }
}
