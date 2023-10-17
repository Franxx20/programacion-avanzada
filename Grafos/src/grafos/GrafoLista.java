package grafos;

import java.util.Comparator;

public interface GrafoLista extends Grafo {
    /**
     * Asigna un nombre a todos los nodos del grafo, el String parametro tiene que ser del mismo tamaño
     * que el Grafo y los nombres son asignados de forma ascendente.
     *
     * @param nombres - String[
     * @throws GrafoRuntimeException Cuando el String[] parametro no es del mismo tamaño que el tamaño del grafo
     */
    void setNombres(String[] nombres);

    /**
     * Ordena el segun el comparador
     *
     * @param cmp - Comparator<Arista>
     */
    void sort(Comparator<AristaP> cmp);

}
