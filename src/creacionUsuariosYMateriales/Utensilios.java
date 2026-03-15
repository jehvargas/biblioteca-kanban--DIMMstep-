package creacionUsuariosYMateriales;

public class Utensilios extends Material implements Comprable {

    private int cantidad;

    public Utensilios(int cantidad, int valor) {
        super("Utensilios", valor);
        this.cantidad = cantidad;
    }

    @Override
    public void comprar() {
        disponible = false;
        System.out.println("Utensilios comprados");
    }

    @Override
    public boolean estaDisponible() {
        return disponible;
    }
}
