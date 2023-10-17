package grafos.busqueda;

import grafos.Grafo;

import java.util.List;
import java.util.LinkedList;

import java.util.Queue;


public class Bfs {
    public static void BFS(Grafo grafo, int root) {
        boolean[] visitado = new boolean[grafo.cantNodos()];
        Queue<Integer> queue = new LinkedList<>();

        visitado[root] = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int v = queue.poll();

            List<Integer> aristas = grafo.getIdDeLasAristasDe(v);

            for (Integer w : aristas) {
                if (!visitado[w]) {
                    visitado[w] = true;
                    queue.add(w);
                }
            }
        }
    }


}
