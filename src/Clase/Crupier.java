public class Crupier {

    private String nombre;
    private Mano mano = new Mano();

    public Crupier(String nombre) {
        this.nombre = nombre;
    }

    public void reiniciarMano() {
        mano = new Mano();
    }

    public Mano getMano() {
        return mano;
    }

    public String getNombre() {
        return nombre;
    }
}
