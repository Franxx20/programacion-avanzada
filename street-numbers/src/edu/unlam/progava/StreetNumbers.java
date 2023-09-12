package edu.unlam.progava;

public class StreetNumbers {
    public int cuadratica(int n) {
        double izquierda = 0, derecha = 0;
        for (int i = 1; i < n; i++) {
            izquierda = sumaElementos(i - 1);
            derecha = sumaElementos(n) - i - sumaElementos(i - 1);

            if (izquierda == derecha) return i;
        }
        return -1;
    }

    public int lineal(int n) {


        double izquierda = 0, derecha = 0;
        for (int i = 1; i < n; i++) {
            izquierda = sumaGaussiana(i - 1);
            derecha = sumaGaussiana(n) - i - sumaGaussiana(i - 1);

            if (izquierda == derecha) return i;
        }
        return -1;
    }

    int lineal_v2(int n) {
        int sumaIzquierda = 0;
        int sumaDerecha = (int) ((Math.pow(n, 2) + n) / 2 - 1);

        int i;
        for (i = 2; i < n && sumaIzquierda < sumaDerecha; i++) {
            sumaIzquierda += i - 1;
            sumaDerecha -= i;
        }

        return sumaIzquierda == sumaDerecha ? i - 1 : -1;
    }


    public int constante(int n) {

        double casaFinal = Math.sqrt(0.5 * Math.pow(n, 2) + 0.5 * n);

        if ((int) casaFinal == casaFinal) return (int) casaFinal;

        return -1;
    }

    public static double sumaGaussiana(int n) {
        return ((double) (n + 1) * n) / 2;
    }

    public static double sumaElementos(int n) {
        double resultado = 0;
        for (int i = 1; i <= n; i++) {
            resultado += i;
        }

        return resultado;
    }
}
