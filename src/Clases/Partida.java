package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Partida {

    private Mazo mazo;
    private Jugador crupier=new Jugador(null, Tipo.CRUPIER);
    private Jugador jugador=new Jugador(null, Tipo.JUGADOR);

    private Scanner teclado= new Scanner(System.in);
    public void crearjugador(Jugador jugador1){
        teclado.nextLine();
       
        if (jugador1==jugador) {
            System.out.print("Introduzca el nombre: ");
            String nombrejugador=teclado.nextLine();
            jugador.setNombre(nombrejugador);
        }
        else{
            System.out.print("Introduzca el nombre: ");
            String nombrecuprier=teclado.nextLine();
            crupier.setNombre(nombrecuprier);
        }
    }
    public void getFondos(){
        System.out.println("Presiona 1 si eres jugador, presiona 2 si eres cuprier");
        int tipo=teclado.nextInt() ;
        if (tipo==1) {
            System.out.println(jugador.getDinero());
        }
        else if (tipo==2) {
            System.out.println(crupier.getDinero());
        }
        else{
            System.out.print("Ha introducido una opcion incorrecta");
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
            System.out.println("2. Añadir crupier");
            System.out.println("3. Mostrar fondos");
            System.out.println("4. Iniciar partida");
            opcion = teclado.nextInt();
            switch(opcion) {
                case 1:
                    crearjugador(jugador);
                    System.out.println(jugador.toString());
                    break;
                case 2:
                    crearjugador(crupier);
                    System.out.println(crupier.toString());
                    break;
                case 3:
                    getFondos();
                    break;
                case 4:
                    iniciapartida();
            }
        }while(opcion!=0 && jugador.getDinero()>0 && crupier.getDinero()>0);


    }
}
