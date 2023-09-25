package polinomio;

public class PolinomioPDMejorado extends Polinomio {
    private Double[] cache;

    public PolinomioPDMejorado(double[] coeficientes) {
        super(coeficientes);
        this.cache = new Double[this.grado + 1];
    }

    @Override
    public String getNombre() {
        return "Polinomio-Programacion-Dinamica-Mejorado";
    }


    // O(n)
    @Override
    public double evaluar(double x) {
        // O(1)
        if (this.grado == 0)
            return this.coeficientes[0];

        cache[0] = 1.0; // O(1)
        cache[1] = x; // O(1)

        double resultado = this.coeficientes[0] + this.coeficientes[1] * x; // O(1)

        // O(n)
        for (int i = 2; i <= grado; i++) {
            this.cache[i] = this.cache[i / 2] * this.cache[i - i / 2]; // O(1)
            resultado += this.coeficientes[i] * this.cache[i]; // O(1)
        }

        return resultado;
    }

    @Override
    protected double calcularPotencia(double x, int grado) {
        return 0;
    }

}
