package polinomio;

public abstract class Polinomio {
	protected int grado;
	protected double[] coeficientes;

	public Polinomio(double[] coeficientes) throws IllegalArgumentException {
		if (coeficientes.length == 0) {
			throw new IllegalArgumentException("El array esta vacio");
		}

		this.grado = coeficientes.length - 1;
		this.coeficientes = coeficientes;
	}

	public abstract String getNombre();

	public abstract double evaluar(double x);

	@Override
	public String toString() {
		String cadena = new String();
		for (int coef = grado; coef >= 2; coef--) {
			cadena += this.coeficientes[coef] + "*x^" + coef + " + ";
		}

		if (grado >= 1)
			cadena += this.coeficientes[1] + "*x + ";

		if (grado >= 0)
			cadena += this.coeficientes[0];

		return cadena;
	}

	protected abstract double calcularPotencia(double x, int grado);
}
