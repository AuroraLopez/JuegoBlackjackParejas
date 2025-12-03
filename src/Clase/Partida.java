import java.util.Scanner;

public class Partida {

    private Scanner sc = new Scanner(System.in);
    private Jugador jugador;
    private Crupier crupier;
    private Baraja baraja;

    private int victoriasJugador = 0;
    private int victoriasCrupier = 0;

    public void iniciar() {

        System.out.print("Introduce el nombre del jugador: ");
        jugador = new Jugador(sc.nextLine());

        System.out.print("Introduce el nombre del crupier: ");
        crupier = new Crupier(sc.nextLine());

        while (jugador.getDinero() > 0) {
            jugarRonda();
        }

        System.out.println("El jugador se ha quedado sin dinero. Fin de la partida.");
        System.out.println("Victorias del jugador: " + victoriasJugador);
        System.out.println("Victorias del crupier: " + victoriasCrupier);
    }

    private void jugarRonda() {

        baraja = new Baraja();
        baraja.barajar();

        jugador.reiniciarMano();
        crupier.reiniciarMano();

        System.out.println("\nDinero actual: " + jugador.getDinero() + "€");
        System.out.print("Introduce tu apuesta: ");
        int apuesta = sc.nextInt();
        sc.nextLine();

        // Reparto inicial
        for (int i = 0; i < 2; i++) {
            jugador.getMano().agregarCarta(baraja.robar(), sc, true);
            crupier.getMano().agregarCartaCrupier(baraja.robar());
        }

        turnoJugador();
        if (jugador.getMano().getPuntuacion() > 21) {
            System.out.println("Te has pasado de 21. Pierdes la apuesta.");
            jugador.perder(apuesta);
            victoriasCrupier++;
            return;
        }

        turnoCrupier();

        determinarGanador(apuesta);
    }

    private void turnoJugador() {
        String opcion = "s";

        while (opcion.equalsIgnoreCase("s") && jugador.getMano().getPuntuacion() < 21) {

            System.out.println("\nTu mano: " + jugador.getMano());
            System.out.print("¿Deseas pedir otra carta? (s/n): ");
            opcion = sc.nextLine();

            if (opcion.equalsIgnoreCase("s")) {
                jugador.getMano().agregarCarta(baraja.robar(), sc, true);
            }
        }
    }

    private void turnoCrupier() {

        System.out.println("\nMano del crupier: " + crupier.getMano());

        while (crupier.getMano().getPuntuacion() < 17) {
            crupier.getMano().agregarCartaCrupier(baraja.robar());
            System.out.println("El crupier roba. Mano: " + crupier.getMano());
        }
    }

    private void determinarGanador(int apuesta) {

        int puntosJ = jugador.getMano().getPuntuacion();
        int puntosC = crupier.getMano().getPuntuacion();

        System.out.println("\nPuntos jugador: " + puntosJ);
        System.out.println("Puntos crupier: " + puntosC);

        if ((puntosJ <= 21 && puntosJ > puntosC) || puntosC > 21) {
            System.out.println("\nHas ganado la ronda.");
            jugador.ganar(apuesta);
            victoriasJugador++;
        } else if (puntosJ == puntosC) {
            System.out.println("\nEmpate. No se gana ni se pierde dinero.");
        } else {
            System.out.println("\nHas perdido la ronda.");
            jugador.perder(apuesta);
            victoriasCrupier++;
        }
    }
}
