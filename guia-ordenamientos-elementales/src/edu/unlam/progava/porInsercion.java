package edu.unlam.progava;

public class porInsercion extends Ordenadora {
    // algoritmo de insercion
    // el algoritmo de insercion es sensible
    // el algoritmo de insercion es estable
    // se puede mejorar con un burbujeo
    @Override
    public void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int extraido = array[i];
            int j=i-1;

            while(j >=0 && array[j]> extraido){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] =  extraido;
        }
    }
}