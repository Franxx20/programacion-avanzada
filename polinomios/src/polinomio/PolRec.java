package polinomio;

public class PolRec extends Polinomio {
    public PolRec(double[] coeficientes) {
        super(coeficientes);
    }

    @Override
    public double evaluar(double x) {
        return this.coeficientes[0] + evaluarRec(x, this.grado);
    }

    @Override
    public String getNombre() {
        return "Polinomio Recursivo";
    }

    private double evaluarRec(double x, int grado) {
        if (grado == 1)
            return x * this.coeficientes[1];

        double resultado = Math.pow(x, grado) * this.coeficientes[grado];


        return resultado + evaluarRec(x, grado - 1);
    }
}
