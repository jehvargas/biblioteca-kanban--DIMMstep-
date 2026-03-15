package usecases;

import java.util.List;
import creacionUsuariosYMateriales.CalculadoraCosto;
import creacionUsuariosYMateriales.Compra;
import creacionUsuariosYMateriales.Comprable;
import creacionUsuariosYMateriales.Material;
import creacionUsuariosYMateriales.Usuario;

public class RealizarCompraUseCase {

    private final List<Material> materiales;
    private final List<Usuario> usuarios;
    private final List<Compra> compras;

    public RealizarCompraUseCase(List<Material> materiales, List<Usuario> usuarios, List<Compra> compras) {
        this.materiales = materiales;
        this.usuarios = usuarios;
        this.compras = compras;
    }

    public void ejecutar(int idUsuario, int idMaterial) {
        Usuario usuarioComprador = null;
        Material materialComprado = null;

        for (Usuario u : usuarios) {
            if (u.getId() == idUsuario) { usuarioComprador = u; break; }
        }

        for (Material m : materiales) {
            if (m.getId() == idMaterial && m.isDisponible()) { materialComprado = m; break; }
        }

        if (usuarioComprador != null && materialComprado != null) {
            ((Comprable) materialComprado).comprar();
            compras.add(new Compra(usuarioComprador, materialComprado, 1));

            int costoFinal = CalculadoraCosto.calcularCosto(materialComprado.getValor());
            System.out.println("Compra exitosa: " + usuarioComprador.getNombre()
                    + " compró " + materialComprado.getTipo()
                    + " ID:" + materialComprado.getId());
            System.out.println("Costo final con impuesto: " + costoFinal);
        } else {
            System.out.println("Error: Usuario no encontrado o material no disponible.");
        }
    }
}
