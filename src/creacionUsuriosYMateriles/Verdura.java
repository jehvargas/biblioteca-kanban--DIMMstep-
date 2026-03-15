package creacionUsuriosYMateriles;

public class Verdura extends Material implements Comprable {

    private String nombre;

    public Verdura(String nombre, int valor) {
        super("creacionUsuriosYMateriles.Verdura", valor);
        this.nombre = nombre;
    }

    @Override
    public void comprar() {
        disponible = false;
        System.out.println("creacionUsuriosYMateriles.Verdura comprada: " + nombre);
    }

    @Override
    public boolean estaDisponible() {
        return disponible;
    }

    @Override
    public void reembolsar() {
        disponible = true;
        System.out.println("Verdura reembolsada: " + nombre);
    }
}
