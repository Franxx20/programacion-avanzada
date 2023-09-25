package polinomio;

public class PolinomioPow extends Polinomio {

	public PolinomioPow(double[] coeficientes) {
		super(coeficientes);
	}

	@Override
	public String getNombre() {
		return "Polinomio-Pow";
	}

	//O(n log(n))
	@Override
	public double evaluar(double x) {
		double resultado = this.coeficientes[0]; // O(1)

		// O(n) * O(log(n)) -> O(n log(n))
		for (int i = 1; i <= this.grado; i++) {
			resultado += Math.pow(x, i) * this.coeficientes[i]; // O(log n)
		}

		return resultado;
	}

	@Override
	protected double calcularPotencia(double x, int grado) {
		return 0;
	}
	
	

}
