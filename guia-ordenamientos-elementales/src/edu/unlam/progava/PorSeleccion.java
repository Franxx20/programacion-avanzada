package edu.unlam.progava;

public class PorSeleccion extends Ordenadora {

    // este algoritmo es no sensible y no estable.
    // un algoritmo es estable si a claves iguales mantiene el orden previo. (si ante claves iguales mantiene el orden de llegada)
    // un algoritmo es sensible si no modifica significativamente el tiempo de ejecución de acuerdo a los datos de ingreso.
    @Override
    public void ordenar(int[] array) {
        // implementar y probar con JUnit cada uno
        for (int i = 0; i < array.length - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[posMenor])
                    posMenor = j;
            }
            intercambiar(array, i, posMenor);
        }
    }

}
