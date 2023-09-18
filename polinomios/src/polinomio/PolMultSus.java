package polinomio;

public class PolMultSus extends Polinomio {
    public PolMultSus(double[] coeficientes) {
        super(coeficientes);
    }

    @Override
    public double evaluar(double x) {
        double resultado = 0;
        int i;
        for (i = grado; i > 0; i--) {
            resultado += multSus(x, i) * this.coeficientes[i];
        }
        resultado += this.coeficientes[i];
        return resultado;
    }

    @Override
    public String getNombre() {
        return "Polinomio Multiplicaciones sucesivas";
    }


}
