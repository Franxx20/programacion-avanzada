package monticulo;

import java.util.List;

public interface ColaDePrioridad<T extends Comparable<? super T>> {
    /**
     * Inserta un elemento en el montículo
     *
     * @param item
     */
    public void insert(T item);

    /**
     * Retorna el elemento en el tope del montículo
     *
     * @return T item
     */
    public T peekTop();

    /**
     * Elimina el elemento en el tope del montículo y lo retorna.
     *
     * @return T item
     */
    public T remove();

    /**
     * Busca el item en el montículo y retorna su indice
     *
     * @param item
     * @return Indice del item buscado o -1 si el item no existe en el montículo
     */
    public int indexOf(T item);

    /**
     * Retorna la cantidad de elementos del montículo
     *
     * @return cantidad de items
     */
    public int size();


    /**
     * Checkea si el montículo esta vacio o no
     *
     * @return returna true si el montículo esta vacio y false en caso contrario
     */
    public boolean isEmpty();


    /**
     * Retorna una copia de un array T de elementos
     *
     * @return T[]
     */
    public T[] getMonticulo();

    /**
     * Retorna una copia de una lista T de elementos
     *
     * @return List<T>
     */
    public List<T> getMonticuloAsList();

    /**
     * Retorna un elemento T en la posicion indicada por el indice si existe, sino devuelve null
     *
     * @param index
     * @return T
     */
    public T get(int index);


    /**
     * Imprime el montículo en formato de arbol
     */
    public void imprimirMonticulo();


}
