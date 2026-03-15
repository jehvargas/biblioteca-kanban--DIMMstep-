package creacionUsuariosYMateriales;

import java.util.ArrayList;
import java.util.List;

public class TiendaService {

    private List<Material> materiales = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Compra> compras = new ArrayList<>();


    // Registrar material
    public void registrarMaterial(Material material) {
        materiales.add(material);
    }


    // Registrar usuario
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }


    // Mostrar materiales
    public void mostrarMateriales() {
        for (Material m : materiales) {
            System.out.println(m.getInfo());
        }
    }


    // Mostrar usuarios
    public void mostrarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println(
                    "ID: " + u.getId() +
                            " Nombre: " + u.getNombre() +
                            " Correo: " + u.getEmail()
            );
        }
    }


    // Consultar materiales disponibles
    public void consultarMaterialesDisponibles() {

        System.out.println("\nMateriales disponibles:");

        boolean hay = false;

        for (Material m : materiales) {

            if (m instanceof Comprable) {

                Comprable c = (Comprable) m;

                if (c.estaDisponible()) {
                    System.out.println(m.getInfo());
                    hay = true;
                }

            }
        }

        if (!hay) {
            System.out.println("No hay materiales disponibles.");
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


    // Realizar compra
    public void realizarCompra(int idUsuario, int idMaterial) {

        Usuario usuarioComprador = null;
        Material materialComprado = null;

        // Buscar usuario
        for (Usuario u : usuarios) {

            if (u.getId() == idUsuario) {
                usuarioComprador = u;
                break;
            }

        }

        // Buscar material
        for (Material m : materiales) {

            if (m.getId() == idMaterial && m.isDisponible()) {
                materialComprado = m;
                break;
            }

        }

        if (usuarioComprador != null && materialComprado != null) {

            ((Comprable) materialComprado).comprar();

            compras.add(new Compra(usuarioComprador, materialComprado, 1));

            System.out.println(
                    "Compra exitosa: "
                            + usuarioComprador.getNombre()
                            + " compró "
                            + materialComprado.getTipo()
                            + " ID:" + materialComprado.getId()
            );

        } else {

            System.out.println("Error: Usuario no encontrado o material no disponible.");

        }

    }


    // Reembolso
    public void realizarReembolso(int idMaterial) {

        Compra compraARemover = null;

        for (Compra c : compras) {

            if (c.getMaterial().getId() == idMaterial) {
                compraARemover = c;
                break;
            }

        }

        if (compraARemover != null) {

            ((Comprable) compraARemover.getMaterial()).comprar();
            compras.remove(compraARemover);

            System.out.println("Reembolso procesado correctamente.");

        } else {

            System.out.println("Error: No hay compra asociada a ese material.");

        }

    }


    // Mostrar costo total de compras
    public void mostrarCostoTotalCompras() {

        System.out.println("\n--- Costo total de compras ---");

        for (Compra c : compras) {

            int precio = c.getMaterial().getValor();

            System.out.println(
                    "Material: " + c.getMaterial().getTipo() +
                            " | Precio: " + precio
            );

        }

    }

}