package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrizAdyacente implements Grafo {
    protected Double[][] grafo;

    private static final double INFY = Double.POSITIVE_INFINITY;

    public MatrizAdyacente(Double[][] grafo) {
        this.grafo = grafo;
    }

    public MatrizAdyacente(int size) {
        this.grafo = new Double[size][size];
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++) {
                if (i == j) grafo[i][j] = 0.0;
                else grafo[i][j] = null;
            }
        }
    }


    @Override
    public int cantNodos() {
        return grafo.length;
    }

    @Override
    public Double costoDelGrafo() {
        double costo = 0;

        for (Double[] fila : grafo) {
            for (Double columna : fila) {
                costo += columna;
            }
        }
        return costo;
    }

    @Override
    public int cantVertices() {
        int cantidad = 0;

        for (Double[] fila : grafo) {
            for (Double columna : fila) {
                if (columna != INFY && columna != 0)
                    cantidad++;
            }
        }

        return cantidad;
    }

    @Override
    public void setArista(int desde, int hasta, double costo) {
        grafo[desde][hasta] = costo;
    }

    @Override
    public Double getCostoArista(int desde, int hasta) {
        return this.grafo[desde][hasta];
    }

    @Override
    public List<Integer> getIdDeLasAristasDe(int nodoId) {
        List<Integer> aristas = new ArrayList<>();
        for (int i = 0; i < grafo[nodoId].length; i++) {
            if (grafo[nodoId][i] != null) aristas.add(i);
        }
        return aristas;
    }

    @Override
    public List<AristaP> getTodasLasAristas() {
        List<AristaP> aristas = new ArrayList<>();


        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                if (grafo[i][j] != INFY && grafo[i][j] != 0)
                    aristas.add(new AristaP(i, j, grafo[i][j]));
            }
        }

        return aristas;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Double[] aristasDeUnNodo : grafo) {
            str.append(Arrays.toString(aristasDeUnNodo)).append("\n");
        }

        return str.toString();
    }

}
