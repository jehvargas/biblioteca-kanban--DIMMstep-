package creacionUsuriosYMateriles;

public abstract class Material {

    protected static int contador = 1;

    protected int id;
    protected String tipo;
    protected int valor;
    protected boolean disponible;

    public Material(String tipo, int valor) {
        this.id = contador++;
        this.tipo = tipo;
        this.valor = valor;
        this.disponible = true;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getInfo() {
        return "ID: " + id + " Tipo: " + tipo + " Valor: " + valor;
    }
}
