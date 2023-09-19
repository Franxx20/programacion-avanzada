package polinomio;

public class PolDinamicoMejorado extends Polinomio {
    private Double[] cache;

    public PolDinamicoMejorado(double[] coeficientes) {
        super(coeficientes);
        this.cache = new Double[this.grado + 1];
    }

    @Override
    public String getNombre() {
        return "Polinomio Dinamico Mejorado";
    }
//

    @Override
    public double evaluar(double x) {
        if (this.grado == 0)
            return this.coeficientes[0];

        cache[0] = 1.0;
        cache[1] = x;

        double resultado = this.coeficientes[0] + this.coeficientes[1] * x;

        for (int i = 2; i <= grado; i++) {
            this.cache[i] = this.cache[i / 2] * this.cache[i - i / 2];
            resultado += this.coeficientes[i] * this.cache[i];
        }

        return resultado;
    }

}
