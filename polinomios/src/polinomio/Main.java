package polinomio;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		testearVelocidadAlgoritmo(2, 10);
		testearVelocidadAlgoritmo(2, 100);
		testearVelocidadAlgoritmo(2, 500);
		testearVelocidadAlgoritmo(2, 1000);
		testearVelocidadAlgoritmo(2, 5000);
	}

	public static void testearVelocidadAlgoritmo(double val, int cantidad) throws IOException {
		double[] array = generarDatos(cantidad, 1, 10);

		Polinomio[] polinomios = { new PolinomioMultiplicacionSucesivas(array), new PolinomioRecursivo(array),
				new PolinomioParImparRecursivo(array), new PolinomioParImparIterativo(array), new PolinomioPD(array),
				new PolinomioPDMejorado(array), new PolinomioHorner(array), new PolinomioPow(array) };

		try (FileWriter fileWriter = new FileWriter("archivos/out/" + cantidad + "_" + val + ".txt");
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
				System.out.println("evaluado a " + val + " = " + resultado);
				System.out.println("Tiempo en nanoSegundos: " + promedio);
				printWriter.println("evaluado a " + val + " = " + resultado);
				printWriter.println("Tiempo en nanoSegundos: " + promedio);

				System.out.println(" ");
				printWriter.println("");
			}
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