package grafos.msp;


import grafos.AristaP;
import grafos.Grafo;
import grafos.GrafoLista;
import grafos.ListaAbyacente;

import java.util.ArrayList;
import java.util.List;

public class Krustal {

    //O((a+n).log(n))
    public static GrafoLista krustal(Grafo grafo) {
        GrafoLista resultado = new ListaAbyacente(grafo.cantNodos());
        List<AristaP> lista = new ArrayList<>();
        UnionFind[] set = new UnionFind[grafo.cantNodos()];

        for (int desde = 0; desde < grafo.cantNodos(); desde++) {
            set[desde] = new UnionFind(desde);

            List<Integer> aristas = grafo.getIdDeLasAristasDe(desde);

            for (Integer hasta : aristas) {
                Double costo = grafo.getCostoArista(desde, hasta);
                lista.add(new AristaP(desde, hasta, costo));
            }

            lista.sort(AristaP::compareTo);

            for (AristaP current : lista) {
                int desde2 = current.getDesde();
                int hasta2 = current.getHasta();

                if (!set[desde2].find().equals(set[hasta2].find())) {
                    resultado.setArista(desde2, hasta2, current.getCosto());
                    set[desde2].union(set[hasta2]);
                }
            }

        }
        return resultado;
    }

}
