package Clases;

import java.util.Scanner;

public class Partida {

    private Mazo mazo;
    private Jugador crupier;
    private Jugador jugador;

<<<<<<< HEAD
    private Scanner teclado= new Scanner(System.in);
    public void crearjugador(Jugador tipoJugador) {

        teclado.nextLine(); // limpiar buffer

        System.out.print("Introduce nombre: ");
        String nombre = teclado.nextLine();

        if (tipoJugador == jugador) {
            jugador = new Jugador(nombre, Tipo.JUGADOR);
            System.out.println("Jugador creado correctamente.\n");
        } else {
            cuprier = new Jugador(nombre, Tipo.CUPRIER);
            System.out.println("Crupier creado correctamente.\n");
        }
    }

    private void mostrarFondos() {
        System.out.print("\nTipo (1=CABALLERO, 2=MAGO, 3=ORCO): ");
        int t = teclado.nextInt();
        teclado.nextLine();

        Tipo tipo = switch (t) {
            case 1 -> Tipo.JUGADOR;
            case 2 -> Tipo.CUPRIER;
            default -> null;    
        };

        if (jugador == null || cuprier == null) {
            System.out.println("Primero debes crear jugador y crupier.");
            return;
=======
    private Scanner teclado = new Scanner(System.in);

    public void crearJugador(Tipo tipo) {

        teclado.nextLine();
        System.out.print("Introduce el nombre: ");
        String nombre = teclado.nextLine();

        if (tipo == Tipo.JUGADOR) {
            jugador = new Jugador(nombre, Tipo.JUGADOR);
            System.out.println("Jugador creado.");
        } else {
            crupier = new Jugador(nombre, Tipo.CRUPIER);
            System.out.println("Crupier creado.");
>>>>>>> main
        }

        System.out.println("\n--- Fondos actuales ---");
        System.out.println("Jugador: " + jugador.getDinero() + "€");
        System.out.println("Crupier: " + cuprier.getDinero() + "€\n");
    }

    public void getFondos() {
        System.out.println("Presiona 1 si eres jugador, presiona 2 si eres cuprier");
        int tipo = teclado.nextInt();
        if (tipo == 1) {
            System.out.println(jugador.getDinero());
        } else if (tipo == 2) {
            System.out.println(crupier.getDinero());
        } else {
            System.out.print("Ha introducido una opcion incorrecta");
        }
    }

    public void iniciapartida() {
        mazo = new Mazo();
        mazo.barajar();
        
        while (jugador.getDinero()>0 && crupier.getDinero()>0) {
            
        }

    }

    public void mostrarmenu() {

        int opcion;
        do {
            System.out.println("Introduzca una opcion o 0 para salir");
            System.out.println("0. Salir");
            System.out.println("1. Añadir jugador");
            System.out.println("2. Añadir crupier");
            System.out.println("3. Mostrar fondos");
            System.out.println("4. Iniciar partida");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
<<<<<<< HEAD
                    crearjugador(jugador);
                    break;
                case 2:
                    crearjugador(cuprier);
=======
                    crearJugador(Tipo.JUGADOR);
                    break;
                case 2:
                    crearJugador(Tipo.CRUPIER);
>>>>>>> main
                    break;
                case 3:
                    getFondos();
                    break;
                case 4:
                    iniciapartida();
            }
        } while (opcion != 0 &&
                jugador != null &&
                jugador.getDinero() > 0 &&
                (crupier == null || crupier.getDinero() > 0));

    }

}
