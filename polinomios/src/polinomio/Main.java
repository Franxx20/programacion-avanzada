package polinomio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        testearVelocidadAlgoritmo(2, 10);
        testearVelocidadAlgoritmo(2, 100);
        testearVelocidadAlgoritmo(2, 500);
        testearVelocidadAlgoritmo(2, 1000);
        testearVelocidadAlgoritmo(2, 5000);
        testearVelocidadAlgoritmo(10, 10);
        testearVelocidadAlgoritmo(10, 100);
        testearVelocidadAlgoritmo(10, 500);
        testearVelocidadAlgoritmo(10, 1000);
        testearVelocidadAlgoritmo(10, 5000);
        testearVelocidadAlgoritmo(1000, 10);
        testearVelocidadAlgoritmo(1000, 100);
        testearVelocidadAlgoritmo(1000, 500);
        testearVelocidadAlgoritmo(1000, 1000);
        testearVelocidadAlgoritmo(1000, 5000);
        testearVelocidadAlgoritmo(100000, 10);
        testearVelocidadAlgoritmo(100000, 100);
        testearVelocidadAlgoritmo(100000, 500);
        testearVelocidadAlgoritmo(100000, 1000);
        testearVelocidadAlgoritmo(100000, 5000);
        testearVelocidadAlgoritmo(1000000, 10);
        testearVelocidadAlgoritmo(1000000, 100);
        testearVelocidadAlgoritmo(1000000, 500);
        testearVelocidadAlgoritmo(1000000, 1000);
        testearVelocidadAlgoritmo(1000000, 5000);
    }

    public static void testearVelocidadAlgoritmo(double val, int cantidad) throws IOException {
        double[] array = generarDatos(cantidad, 1, 10);
        List<String[]> dataLines = new ArrayList<>();

        Polinomio[] polinomios = {new PolinomioMultiplicacionSucesivas(array), new PolinomioRecursivo(array),
                new PolinomioParImparRecursivo(array), new PolinomioParImparIterativo(array), new PolinomioPD(array),
                new PolinomioPDMejorado(array), new PolinomioHorner(array), new PolinomioPow(array)};

        try (FileWriter fileWriter = new FileWriter("archivos/out/" + cantidad + "_" + val + ".csv");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Polinomio pol : polinomios) {
                System.out.println(pol.getNombre());
                printWriter.println(pol.getNombre());

                long sumaTiempo = 0;
                double resultado = 0;

                for (int i = 0; i < 5; i++) {
                    long inicio = System.nanoTime();
                    resultado = pol.evaluar(val);
                    long tiempo = System.nanoTime() - inicio;
                    sumaTiempo += tiempo;
                }
                long promedio = sumaTiempo / 5;

                System.out.println("evaluado a " + +val + resultado);
                System.out.println("Promedio de tiempo en nanoSegundos: " + promedio);
                dataLines.add(new String[]{"evaluado a", String.valueOf(val), String.valueOf(resultado)});
                dataLines.add(new String[]{"Promedio de tiempo en nanosegundos", String.valueOf(promedio)});
                dataLines.stream().map(Main::convertToCSV).forEach(printWriter::println);

                dataLines.clear();
                System.out.println(" ");
            }
        }

    }

    public static String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(Main::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public static String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
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