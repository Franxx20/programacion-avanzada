package polinomio;

public class PolinomioParImparIterativo extends Polinomio {

	public PolinomioParImparIterativo(double[] coeficientes) {
		super(coeficientes);
	}

	@Override
	public String getNombre() {
		return "Polinomio-Par/Impar-Iterativo";
	}


	@Override
	// O(n log(n))
	public double evaluar(double x) {
		double resultado = this.coeficientes[0]; // O(1)

		// O(n) * O(log n) -> O(n log(n))
		for (int i = 1; i <= this.grado; i++) {
			resultado += calcularPotencia(x, i) * this.coeficientes[i]; // O(log n)
		}

		return resultado;
	}

	@Override
	protected double calcularPotencia(double x, int grado) {
		if (grado == 0) // O(1)
			return 1;

		double resultado = 1; // O(1)

		// O(1) * O(log n) -> O(log n)
		while (grado >= 1) {
			// O(log n)
			if (grado % 2 == 0) {
				x = x * x; // O(1)
				grado = grado / 2; // O(1)
			} else {
				resultado *= x; // O(1)
				grado--;  // O(1)
			}
		}

		return resultado;
	}
}
