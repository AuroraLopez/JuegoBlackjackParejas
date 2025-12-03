import java.util.ArrayList;
import java.util.Scanner;

public class Mano {

    private ArrayList<Carta> cartas = new ArrayList<>();
    private ArrayList<Integer> valoresFinales = new ArrayList<>();

    public void agregarCarta(Carta c, Scanner sc, boolean jugador) {
        cartas.add(c);

        if (c.getValor() == Valor.AS && jugador) {
            System.out.println("Te ha salido un As: " + c);
            System.out.print("¿Quieres que valga 1 u 11? Introduce el valor: ");
            int eleccion = sc.nextInt();
            if (eleccion != 1 && eleccion != 11) eleccion = 11;
            valoresFinales.add(eleccion);
        } else {
            valoresFinales.add(valorNumericoAuto(c));
        }
    }

    public void agregarCartaCrupier(Carta c) {
        cartas.add(c);
        valoresFinales.add(valorNumericoAuto(c));
    }

    private int valorNumericoAuto(Carta c) {
        switch (c.getValor()) {
            case DOS: return 2;
            case TRES: return 3;
            case CUATRO: return 4;
            case CINCO: return 5;
            case SEIS: return 6;
            case SIETE: return 7;
            case OCHO: return 8;
            case NUEVE: return 9;
            case DIEZ: 
            case J: 
            case Q: 
            case K: return 10;
            case AS: return 11;
        }
        return 0;
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
