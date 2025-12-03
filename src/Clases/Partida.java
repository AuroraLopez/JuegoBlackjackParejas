package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Partida {

<<<<<<< HEAD
    
=======
    Mazo mazo;
    Jugador jugador;
    Jugador cuprier;

    private Scanner teclado= new Scanner(System.in);
    public void crearjugador(Jugador jugador1){
   
        String nombrejugador=teclado.nextLine();
        if (jugador1==jugador) {
            Jugador jugador=new Jugador(nombrejugador, Tipo.JUGADOR);
        }
        else{
            Jugador cuprier=new Jugador(nombrejugador, Tipo.CUPRIER);
        }
    }

    public void iniciapartida(){

    }
    public void mostrarmenu(){
        
        int opcion;
        do {
            System.out.println("Introduzca una opcion o 0 para salir");
            System.out.println("0. Salir");
            System.out.println("1. Añadir jugador");
            System.out.println("2. Añadir cuprier");
            System.out.println("3. Mostrar fondos");
            System.out.println("4. Iniciar partida");
            opcion = teclado.nextInt();
            switch(opcion) {
                case 1:
                    crearjugador(jugador);
                    System.out.println(jugador.toString());
                    break;
                case 2:
                    crearjugador(cuprier);
                    System.out.println(cuprier.toString());
                    break;
                case 3:
                    
                    break;
                case 4:
                    iniciapartida();
            }
        }while(opcion!=0 && jugador.getDinero()>0 && cuprier.getDinero()>0);


    }
>>>>>>> main
}
