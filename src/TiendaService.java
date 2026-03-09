import java.util.ArrayList;
import java.util.List;

public class TiendaService {

    private List<Material> materiales = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Compra> compras = new ArrayList<>();

    public void registrarMaterial(Material material) {
        materiales.add(material);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void mostrarMateriales() {
        for (Material m : materiales) {
            System.out.println(m.getInfo());
        }
    }

    public void mostrarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() +
                    " Nombre: " + u.getNombre() +
                    " Correo: " + u.getEmail());
        }
    }

    // Consultar materiales disponibles
    public void consultarMaterialesDisponibles() {

        System.out.println("\nMateriales disponibles:");

        for (Material m : materiales) {

            if (m instanceof Comprable) {

                Comprable c = (Comprable) m;

                if (c.estaDisponible()) {
                    System.out.println(m.getInfo());
                }
            }
        }
    }

    // Consultar materiales comprados
    public void consultarMaterialesComprados() {

        System.out.println("\nMateriales comprados:");

        for (Material m : materiales) {

            if (m instanceof Comprable) {

                Comprable c = (Comprable) m;

                if (!c.estaDisponible()) {
                    System.out.println(m.getInfo());
                }
            }
        }
    }

    public void realizarCompra(int idUsuario, int idMaterial) {

        Usuario usuarioComprador = null;
        Material materialComprado = null;

        for (Usuario u : usuarios) {
            if (u.getId() == idUsuario) {
                usuarioComprador = u;
                break;
            }
        }

        for (Material m : materiales) {

            if (m instanceof Comprable) {

                Comprable c = (Comprable) m;

                if (m.getId() == idMaterial && c.estaDisponible()) {
                    materialComprado = m;
                    break;
                }
            }
        }

        if (usuarioComprador != null && materialComprado != null) {

            ((Comprable) materialComprado).comprar();

            compras.add(new Compra(usuarioComprador, materialComprado, 1));

            System.out.println("Compra exitosa: " +
                    usuarioComprador.getNombre() +
                    " compró ID: " +
                    materialComprado.getId());

        } else {

            System.out.println("Error: Usuario no encontrado o material no disponible.");
        }
    }

    public void realizarReembolso(int idMaterial) {

        Compra compraARemover = null;

        for (Compra c : compras) {

            if (c.getMaterial().getId() == idMaterial) {
                compraARemover = c;
                break;
            }
        }

        if (compraARemover != null) {

            if (compraARemover.getMaterial() instanceof Comprable) {

                ((Comprable) compraARemover.getMaterial()).reembolsar();

                compras.remove(compraARemover);

                System.out.println("Reembolso procesado correctamente.");
            }

        } else {

            System.out.println("Error: No hay compra asociada a ese material.");
        }
    }
}


