package Clases;

public class Jugador {
    private String nombre;
    private int fondos = 100;
    private Tipo tipo;

    public Jugador(String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public void apostar(int cantidad){
        this.fondos = fondos-cantidad;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getFondos() {
        return fondos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", fondos=" + fondos +
                ", tipo=" + tipo +
                '}';
    }
}
