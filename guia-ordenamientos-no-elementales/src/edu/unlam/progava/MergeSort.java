package edu.unlam.progava;

public class MergeSort extends Ordenadora {
    @Override
    public void ordenar(int[] array) {

        // estable y no sensible. O(n log n)
        mergeSort(array, 0, array.length - 1);

    }

    // Divide el array en dos subarrays, los ordena y los combina
    private void mergeSort(int[] array, int inicio, int fin) {
        if (inicio < fin) {
            int mitad = (inicio + fin) / 2;

            mergeSort(array, inicio, mitad);
            mergeSort(array, mitad + 1, fin);

            // combina los dos arrays ordenados
            merge(array, inicio, mitad, fin);
        }


    }

    private void merge(int[] array, int inicio, int mitad, int fin) {

        int tamIzquierda = mitad - inicio + 1;
        int tamDerecha = fin - mitad;

        int total[] = new int[tamIzquierda + tamDerecha];

        for (int i = 0; i < tamIzquierda; i++) {
            total[i] = array[inicio + i];
        }

        for (int j = tamIzquierda, x = 0; j < tamIzquierda + tamDerecha; j++, x++) {
            total[j] = array[fin - x];
        }


        int i, j, orig;
        i = 0;
        j = tamIzquierda + tamDerecha - 1;
        orig = inicio;

        while (i <= j) {
            if (total[i] <= total[j]) {
                array[orig] = total[i];
                i++;
            } else {
                array[orig] = total[j];
                j--;
            }
            orig++;
        }

    }

    private void merge2(int[] array, int inicio, int mitad, int fin) {
// Create izquierda ← Array[inicio..mitad] and derecha ← Array[mitad+1..fin]
        int mitad1 = mitad - inicio + 1;
        int mitad2 = fin - mitad;

        int izquierda[] = new int[mitad1];
        int derecha[] = new int[mitad2];

        for (int i = 0; i < mitad1; i++)
            izquierda[i] = array[inicio + i];
        for (int j = 0; j < mitad2; j++)
            derecha[j] = array[mitad + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = inicio;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < mitad1 && j < mitad2) {
            if (izquierda[i] <= derecha[j]) {
                array[k] = izquierda[i];
                i++;
            } else {
                array[k] = derecha[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < mitad1) {
            array[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < mitad2) {
            array[k] = derecha[j];
            j++;
            k++;
        }
    }
}
