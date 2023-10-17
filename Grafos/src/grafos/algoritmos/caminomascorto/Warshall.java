package grafos.algoritmos.caminomascorto;

import grafos.Grafo;

public class Warshall {
    public static boolean[][] warshall(Grafo grafo) {
        boolean[][] result = new boolean[grafo.cantNodos()][grafo.cantNodos()];


        for (int i = 0; i < result.length; i++)
            for (int j = 0; j < result.length; j++) {
                Double costo = grafo.getCostoArista(i, j);
                result[i][j] = (costo != null);
            }

        for (int k = 0; k < result.length; k++) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = (result[i][j] || (result[i][k] && result[k][j]));
                }
            }
        }

        return result;
    }
}
