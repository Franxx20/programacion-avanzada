package edu.unlam.progava;

public class App {
    public static void main(String[] args) {
        StreetNumbers sn = new StreetNumbers();
        long inicio = System.nanoTime();
        for (int i = 5; i < 1_000_000; i++) {
            Integer resultado = sn.cuadratica(i);
            if (resultado != -1) {
                System.out.println(i + "," + resultado);
            }
        }
        long tiempo = System.nanoTime() - inicio;
        System.out.println("El tiempo para el algoritmo cuadratica es de " + tiempo / 1_000_000_000 + " segundos");
        // ...
    }
}
