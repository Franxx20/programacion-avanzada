package edu.unlam.progava;

public abstract class Ordenadora {
    public abstract void ordenar(int[] array);


    protected static void intercambiar(int[] array, int i, int posMenor) {
        int aux = array[i];
        array[i] = array[posMenor];
        array[posMenor] = aux;
    }

}
