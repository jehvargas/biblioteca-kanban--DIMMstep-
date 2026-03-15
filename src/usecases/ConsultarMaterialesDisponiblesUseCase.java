package usecases;

import creacionUsuariosYMateriales.TiendaService;

public class ConsultarMaterialesDisponiblesUseCase {

    private TiendaService tienda;

    public ConsultarMaterialesDisponiblesUseCase(TiendaService tienda) {
        this.tienda = tienda;
    }

    public void ejecutar() {
        tienda.consultarMaterialesDisponibles();
    }
}
