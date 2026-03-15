package creacionUsuriosYMateriles;

public class utensilios extends Material implements Comprable {

    private int cantidad;

    public utensilios(int cantidad, int valor) {
        super("creacionUsuriosYMateriles.utensilios", valor);
        this.cantidad = cantidad;
    }

    @Override
    public void comprar() {
        disponible = false;
        System.out.println("creacionUsuriosYMateriles.utensilios comprados");
    }

    @Override
    public boolean estaDisponible() {
        return disponible;
    }
}
