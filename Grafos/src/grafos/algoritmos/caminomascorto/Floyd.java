package grafos.algoritmos.caminomascorto;

import grafos.Grafo;

public class Floyd {
    public static double[][] floyd(Grafo grafo) {
        double[][] result = new double[grafo.cantNodos()][grafo.cantNodos()];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                Double costo = grafo.getCostoArista(i, j);
                result[i][j] = (costo != null) ? costo : Double.POSITIVE_INFINITY;
            }
            result[i][i] = 0;
        }


        for (int k = 0; k < result.length; k++) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    double costo = result[i][k] + result[k][j];
                    result[i][j] = Math.min(costo, result[i][j]);
                }
            }
        }
        return result;
    }

}
