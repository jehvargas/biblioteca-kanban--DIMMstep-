package creacionUsuriosYMateriles;

public class Usuario {

    //private static int contador = 1;

    private int id;
    private String nombre;
    private String email;

    public Usuario(String nombre, String email,int id) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
