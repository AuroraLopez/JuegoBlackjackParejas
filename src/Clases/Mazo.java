package Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mazo {
    private ArrayList<Carta> cartas = new ArrayList<>();
    private ArrayList<Integer> valoresFinales = new ArrayList<>();

    Scanner teclado = new Scanner(System.in);
    public Mazo() {
        generarBaraja();
        barajar();
    }

    private void generarBaraja() {
        for (Palo palo : Palo.values()) {
            for (Valor valor : Valor.values()) {
                cartas.add(new Carta(palo, valor));
            }
        }
    }

    public void agregarCarta(Carta c, boolean jugador) {
        cartas.add(c);

        if (c.getValor() == Valor.AS && jugador) {
            System.out.println("Te ha salido un As: " + c);
            System.out.print("¿Quieres que valga 1 u 11? Introduce el valor: ");
            int eleccion = teclado.nextInt();
            if (eleccion != 1 && eleccion != 11) eleccion = 11;
            valoresFinales.add(eleccion);
        } 
    }


    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta sacarCarta() {
        if (cartas.isEmpty()) return null;
        return cartas.remove(0);
    }

    public int getPuntuacion() {
        int total = 0;
        for (int i = 0; i < valoresFinales.size(); i++) {
            total += valoresFinales.get(i);
        }
        return total;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    @Override
    public String toString() {
        return cartas.toString() + " (Total: " + getPuntuacion() + ")";
    }

}
