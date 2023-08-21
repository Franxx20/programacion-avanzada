package edu.unlam.progava;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;


enum ORDEN {
    ORDENADO, INVERSO, ALEATORIO
};

public class App {

    public static int[] generarDatos(int cantidad, int rangoMinimo, int rangoMaximo, ORDEN orden) {
        int[] array = new int[cantidad];

        switch (orden) {
            case ALEATORIO:
                return Arrays.stream(array).map(x -> ThreadLocalRandom.current().nextInt(rangoMinimo, rangoMaximo + 1)).toArray();
            case ORDENADO:
                return IntStream.rangeClosed(rangoMinimo, rangoMaximo).limit(cantidad).toArray();
            case INVERSO:
                return IntStream.rangeClosed(rangoMinimo, rangoMaximo).limit(cantidad).map(x -> rangoMaximo - x + rangoMinimo - 1).toArray();
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        testearVelocidadDeAlgoritmos(1000);
        testearVelocidadDeAlgoritmos(100000);
        testearVelocidadDeAlgoritmos(500000);
//        testearVelocidadDeAlgoritmos(1000000);

    }

    private static void testearVelocidadDeAlgoritmos(int cantidad) throws IOException {
        Ordenadora[] algoritmos = {new PorSeleccion(), new PorBurbujeo(), new porInsercion(), new porSeleccionDoble()};
        String[] nombres = {"Seleccion", "Burbujeo", "Insercion", "Seleccion Doble"};


        try (FileWriter fileWriter = new FileWriter(cantidad + ".txt"); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (ORDEN orden : ORDEN.values()) {
                for (int i = 0; i < algoritmos.length; i++) {
                    long sumaTiempo = 0;
                    System.out.println("Algoritmo: " + nombres[i] + " Cantidad a ordenar: " + cantidad + " Orden: " + orden);
                    printWriter.println("Algoritmo: " + nombres[i] + " Cantidad a ordenar: " + cantidad + " Orden: " + orden);
                    for (int j = 0; j < 10; j++) {
                        int[] array = generarDatos(cantidad, 0, cantidad, orden);

                        long inicio = System.nanoTime();

                        algoritmos[i].ordenar(array);

                        long tiempo = System.nanoTime() - inicio;
                        sumaTiempo += tiempo;

                        System.out.println(j + 1 + ") " + "Tiempo en nanoSegundos: " + tiempo);
                        printWriter.println(j + 1 + ") " + "Tiempo en nanoSegundos: " + tiempo);
                    }
                    long promedio = sumaTiempo / 10;
                    System.out.println("Promedio: " + promedio);
                    printWriter.println("Promedio: " + promedio);
                    System.out.println(" ");
                    printWriter.println("");
                }
            }

        }
    }
}
