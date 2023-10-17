package grafos;

import java.util.Objects;

public class MatrizAdyacenteNoDirigida extends MatrizAdyacente {
    public MatrizAdyacenteNoDirigida(Double[][] grafo) {
        super(grafo);
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++) {
                if (!Objects.equals(grafo[i][j], grafo[j][i])) {
                    throw new GrafoRuntimeException("El grafo no es No Dirigido! " + "i: " + i + " j: " + j + " " + grafo[i][j] + " != " + grafo[j][i] + " j: " + j + " i: " + i);
                }
            }
        }
    }

    public MatrizAdyacenteNoDirigida(int size) {
        super(size);
    }


    /**
     * Crea una arista en el grafo desde el nodo desde hasta el nodo hasta
     * Al ser no dirigida el valor en (i, j) y (j, i) pertenecen a la misma arista
     *
     * @param desde - int
     * @param hasta - int
     * @param costo - double
     */
    @Override
    public void setArista(int desde, int hasta, double costo) {
        grafo[desde][hasta] = costo;
        grafo[hasta][desde] = costo;
    }

    /**
     * El costo del grafo
     * Es la suma del peso de todas las aristas del grafo
     * El costo se divide por 2 porque el costo de (i, j) y (j, i)
     * pertenece a la misma arista
     *
     * @return double - Costo del grafo
     */
    @Override
    public Double costoDelGrafo() {
        return super.costoDelGrafo() / 2;

    }

    @Override
    public int cantVertices() {
        return super.cantVertices() / 2;
    }
}
