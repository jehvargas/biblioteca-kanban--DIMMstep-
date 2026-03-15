package usecases;

import creacionUsuariosYMateriales.Usuario;
import creacionUsuariosYMateriales.TiendaService;

public class RegistrarUsuarioUseCase {

    private TiendaService tienda;

    public RegistrarUsuarioUseCase(TiendaService tienda) {
        this.tienda = tienda;
    }

    public void ejecutar(String nombre, String email, int id) {

        Usuario usuario = new Usuario(nombre, email, id);

        tienda.registrarUsuario(usuario);

        System.out.println("Usuario registrado correctamente.");
    }
}