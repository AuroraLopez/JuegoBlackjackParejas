package Clases;
import java.util.Scanner;

public class Partida {

    private Jugador jugador;
    private Jugador crupier;
    private Mazo mazo;

    private Scanner teclado = new Scanner(System.in);

    // === NUEVOS CONTADORES DE VICTORIAS ===
    private int victoriasJugador = 0;
    private int victoriasCrupier = 0;

    // Función para mostrar menu
    public void mostrarMenu() {

        int opcion;
        // Bucle para que se muestre el menu hasta que pase algo
        do {
            System.out.println("\n---- MENÚ ----");
            System.out.println("1. Crear jugador");
            System.out.println("2. Crear crupier");
            System.out.println("3. Mostrar fondos");
            System.out.println("4. Iniciar partida");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine(); // limpiar buffer
            // Condiciones dependiendo de la opcion que se elija
            switch (opcion) {
                case 1:
                    crearJugador(Tipo.JUGADOR);
                    break;
                case 2:
                    crearJugador(Tipo.CRUPIER);
                    break;
                case 3:
                    mostrarFondos();
                    break;
                case 4:
                    if (jugador != null && crupier != null) {
                        iniciarPartida();
                    } else {
                        System.out.println("Debes crear jugador y crupier primero.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0 );
    }

    // Metodo para crear el jugador
    private void crearJugador(Tipo tipo) {

        System.out.print("\nIntroduce el nombre: ");
        String nombre = teclado.nextLine();

        if (tipo == Tipo.JUGADOR) {
            jugador = new Jugador(nombre, Tipo.JUGADOR);
            System.out.println("Jugador creado.");
        } else {
            crupier = new Jugador(nombre, Tipo.CRUPIER);
            System.out.println("Crupier creado.");
        }
    }

    // Para poder mostrar el dinero que le queda al jugador
    private void mostrarFondos() {
        System.out.println("\nFondos actuales:");
        if (jugador != null)
            System.out.println("Fondos jugador " + jugador.getNombre() + ": " + jugador.getDinero() + "€");

        // Mostrar también contador de victorias si ya están creados
        if (jugador != null && crupier != null) {
            System.out.println("Victorias del jugador: " + victoriasJugador);
            System.out.println("Victorias del crupier: " + victoriasCrupier);
        }
    }

    // Metodo para iniciar la partida
    private void iniciarPartida() {

        // El juego termina solo si el jugador se queda sin dinero
        while (jugador.getDinero() > 0) {

            mazo = new Mazo(); 
            jugador.resetearMano();
            crupier.resetearMano();

            System.out.println("\n*** NUEVA RONDA DE BLACKJACK ***");

            int apuesta = pedirApuesta();

            repartirCartasIniciales();

            mostrarManos(false);

            turnoJugador();

            if (jugador.getMano().getPuntuacion() > 21) {
                System.out.println("\nTe pasaste, pierdes la apuesta.");
                jugador.perder(apuesta);

                // sumar victoria del crupier
                victoriasCrupier++;

                mostrarMarcador();

                continue; // iniciar nueva ronda SI AÚN TIENE DINERO
            }

            turnoCrupier();

            determinarGanador(apuesta);

            mostrarMarcador();
        }

        mostrarMarcador();
    }

    // Función para ver el marcador de las victorias
    private void mostrarMarcador() {
        System.out.println("\n----- MARCADOR -----");
        System.out.println("Victorias del jugador: " + victoriasJugador);
        System.out.println("Victorias del crupier: " + victoriasCrupier);
    }

    // Función para la hora de pedir las apuestas
    private int pedirApuesta() {

        int apuesta;

        do {
            System.out.print("\nTienes " + jugador.getDinero() + " €" + "\nIntroduce tu apuesta: ");
            apuesta = teclado.nextInt();
            if (apuesta <= 0 || apuesta > jugador.getDinero()) {
                System.out.println("Apuesta no válida.");
            }
        } while (apuesta <= 0 || apuesta > jugador.getDinero());

        return apuesta;
    }

    // Metodo para repartir las primeras cartas
    private void repartirCartasIniciales() {

        jugador.getMano().agregarCarta(mazo.sacarCarta());
        jugador.getMano().agregarCarta(mazo.sacarCarta());

        crupier.getMano().agregarCarta(mazo.sacarCarta());
        crupier.getMano().agregarCarta(mazo.sacarCarta());
    }

    // Metodos para ver las manos de cada uno
    private void mostrarManos(boolean mostrarCrupier) {

        System.out.println("\n===== MANOS =====");

        System.out.println("Jugador ["+ jugador.getNombre() + "]: "  + jugador.getMano());

        if (mostrarCrupier) {
            System.out.println("Crupier: " + crupier.getMano());
        } else {
            System.out.println("Crupier ["+ crupier.getNombre() + "]: " + crupier.getMano().getCartas().get(0) + ", CARTA OCULTA]");
        }
    }

    // Metodos para los distintos turnos, en este caso jugador
    private void turnoJugador() {

        String opcion;

        do {
            System.out.print("\n¿Quieres otra carta? (s/n): ");
            opcion = teclado.next().toLowerCase();

            if (opcion.equals("s")) {
                jugador.getMano().agregarCarta(mazo.sacarCarta());
                mostrarManos(false);
            } else if (!opcion.equals("n")) {
                System.out.println("Respuesta no válida, usa 's' o 'n'.");
            }

        } while (opcion.equals("s") && jugador.getMano().getPuntuacion() <= 21);
    }

    // Metodos para los distintos turnos, en este caso crupier
    private void turnoCrupier() {

        System.out.println("\nTurno del crupier...");
        mostrarManos(true);

        while (crupier.getMano().getPuntuacion() < 17) {
            crupier.getMano().agregarCarta(mazo.sacarCarta());
            System.out.println("Crupier roba una carta...");
            mostrarManos(true);
        }
    }

    // Metodo para saber si quien de los dos ha ganado
    private void determinarGanador(int apuesta) {

        int puntosJugador = jugador.getMano().getPuntuacion();
        int puntosCrupier = crupier.getMano().getPuntuacion();

        System.out.println("\n===== RESULTADOS =====");

        if (puntosCrupier > 21 || (puntosJugador <=21 && puntosJugador > puntosCrupier)) {
            System.out.println("¡¡HAS GANADO!! +" + apuesta + "€");
            jugador.ganar(apuesta);

            // registrar victoria
            victoriasJugador++;
        } 
        else if (puntosJugador < puntosCrupier && puntosCrupier <= 21) {
            System.out.println("Has perdido la apuesta de " + apuesta + "€");
            jugador.perder(apuesta);

            // registrar victoria del crupier
            victoriasCrupier++;
        }
        else {
            System.out.println("Empate. No se mueve el dinero.");
        }
    }
}