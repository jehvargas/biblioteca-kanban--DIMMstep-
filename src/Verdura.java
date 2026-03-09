public class Verdura extends Material implements Comprable {

    private String nombre;

    public Verdura(String nombre, int valor) {
        super("Verdura", valor);
        this.nombre = nombre;
    }

    @Override
    public void comprar() {
        disponible = false;
        System.out.println("Verdura comprada: " + nombre);
    }

    @Override
    public boolean estaDisponible() {
        return disponible;
    }

    @Override
    public void reembolsar() {
        disponible = true;
        System.out.println("Se ha reembolsado y devuelto al inventario.");
    }
}
