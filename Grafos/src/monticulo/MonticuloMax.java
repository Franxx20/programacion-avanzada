package monticulo;

//import monticulo.ColaDePrioridad;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class MonticuloMax<T extends Comparable<? super T>> implements ColaDePrioridad<T> {
    private T[] heap;
    private int size;
    private Comparator<T> comparator;

    public MonticuloMax(int capacidad) {
        heap = (T[]) new Comparable[capacidad + 1];
        size = 0;
    }

    public MonticuloMax(T[] items) {
        heap = (T[]) new Comparable[items.length + 1];
        for (T item : items) {
            this.insert(item);
        }
    }

    public MonticuloMax(int capacidad, Comparator<T> comparator) {
        this.comparator = comparator;
        heap = (T[]) new Comparable[capacidad + 1];
        size = 0;
    }

    public MonticuloMax(Comparator<T> comparator) {
        this(1, comparator);
    }

    public MonticuloMax() {
        this(1);
    }


    @Override
    public void insert(T item) {
        if (size == heap.length - 1) resize(2 * heap.length);

        heap[++size] = item;
        sortUp(size);
    }

    @Override
    public T peekTop() {
        return heap[1];
    }

    @Override
    public T remove() {
        if (isEmpty()) throw new NoSuchElementException("Monticulo vacio");
        T max = heap[1];
        swap(1, size--);
        sortDown(1);
        heap[size + 1] = null;
        if ((size > 0) && (size == (heap.length - 1) / 4)) resize(heap.length / 2);

        return max;
    }

    @Override
    public int indexOf(T item) {
        for (int i = 1; i <= size; i++) {
            if (item.compareTo(heap[i]) == 0)
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T[] getMonticulo() {
        return heap;
    }


    @Override
    public List<T> getMonticuloAsList() {
        return List.of(heap);
    }

    @Override
    public T get(int index) {
        return index > size ? null : heap[index];
    }

    // funciones de ayuda

    /**
     * Checkea si el elemento j es menor al j
     *
     * @param i
     * @param j
     * @return true si el i es menor al j, false no es menor
     */
    private boolean isLess(int i, int j) {
        if (comparator == null) {
            return heap[i].compareTo(heap[j]) < 0;
        } else {
            return comparator.compare(heap[i], heap[j]) < 0;
        }


    }

    private void swap(int ind1, int ind2) {
        T tAux = heap[ind1];
        heap[ind1] = heap[ind2];
        heap[ind2] = tAux;
    }

    private void sortUp(int ind) {
        while (ind > 1 && isLess(ind / 2, ind)) {
            swap(ind / 2, ind);
            ind = ind / 2;
        }
    }

    private void sortDown(int ind) {
        while (2 * ind <= size) {
            // Hijo Izquierda
            int j = 2 * ind;
            // si ind hi < size entonces hay ind hd y izquierda es menor a derecha ahora elijo a derecha (j+1) para intercambio(mayor arriba)
            if (j < size && isLess(j, j + 1)) j++;
            // si padre es mayor al hijo/ ej p:6 < h:5 == false entonces se encuentra ordenado
            if (isLess(ind, j) == false) break;
            // caso contrario se intercambia padre con hijo
            swap(ind, j);
            ind = j;
        }
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Comparable[capacity];
        if (size >= 0) System.arraycopy(heap, 1, temp, 1, size);
        heap = temp;
    }

    public void imprimirMonticulo() {
        imprimirMonticuloRec(0, 1);
    }

    private void imprimirMonticuloRec(int nivel, int i) {
        if (i > size) return;

        imprimirMonticuloRec(nivel + 1, 2 * i + 1);

        for (int j = 0; j < nivel; j++) System.out.print("\t\t");

        System.out.println(this.get(i));

        imprimirMonticuloRec(nivel + 1, 2 * i);

    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("[");
        for (int i = 1; i <= this.size; i++) {
            str.append(this.get(i).toString());
            if (i < size) {
                str.append(", ");
            }
        }
        str.append("]");

        return str.toString();
    }


    /**
     * Ordenamiento Insittu
     * para que quede ordenado como un monticulo
     * Costo 2*N*lg(N) worst case
     * @param a
     */
    public static void HeapSort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N);
            sink(a, 1, --N);
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }

    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

}


