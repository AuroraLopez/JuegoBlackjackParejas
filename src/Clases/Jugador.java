package Clases;

public class Jugador {
    private String nombre;
    private int dinero = 100;
    private Tipo tipo;

    public Jugador(String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", dinero=" + dinero +
                ", tipo=" + tipo +
                '}';
    }
}
