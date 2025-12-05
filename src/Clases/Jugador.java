package Clases;


public class Jugador {

    private String nombre;
    private int dinero = 100;
    private Tipo tipo;
    private Mano mano = new Mano();

    // Constructor para jugador
    public Jugador(String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Metodos getter para metodos ajenos
    public Mano getMano() {
        return mano;
    }

    public int getDinero() {
        return dinero;
    }

        
    public String getNombre() {
        return nombre;
    }


    // Función para cuando ganas la apuesta
    public void ganar(int cantidad) {
        dinero += cantidad;
    }

    // Función para cuandon pierdes la apuesta
    public void perder(int cantidad) {
        dinero -= cantidad;
    }

    // Para que se quite todo de la mano
    public void resetearMano() {
        mano.limpiar();
    }

    // Imprimimos jugador
    @Override
    public String toString() {
        return nombre + " - Fondos: " + dinero + "€ - Mano: " + mano;
    }
}
