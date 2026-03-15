package usecases;

import creacionUsuariosYMateriales.TiendaService;

public class ConsultarComprasRealizadasUseCase {

    private TiendaService tienda;

    public ConsultarComprasRealizadasUseCase(TiendaService tienda) {
        this.tienda = tienda;
    }

    public void ejecutar() {
        tienda.consultarMaterialesComprados();
    }
}
