package grafos.algoritmos.caminomascorto;

import grafos.AristaP;
import grafos.Grafo;
import grafos.GrafoRuntimeException;

import java.util.List;

public class BellmanFord {
    private int[] antecesores;

    public double[] bellmanFord(Grafo grafo, int raizInicial) {
        double[] costos = new double[grafo.cantNodos()];
        antecesores = new int[grafo.cantNodos()];

        for (int i = 0; i < grafo.cantNodos(); i++) {
            costos[i] = Double.POSITIVE_INFINITY;
            antecesores[i] = raizInicial;
        }

        costos[raizInicial] = 0;
        int i = 0;

        List<AristaP> aristas = grafo.getTodasLasAristas();
        for (; i < grafo.cantNodos() - 1; i++) {

            for (AristaP arista : aristas) {
                double nuevoCosto = costos[arista.getDesde()] + arista.getCosto();
                if (nuevoCosto < costos[arista.getHasta()]) {
                    costos[arista.getHasta()] = nuevoCosto;
                    antecesores[arista.getHasta()] = arista.getDesde();
                }
            }
        }

        // detectar ciclos negativos
        for (AristaP arista : aristas) {
            double nuevoCosto = costos[arista.getDesde()] + arista.getCosto();
            if (nuevoCosto < costos[arista.getHasta()]) {
                throw new GrafoRuntimeException("Se detecto un ciclo negativo!");
            }
        }

        return costos;
    }


    public int[] getAntecesores() {
        return this.antecesores;
    }
}
