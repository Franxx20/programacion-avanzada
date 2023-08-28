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
        int mitad = (inicio + fin) / 2;
        ordenarMediana(array, inicio, mitad, fin);
        intercambiar(array, mitad, fin - 1);
        int posPivote = fin - 1;

        int i = inicio, j = posPivote - 1;

        while (i <= j) {
            while (array[i] < array[posPivote])
                i++;
            while (array[j] > array[posPivote])
                j--;

            if (i <= j) {
                intercambiar(array, i, j);
                i++;
                j--;
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
