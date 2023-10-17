package grafos;

import java.util.List;

public interface Grafo {

    /**
     * Cantidad de nodos que posee el grafo
     *
     * @return int - Cantidad de nodos
     */
    int cantNodos();

    /**
     * El costo del grafo
     * Es la suma del peso de todas las aristas del grafo
     *
     * @return double - Costo del grafo
     */
    Double costoDelGrafo();

    /**
     * Cantidad de vertices que posee el grafo
     * @return int - Cantidad de vertices
     */
    int cantVertices();

    /**
     * Crea una arista en el grafo desde el nodo desde hasta el nodo hasta
     *
     * @param desde  - int
     * @param hasta - int
     * @param costo   - double
     */
    void setArista(int desde, int hasta, double costo);


    /**
     * Obtiene el costo de una Arista desde el Nodo Desde hasta el Nodo Hasta
     *
     * @param desde  - int
     * @param hasta - int
     * @return - Double
     */
    Double getCostoArista(int desde, int hasta);

    /**
     * Obtiene el id de todos los nodos hasta que tienen una arista con id nodo desde
     * @param desde
     * @return List<Integer> aristas
     */
    List<Integer> getIdDeLasAristasDe(int desde);


    /**
     * Obtiene todas las aristas del grafo
     * @return List<AristaP> aristas
     */
    List<AristaP> getTodasLasAristas();


}
