package Clases;

import java.util.Scanner;

public class Partida {
    Mazo mazo;
    Jugador jugador;


    public void iniciapartida(){

    }
    public void mostrarmenu(){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Introduzca una opcion o 0 para salir");
            System.out.println("0. Salir");
            System.out.println("1. Añadir jugador");
            System.out.println("2. Añadir cuprier");
            System.out.println("3. Mostrar todos los jugadores");
            System.out.println("4. Iniciar partida");
            opcion = teclado.nextInt();
            switch(opcion) {
                case 1:
                    String nombrejugador=teclado.nextLine();
                    Jugador jugador=new Jugador(nombrejugador, Tipo.JUGADOR);
                    break;
                case 2:
                    String nombrecuprier=teclado.nextLine();
                    Jugador cuprier=new Jugador(nombrecuprier, Tipo.CUPRIER);

                    break;
                case 3:
                    mostrarmenu();
                    break;
                case 4:
                    iniciapartida();
            }
        }while(opcion!=0 && jugador.getFondos()>0);

    }
}

