package grafos.msp;

import grafos.AristaP;
import grafos.Grafo;
import grafos.GrafoLista;
import grafos.ListaAbyacente;
import monticulo.ColaDePrioridad;
import monticulo.MonticuloMin;

import java.util.List;


/**
 * Minimum Spanning Tree (MSP), es un sub-grafo que busca conectar todos los
 * nodos del grafo de una forma tal que no contenga ciclos y tenga el menor
 * costo posible al recorrerlo.
 */
public class Prim {
    private double mstCost;
    private boolean[] visitados;

    public static GrafoLista prim(Grafo grafo, AristaP raiz) {
        GrafoLista resultado = new ListaAbyacente(grafo.cantNodos());

        double[] costos = new double[grafo.cantNodos()];
        boolean[] visitado = new boolean[grafo.cantNodos()];

        for (int i = 0; i < grafo.cantNodos(); i++)
            costos[i] = Double.POSITIVE_INFINITY;

        // Guardamos los Nodos a revisar en una Cola de Prioriridad para optimizar
        // el tiempo de busqueda para ir al siguiente nodo con el menor costo.
        ColaDePrioridad<AristaP> queue = new MonticuloMin<>();
        queue.insert(raiz);

        //O(n.log(n)) + O(a.log(n)) => O((n+a).log(n))
        while (!queue.isEmpty()) {
            AristaP current = queue.remove();
            int hasta = current.getHasta();
            visitado[hasta] = true;

            double minCosto = current.getCosto();

            if (minCosto < costos[hasta]) {
                costos[hasta] = minCosto;
                resultado.setArista(current.getDesde(), hasta, minCosto);
            }

            List<Integer> aristas = grafo.getIdDeLasAristasDe(hasta);//O(n)

            for (Integer arista : aristas) { //O(a)
                if (!visitado[arista]) {
                    Double costo = grafo.getCostoArista(hasta, arista);
                    queue.insert(new AristaP(hasta, arista, costo)); //(log(n))
                }
            }
        }

        return resultado;
    }

    public GrafoLista prim2(Grafo grafo, AristaP raiz) {
        GrafoLista resultado = new ListaAbyacente(grafo.cantNodos());
        this.mstCost = 0;
        int contAristas = 0;
        int cantAristas = grafo.cantNodos() - 1;
        ColaDePrioridad<AristaP> pq = new MonticuloMin<>();

        addVertices(raiz.getDesde(), grafo, pq);

        while (!pq.isEmpty() && contAristas != cantAristas) {
            AristaP arista = pq.remove();
            int hasta = arista.getHasta();

            if (visitados[hasta])
                continue;

            resultado.setArista(arista.getDesde(), arista.getHasta(), arista.getCosto());
            contAristas++;
            this.mstCost += arista.getCosto();

            addVertices(hasta, grafo, pq);
        }

        if (contAristas != cantAristas) {
            this.mstCost = 0;
            return null;
        }

        return resultado;
    }

    private void addVertices(int desde, Grafo grafo, ColaDePrioridad<AristaP> pq) {
        visitados[desde] = true;

        List<Integer> aristas = grafo.getIdDeLasAristasDe(desde);

        for (Integer arista : aristas) {
            if (!visitados[arista])
                pq.insert(new AristaP(desde, arista, grafo.getCostoArista(desde, arista)));

        }

    }

    public double getMstCost() {
        return this.mstCost;

    }
}
