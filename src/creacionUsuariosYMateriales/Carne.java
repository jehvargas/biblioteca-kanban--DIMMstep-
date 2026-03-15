package creacionUsuriosYMateriles;


public class Carne extends Material implements Comprable {

    private String nombre;
    private String fechaVencimiento;

    public Carne(String nombre, String fecha, int valor) {
        super("creacionUsuriosYMateriles.Carne", valor);
        this.nombre = nombre;
        this.fechaVencimiento = fecha;
    }

    @Override
    public void comprar() {
        disponible = false;
        System.out.println("creacionUsuriosYMateriles.Carne comprada: " + nombre);
    }

    @Override
    public boolean estaDisponible() {
        return disponible;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " Nombre: " + nombre;
    }
}
