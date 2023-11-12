package edu.unlam.progava;

import java.util.Arrays;

public class QuickSort extends Ordenadora {
    // No sensible y No estable O(n log n)
    @Override
    public void ordenar(int[] array) {
        quickSort(array, 0, array.length - 1);

    }

    private void quickSort(int[] array, int inicio, int fin) {
        if (inicio < fin) {

            int pivote = particion(array, inicio, fin);

            quickSort(array, inicio, pivote - 1);
            quickSort(array, pivote + 1, fin);
        }

    }

    private int particion(int[] array, int inicio, int fin) {
        int mitad = (inicio + fin) / 2; // O(1)
        ordenarMediana(array, inicio, mitad, fin); //O(1)
        intercambiar(array, mitad, fin - 1); // O(1)
        int posPivote = fin - 1; // O(1)

        int i = inicio+1, j = posPivote - 1; // O(1)

        while (i <= j) // (n)
  {
            while (array[i] < array[posPivote])
                i++; // O(n)
            while (array[j] > array[posPivote])
                j--; // O(n)

            if (i <= j) {
                intercambiar(array, i, j); // O(1)
                i++; // O(1)
                j--; // O(1)
            }
        }
        intercambiar(array, i, posPivote);
        return i;
    }

    private void ordenarMediana(int[] array, int inicio, int mitad, int fin) {
        int aux[] = {array[inicio], array[mitad], array[fin]};
        Arrays.sort(aux);
        array[mitad] = aux[1];
        array[inicio] = aux[0];
        array[fin] = aux[2];
    }
}
