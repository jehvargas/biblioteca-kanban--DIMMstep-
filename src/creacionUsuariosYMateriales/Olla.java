package creacionUsuariosYMateriales;

public class Olla extends Material implements Comprable {

    private int cantidad;

    public Olla(int cantidad, int valor) {
        super("Olla", valor);
        this.cantidad = cantidad;
    }

    @Override
    public void comprar() {
        disponible = false;
        System.out.println("Olla comprada");
    }

    @Override
    public boolean estaDisponible() {
        return disponible;
    }
}
