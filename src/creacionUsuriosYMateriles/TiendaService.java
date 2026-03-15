package creacionUsuriosYMateriles;

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
}
