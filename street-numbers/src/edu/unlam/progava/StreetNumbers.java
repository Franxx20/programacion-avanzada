package edu.unlam.progava;

public class StreetNumbers {
    public int cuadratica(int n) {
        double totalIzquierda;
        double aux = n;
        double totalDerecha = 0;

        int j;
        do {
            totalIzquierda = 0;

            for (int i = 0; i < n; i++) {
                totalIzquierda += i;
            }

            for (j = n; totalIzquierda > totalDerecha; j++) {
                totalDerecha += j + 1;
            }

        } while (totalDerecha < totalIzquierda);

        if (totalIzquierda == totalDerecha)
            return j;

        return -1;
    }

    public int lineal(int n) {
        double izquierda = sumaGaussiana(n - 1);

        double derecha = 0;
        int i = 0;
        for (i = n; izquierda > derecha; i++) {
            derecha += i + 1;
        }

        if (izquierda == derecha)
            return i;

        return -1;
    }

    public int constante(int n) {

//        double casaFinal = (-1 + Math.sqrt(1 + 8 * n * n)) / 2;
        double casaFinal = (-1 + Math.sqrt(1 + 8 * Math.pow(n, 2))) / 2;

        if ((int) casaFinal == casaFinal)
            return (int) casaFinal;

        return -1;
    }

    public static double sumaGaussiana(int n) {
        return ((double) (n + 1) * n) / 2;
    }
}
