package polinomio;

public class PolinomioParImparRecursivo extends Polinomio {
    public PolinomioParImparRecursivo(double[] coeficientes) {
        super(coeficientes);
    }

    @Override
    public String getNombre() {
        return "Polinomio Par/Impar Recursivo";
    }

    @Override

    // O(n log n)
    public double evaluar(double x) {
        double resultado = this.coeficientes[0]; // O(1)

        // O(n) * O(log n) -> O(n log(n))
        for (int i = 1; i <= this.grado; i++) {
            resultado += calcularPotencia(x, i) * this.coeficientes[i]; // O(log n)
        }

        return resultado;
    }

    @Override
    // log(n)
    protected double calcularPotencia(double x, int grado) {
        if (grado == 1) // O(1)
            return x;

        // O(log n)
        if (grado % 2 == 0) {
            return calcularPotencia(x * x, grado / 2);
        } else {
            return x * calcularPotencia(x, grado - 1);
        }
    }
}
