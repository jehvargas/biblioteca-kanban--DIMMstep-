package creacionUsuriosYMateriles;

public class Compra {

    private Usuario usuario;
    private Material material;
    private int cantidad;

    public Compra(Usuario usuario, Material material, int cantidad) {
        this.usuario = usuario;
        this.material = material;
        this.cantidad = cantidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Material getMaterial() {
        return material;
    }

    public int getCantidad() {
        return cantidad;
    }
}
