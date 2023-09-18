package polinomio;

import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        Polinomio pol = new PolHorner(new double[]{1, 2, 3, 4, 5, 6, 7, 8});

        testearVelocidadAlgoritmo(10000);

    }

    public static void testearVelocidadAlgoritmo(double val) {
        double[] array = generarDatos(8, 1, 10);
//        double[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Polinomio[] polinomios = {new PolRec(array), new PolMultSus(array), new PolParImparIter(array), new PolParImparRec(array), new PolHorner(array), new PolDinamicaRec(array)};

//        double val = 10000;
        for (Polinomio pol : polinomios) {
//            System.out.println("polinomo " + pol);
            System.out.println(pol.getNombre());
            long inicio = System.nanoTime();
            double resultado = pol.evaluar(val);
            long tiempo = System.nanoTime() - inicio;
            System.out.println("evaluado a " + val + " = " + resultado);
            System.out.println("Tiempo en nanoSegundos: " + tiempo);
        }

    }

    public static double[] generarDatos(int cantidad, int rangoMinimo, int rangoMaximo) {
        double[] array = new double[cantidad];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(rangoMaximo - rangoMinimo) + rangoMinimo;
        }


        return array;
    }
}