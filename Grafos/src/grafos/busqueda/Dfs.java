package grafos.busqueda;

import grafos.Grafo;

import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

public class Dfs {
    public static void DFS(Grafo grafo, int root) {
        boolean[] visitado = new boolean[grafo.cantNodos()];
        Deque<Integer> stack = new LinkedList<>();

        visitado[root] = true;
        stack.add(root);

        while (!stack.isEmpty()) {
            int v = stack.poll();

            List<Integer> aristas = grafo.getIdDeLasAristasDe(v);

            for (Integer w : aristas) {
                if (!visitado[w]) {
                    visitado[w] = true;
                    stack.add(w);
                }
            }
        }
    }
}
