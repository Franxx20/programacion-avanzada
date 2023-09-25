package polinomio;

public class PolinomioRecursivo extends Polinomio {
    public PolinomioRecursivo(double[] coeficientes) {
        super(coeficientes);
    }

    @Override
    public String getNombre() {
        return "Polinomio-Recursivo";
    }

    @Override
    //O(N^2)
    public double evaluar(double x) {
        double resultado = this.coeficientes[0]; // O(1)

        // O(N) * O(N) -> O(N^2)
        for (int i = 1; i <= this.grado; i++) {
            resultado += calcularPotencia(x, i) * this.coeficientes[i]; // O(N)
        }

        return resultado;
    }

    @Override
    // O(N)
    protected double calcularPotencia(double x, int grado) {
        // O(1)
        if (grado == 1)
            return x;

        return x * calcularPotencia(x, grado - 1); // O(N)
    }
}
