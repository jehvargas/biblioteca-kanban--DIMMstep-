

import java.util.ArrayList;
import java.util.List;

public class TiendaService {

    private List<Material> materiales = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();


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
            System.out.println("ID: " + u.getId() + " Nombre: " + u.getNombre()+ " Correo:" + u.getEmail() );
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


    // Consultar materiales comprados (no disponibles)
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
}


