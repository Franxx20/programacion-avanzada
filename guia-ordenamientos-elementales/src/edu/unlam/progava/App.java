package edu.unlam.progava;

import java.lang.reflect.Array;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Ordenadora[] algoritmos = {
                new PorSeleccion(),
                 new PorBurbujeo(),
                new porInsercion()
                // ...
        };
        long inicio, tiempo;


        int[] array = {31, 14, 37, 12, 29, 37};


        System.out.println("Vector sin ordenar: " + Arrays.toString(array));
        // repetir todas las veces necesarias:
        // crear conjunto de datos
        inicio = System.nanoTime();
        // ordenar
        algoritmos[2].ordenar(array);
        tiempo = System.nanoTime() - inicio;
        // registrar tiempo


        System.out.println("Vector ordenado: " + Arrays.toString(array));
        System.out.println("Tiempo en segundos: " + tiempo);
    }
}
