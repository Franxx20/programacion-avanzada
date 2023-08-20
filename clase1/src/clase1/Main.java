package clase1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        callesIzquierdaDerecha();
//        int[] vector = {31, 14, 37, 12, 29, 37};
//        int[] vector = {31, 14, 37, 12, 29, 37};
//        ordenamientoSeleccion(vector);


    }

    private static void callesIzquierdaDerecha() {
        int number = 5;
        while (number < 100) {
            int izquierda = 0;
            int derecha = number + 1;
            int totalDerecha = 0;
            for (int i = 1; i < number; i++) {
                izquierda += i;

            }

            while (totalDerecha < izquierda) {
                totalDerecha += derecha;
                derecha += 1;
            }
            number += 1;
            if (izquierda == totalDerecha)
                System.out.println("izquierda: " + izquierda + "derecha: " + totalDerecha);

        }
    }

    // este algoritmo es no sensible y no estable.
    // un algoritmo es estable si a claves iguales mantiene el orden previo. (si ante claves iguales mantiene el orden de llegada)
    // un algoritmo es sensible si no modifica significativamente el tiempo de ejecución de acuerdo a los datos de ingreso.
    private static void ordenamientoSeleccion(int[] vector) {

        System.out.println(Arrays.toString(vector));

        for (int i = 0; i < vector.length - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[posMenor] > vector[j]) {
                    posMenor = j;
                }
            }
            intercambiar(vector, i, posMenor);

        }

        System.out.println(Arrays.toString(vector));

    }
    // el algoritmo de burbujeo es sensible a la entrada.
    // el algoritmo de burbujeo es estable a la entrada.
    // mejor caso: n-1 comparaciones
    // peor caso: n(n-1)/2 comparaciones
    // O(n * n)

    // algoritmo de insercion
    // el algoritmo de insercion es sensible
    // el algoritmo de insercion es estable
    // se puede mejorar con un burbujeo

    private static void intercambiar(int[] vector, int i, int posMenor) {
        int auxiliar;
        auxiliar = vector[i];
        vector[i] = vector[posMenor];
        vector[posMenor] = auxiliar;
    }
}
