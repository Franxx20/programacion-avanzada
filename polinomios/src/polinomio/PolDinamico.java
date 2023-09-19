package polinomio;

public class PolDinamico extends Polinomio {
    Double cache[];

    public PolDinamico(double[] coeficientes) {
        super(coeficientes);
        this.cache = new Double[this.grado + 1];
    }

    @Override
    public double evaluar(double x) {
        cache[0] = 1.0;
        cache[1] = x;

        double resultado = 0;
        potencias(grado);

        for (int i = 0; i <= grado; i++) {
            resultado += this.coeficientes[i] * this.cache[i];
        }

        return resultado;
    }

    private void potencias(int grado) {
        for (int i = 2; i <= grado; i++) {
            this.cache[i] = this.cache[i / 2] * this.cache[i - i / 2];
        }
    }

    @Override
    public String getNombre() {
        return "Polinomio Dinamico";
    }
}
