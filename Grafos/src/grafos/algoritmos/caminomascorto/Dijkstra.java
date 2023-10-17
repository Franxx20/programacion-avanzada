package grafos.algoritmos.caminomascorto;

import grafos.AristaP;
import grafos.Grafo;
import monticulo.*;

import java.util.List;


public class Dijkstra {
    private int[] antecesores;

    public double[] dijkstra(Grafo grafo, int raizInicial) {
        Boolean[] visitados = new Boolean[grafo.cantNodos()];
        double[] costos = new double[grafo.cantNodos()];
        ColaDePrioridad<AristaP> queue;
        queue = new MonticuloMin<>();
        this.antecesores = new int[grafo.cantNodos()];


        for (int i = 0; i < grafo.cantNodos(); i++) {
            costos[i] = Double.POSITIVE_INFINITY;
            visitados[i] = false;
            antecesores[i] = raizInicial;
        }

        costos[raizInicial] = 0;
        visitados[raizInicial] = true;

        queue.insert(new AristaP(raizInicial, costos[raizInicial]));

        while (!queue.isEmpty()) {
            AristaP actual = queue.remove();
            int hasta = actual.getHasta();
            visitados[hasta] = true;

            List<Integer> aristas = grafo.getIdDeLasAristasDe(hasta);


            for (Integer arista : aristas) {
                Double costo = grafo.getCostoArista(hasta, arista);

                // si el nodo no fue visitado aun
                if (Boolean.FALSE.equals(visitados[arista])) {
                    double nuevoCosto = costo + actual.getCosto();
                    if (nuevoCosto < costos[arista]) {
                        queue.insert(new AristaP(hasta, arista, nuevoCosto));
                        antecesores[arista] = hasta;
                        costos[arista] = nuevoCosto;
                    }
                }
            }
        }
        return costos;
    }

    public int[] getAntecesores() {
        return this.antecesores;
    }


}
