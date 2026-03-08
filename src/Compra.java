public class Compra {
    private Usuario usuario;
    private Material material;

    public Compra(Usuario usuario, Material material) {
        this.usuario = usuario;
        this.material = material;
    }

    public Usuario getUsuario() { return usuario; }
    public Material getMaterial() { return material; }
}