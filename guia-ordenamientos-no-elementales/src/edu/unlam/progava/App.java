package edu.unlam.progava;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class App {
    public static void invertirInt(int[] array) {
        for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static int[] generarDatos2(int cantidad, int rangoMinimo, int rangoMaximo, ORDEN orden) {
        int[] array = new int[cantidad];
        Random random = new Random();

        switch (orden) {
            case ALEATORIO: {
                for (int i = 0; i < array.length; i++) {
                    array[i] = random.nextInt(rangoMaximo - rangoMinimo) + rangoMinimo;
                }
                break;
            }
            case ORDENADO:
                for (int i = 0; i < array.length; i++) {
                    array[i] = random.nextInt(rangoMaximo - rangoMinimo) + rangoMinimo;
                }
                Arrays.sort(array);
                break;
            case INVERSO:
                for (int i = 0; i < array.length; i++) {
                    array[i] = random.nextInt(rangoMaximo - rangoMinimo) + rangoMinimo;
                }
                Arrays.sort(array);
                invertirInt(array);
                break;
        }

        return array;

    }

    private static void testearVelocidadDeAlgoritmos(int cantidad) throws IOException {
        Ordenadora[] algoritmos = {new QuickSort(), new MergeSort(), new ShellSort()};
        String[] nombres = {"QuickSort", "MergeSort", "ShellSort"};


        try (FileWriter fileWriter = new FileWriter(cantidad + "_v2" + ".txt"); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (ORDEN orden : ORDEN.values()) {
                for (int i = 0; i < algoritmos.length; i++) {
                    long sumaTiempo = 0;
                    System.out.println("Algoritmo: " + nombres[i] + " Cantidad a ordenar: " + cantidad + " Orden: " + orden);
                    printWriter.println("Algoritmo: " + nombres[i] + " Cantidad a ordenar: " + cantidad + " Orden: " + orden);
                    for (int j = 0; j < 3; j++) {
                        int[] array = generarDatos2(cantidad, 0, cantidad, orden);

                        long inicio = System.nanoTime();

//                        int vec[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
                        algoritmos[i].ordenar(array);

                        long tiempo = System.nanoTime() - inicio;
                        sumaTiempo += tiempo;

                        System.out.println(j + 1 + ") " + "Tiempo en nanoSegundos: " + tiempo);
                        printWriter.println(j + 1 + ") " + "Tiempo en nanoSegundos: " + tiempo);
                    }
                    long promedio = sumaTiempo / 3;
                    System.out.println("Promedio: " + promedio);
                    printWriter.println("Promedio: " + promedio);
                    System.out.println(" ");
                    printWriter.println("");
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {

        testearVelocidadDeAlgoritmos(10);
        testearVelocidadDeAlgoritmos(1000);
        testearVelocidadDeAlgoritmos(100000);
        testearVelocidadDeAlgoritmos(500000);
        testearVelocidadDeAlgoritmos(1000000);
    }
}