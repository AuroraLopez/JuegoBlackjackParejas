public class Jugador {

    private String nombre;
    private int dinero = 100;
    private Mano mano = new Mano();

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void reiniciarMano() {
        mano = new Mano();
    }

    public Mano getMano() {
        return mano;
    }

    public int getDinero() {
        return dinero;
    }

    public void ganar(int cantidad) {
        dinero += cantidad;
    }

    public void perder(int cantidad) {
        dinero -= cantidad;
    }

    public String getNombre() {
        return nombre;
    }
}
