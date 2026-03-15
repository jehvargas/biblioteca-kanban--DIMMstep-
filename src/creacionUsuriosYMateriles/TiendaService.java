package creacionUsuriosYMateriles;

import java.util.ArrayList;
import java.util.List;
import usecases.RealizarCompraUseCase;
import usecases.RealizarReembolsoUseCase;

public class TiendaService {

    private List<Material> materiales = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Compra> compras = new ArrayList<>();

    private RealizarCompraUseCase compraUseCase = new RealizarCompraUseCase(materiales, usuarios, compras);
    private RealizarReembolsoUseCase reembolsoUseCase = new RealizarReembolsoUseCase(compras);


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

    public void realizarCompra(int idUsuario, int idMaterial) {
        compraUseCase.ejecutar(idUsuario, idMaterial);
    }

    public void realizarReembolso(int idMaterial) {
        reembolsoUseCase.ejecutar(idMaterial);
    }

    public void consultarMaterialesComprados() {
        if (compras.isEmpty()) {
            System.out.println("No hay materiales comprados.");
        } else {
            System.out.println("Materiales comprados:");
            for (Compra c : compras) {
                System.out.println(c.getMaterial().getInfo() + " Comprado por: " + c.getUsuario().getNombre());
            }
        }
    }

    public void consultarMaterialesDisponibles() {
        System.out.println("Materiales disponibles:");
        for (Material m : materiales) {
            if (m.isDisponible()) {
                System.out.println(m.getInfo());
            }
        }
    }

    public void mostrarCostoTotalCompras() {
        int total = 0;
        for (Compra c : compras) {
            total += CalculadoraCosto.calcularCosto(c.getMaterial().getValor());
        }
        System.out.println("Costo total de compras: " + total);
    }
}
