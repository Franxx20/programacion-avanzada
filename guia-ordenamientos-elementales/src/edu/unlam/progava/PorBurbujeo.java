package edu.unlam.progava;

public class PorBurbujeo extends Ordenadora {
    // el algoritmo de burbujeo es sensible a la entrada.
    // el algoritmo de burbujeo es estable a la entrada.
    // mejor caso: n-1 comparaciones
    // peor caso: n(n-1)/2 comparaciones
    // O(n * n)


    @Override
    public void ordenar(int[] array) {

        boolean desordenado;
        do {
            desordenado = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1])
                {
                    intercambiar(array, i,i+1);
                    desordenado = true;
                }
            }
        } while(desordenado);


    }
}
