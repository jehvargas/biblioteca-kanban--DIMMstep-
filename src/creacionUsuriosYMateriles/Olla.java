package creacionUsuriosYMateriles;

public class Olla extends Material implements Comprable {

    private int cantidad;

    public Olla(int cantidad, int valor) {
        super("creacionUsuriosYMateriles.Olla", valor);
        this.cantidad = cantidad;
    }

    @Override
    public void comprar() {
        disponible = false;
        System.out.println("creacionUsuriosYMateriles.Olla comprada");
    }

    @Override
    public boolean estaDisponible() {
        return disponible;
    }

    @Override
    public void reembolsar() {
        disponible = true;
        System.out.println("Olla reembolsada");
    }
}
