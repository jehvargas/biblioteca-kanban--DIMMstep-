package usecases;

import creacionUsuariosYMateriales.Material;
import creacionUsuariosYMateriales.TiendaService;

public class RegistrarMaterialUseCase {

    private TiendaService tienda;

    public RegistrarMaterialUseCase(TiendaService tienda) {
        this.tienda = tienda;
    }

    public void ejecutar(Material material) {

        tienda.registrarMaterial(material);

        System.out.println("Material registrado correctamente.");
    }
}