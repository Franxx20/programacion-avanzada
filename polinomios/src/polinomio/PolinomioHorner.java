package polinomio;

public class PolinomioHorner extends Polinomio {
	public PolinomioHorner(double[] coeficientes) {
		super(coeficientes);
	}

	@Override
	public String getNombre() {
		return "Polinomio-de-Horner";
	}

	@Override
	// O(n)
	public double evaluar(double x) {
		return this.coeficientes[0] + x * calcularPotencia(x, 1);
	}


	@Override
	// O(n)
	protected double calcularPotencia(double x, int actual) {
		if (actual > this.grado) //O(1)
			return 0;

		return this.coeficientes[actual] + x * (calcularPotencia(x, actual + 1)); // O(n)
	}
}
