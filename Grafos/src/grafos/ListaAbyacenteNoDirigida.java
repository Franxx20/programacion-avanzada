package grafos;

public class ListaAbyacenteNoDirigida extends ListaAbyacente {
    public ListaAbyacenteNoDirigida(int size) {
        super(size);
    }

    public ListaAbyacenteNoDirigida(AristaP[] grafo) {
        this(grafo.length);
    }

    @Override
    public void setArista(int desde, int hasta, double costo) {
        super.setArista(desde, hasta, costo);
        super.setArista(hasta, desde, costo);
    }

    @Override
    public Double costoDelGrafo() {
        return super.costoDelGrafo() / 2;
    }

    @Override
    public int cantVertices() {
        return super.cantVertices() / 2;
    }

}
