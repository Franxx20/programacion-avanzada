package grafos;

public class Nodo {
    private int id;
    private String nombre;

    public Nodo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Nodo(int id){
        this.id = id;
        this.nombre = String.valueOf(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
