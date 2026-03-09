public class CalculadoraCosto {

    public static int calcularCosto(int precioMaterial) {

        int costo = precioMaterial;

        // regla básica: impuesto del 10%
        int impuesto = precioMaterial / 10;

        costo += impuesto;

        return costo;
    }
}
