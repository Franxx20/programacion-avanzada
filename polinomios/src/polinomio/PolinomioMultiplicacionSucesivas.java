package polinomio;

public class PolinomioMultiplicacionSucesivas extends Polinomio {

	public PolinomioMultiplicacionSucesivas(double[] coeficientes) {
		super(coeficientes);
	}

	@Override
	public String getNombre() {
		return "Polinomio-Multiplicaciones-sucesivas";
	}

	@Override
	// // O(1) + O(n^2) -> O(n^2)
	public double evaluar(double x) {
		double resultado = this.coeficientes[0]; // O(1)

		// O(n) * O(n) -> O(n^2)
		for (int i = 1; i <= this.grado; i++) {
			resultado += calcularPotencia(x, i) * this.coeficientes[i]; // O(n) * O(1) -> O(n)
		}

		return resultado;
	}

	@Override
	// O(1) + O(n) -> O(n)
	protected double calcularPotencia(double x, int grado) {
		double resultado = 1; // O(1)

		// O(n) * O(1) -> O(n)
		for (int i = 0; i < grado; i++) {
			resultado *= x; // O(1)
		}
		return resultado;
	}

}
