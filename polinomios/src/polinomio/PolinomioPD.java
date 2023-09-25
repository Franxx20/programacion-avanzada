package polinomio;

public class PolinomioPD extends Polinomio {
	Double cache[];

	public PolinomioPD(double[] coeficientes) {
		super(coeficientes);
		this.cache = new Double[this.grado + 1];
	}

	@Override
	public String getNombre() {
		return "Polinomio-Programacion-Dinamica";
	}

	// O(n)
	@Override
	public double evaluar(double x) {
		// O(1)
		if (this.grado == 0) {
			return this.coeficientes[0];
		}

		potencias(x, grado); // O(n)
		double resultado = 0; // O(1)

		// O(n)
		for (int i = 0; i <= grado; i++) {
			resultado += this.coeficientes[i] * this.cache[i]; // O(1)
		}

		return resultado;
	}

	// O(n)
	private void potencias(double x, int grado) {
		this.cache[0] = 1.0; // O(1)
		this.cache[1] = x; // O(1)
		// O(n)
		for (int i = 2; i <= grado; i++) {
			this.cache[i] = this.cache[i / 2] * this.cache[i - i / 2]; // O(1)
		}
	}

	@Override
	protected double calcularPotencia(double x, int grado) {
		return 0;
	}

}
