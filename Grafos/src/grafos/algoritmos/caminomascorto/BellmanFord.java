package grafos.algoritmos.caminomascorto;

import grafos.AristaP;
import grafos.Grafo;
import grafos.GrafoRuntimeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    private Integer[] antecesores;

    public double[] bellmanFord(Grafo grafo, int raizInicial) {
        double[] costos = new double[grafo.cantNodos()];
        antecesores = new Integer[grafo.cantNodos()];

        inicializarArrays(grafo, raizInicial, costos);
        List<AristaP> aristas = grafo.getTodasLasAristas();
        relajarAristas(grafo, aristas, costos);
        detectarCiclosNegativos(grafo, aristas, costos);

        return costos;
    }

    private void relajarAristas(Grafo grafo, List<AristaP> aristas, double[] costos) {
        System.out.println("Empezamos con la relajación de los nodos");
        for (int i = 0; i < grafo.cantNodos() - 1; i++) {

            for (AristaP arista : aristas) {
                double nuevoCosto = costos[arista.getDesde()] + arista.getCosto();
                if (nuevoCosto < costos[arista.getHasta()]) {
                    costos[arista.getHasta()] = nuevoCosto;
                    antecesores[arista.getHasta()] = arista.getDesde();
                }
            }
            System.out.println("Iteracion: "+ i);
            System.out.println(Arrays.toString(costos));
        }
    }

    private void detectarCiclosNegativos(Grafo grafo, List<AristaP> aristas, double[] costos) {
        System.out.println("Detectamos ciclos negativos");
        for(int i = 0; i< grafo.cantNodos()-1; i++)
        {
            for(AristaP arista: aristas){
                double nuevoCosto = costos[arista.getDesde()] + arista.getCosto();
                if(nuevoCosto < costos[arista.getHasta()]){
                    costos[arista.getHasta()] = Double.NEGATIVE_INFINITY;
                    antecesores[arista.getHasta()]= arista.getDesde();
                }
            }

            System.out.println("Iteracion: "+ i);
            System.out.println(Arrays.toString(costos));
        }
    }


    private void inicializarArrays(Grafo grafo, int raizInicial, double[] costos) {
        for (int i = 0; i < grafo.cantNodos(); i++) {
            costos[i] = Double.POSITIVE_INFINITY;
            antecesores[i] = null;
        }
        costos[raizInicial] = (double) 0;
    }


    public Integer[] getAntecesores() {
        return this.antecesores;
    }

}
