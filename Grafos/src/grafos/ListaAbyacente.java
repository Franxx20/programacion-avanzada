package grafos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListaAbyacente implements GrafoLista {
    protected List<AristaP>[] grafo;

    public ListaAbyacente(int size) {
        this.grafo = new List[size];
        for (int i = 0; i < grafo.length; i++) {
            this.grafo[i] = new ArrayList<>();
        }
    }

    public ListaAbyacente(AristaP[] grafo) {
        this(grafo.length);
        for (int i = 0; i < grafo.length; i++) {
            AristaP arista = grafo[i];
            this.setArista(arista.getDesde(), arista.getHasta(), arista.getCosto());
        }
    }

    @Override
    public int cantNodos() {
        return grafo.length;
    }

    @Override
    public Double costoDelGrafo() {
        double costo = 0;

        for (List<AristaP> aristasP : grafo) {
            for (AristaP n : aristasP) {
                if (n != null) {
                    costo += n.getCosto();
                }
            }
        }

        return costo;
    }

    @Override
    public int cantVertices() {
        int cantidad = 0;

        for (List<AristaP> aristasP : grafo) {
            for (AristaP n : aristasP) {
                if (n != null)
                    cantidad++;
            }
        }

        return cantidad;
    }

    @Override
    public void setArista(int desde, int hasta, double costo) {
        for (AristaP arista : grafo[desde]) {
            if (arista.getHasta() == hasta) {
                arista.setCosto(costo);
                return;
            }
        }
        grafo[desde].add(new AristaP(desde, hasta, costo));
    }

    @Override
    public Double getCostoArista(int desde, int hasta) {
        for (AristaP arista : grafo[desde]) {
            if (arista.getHasta() == hasta) return arista.getCosto();
        }

        return null;
    }

    @Override
    public List<Integer> getIdDeLasAristasDe(int origen) {
        List<Integer> aristas = new ArrayList<>();

        for (AristaP arista : grafo[origen]) {
            if (arista.getHasta() != origen) {
                aristas.add(arista.getHasta());
            }
        }
        return aristas;
    }

    @Override
    public List<AristaP> getTodasLasAristas() {
        List<AristaP> aristas = new ArrayList<>();

        for (List<AristaP> list : grafo) {
            for (AristaP arista : list) {
                aristas.add(arista);
            }
        }
        return aristas;
    }

    @Override
    public void setNombres(String[] nombres) {
        if (nombres.length != grafo.length) {
            throw new GrafoRuntimeException("Cantidad de nombres insuficiente para la cantidad de nodos disponibles.");
        }

        for (List<AristaP> list : grafo) {
            for (AristaP arista : list) {
                arista.setNombres(nombres[arista.getDesde()], nombres[arista.getHasta()]);
            }
        }

    }

    @Override
    public void sort(Comparator<AristaP> cmp) {
        for (List<AristaP> aristas : grafo) {
            aristas.sort(cmp);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        boolean first = true;

        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].size(); j++) {
                if (grafo[i].get(j).costo != 0) {
                    if (!first) {
                        str.append("\n");
                    }
                    str.append(grafo[i].get(j));
                    first = false;
                }
            }
        }

        return str.toString();
    }

    public int getGradoNodo(int origen) {
        return grafo[origen].size();
    }
}
