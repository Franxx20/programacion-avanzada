package polinomio;

import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        testearVelocidadAlgoritmo(2);
    }

    public static void testearVelocidadAlgoritmo(double val) {
        double[] array = generarDatos(1000, 1, 10);
        Polinomio[] polinomios = {new PolRec(array), new PolMultSus(array), new PolParImparIter(array), new PolParImparRec(array), new PolHorner(array), new PolDinamico(array), new PolDinamicoMejorado(array)};

        for (Polinomio pol : polinomios) {
            System.out.println(pol.getNombre());
            long inicio = System.nanoTime();
            double resultado = pol.evaluar(val);
            long tiempo = System.nanoTime() - inicio;
            System.out.println("evaluado a " + val + " = " + resultado);
            System.out.println("Tiempo en nanoSegundos: " + tiempo);
        }

    }

    public static double[] generarDatos(int cantidad, int rangoMinimoCoef, int rangoMaximoCoef) {
        double[] array = new double[cantidad];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(rangoMaximoCoef - rangoMinimoCoef) + rangoMinimoCoef;
        }


        return array;
    }
}