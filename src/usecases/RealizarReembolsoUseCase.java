package usecases;

import creacionUsuariosYMateriales.Compra;
import creacionUsuariosYMateriales.Material;
import java.util.List;

public class RealizarReembolsoUseCase {

    private final List<Compra> compras;

    public RealizarReembolsoUseCase(List<Compra> compras) {
        this.compras = compras;
    }

    public void ejecutar(int idMaterial) {

        Compra compraARemover = null;

        for (Compra c : compras) {

            if (c.getMaterial().getId() == idMaterial) {
                compraARemover = c;
                break;
            }

        }

        if (compraARemover != null) {

            Material m = compraARemover.getMaterial();

            m.disponible = true;   // vuelve a estar disponible

            compras.remove(compraARemover);

            System.out.println("Reembolso procesado correctamente.");

        } else {

            System.out.println("Error: No hay compra asociada a ese material.");

        }

    }
}