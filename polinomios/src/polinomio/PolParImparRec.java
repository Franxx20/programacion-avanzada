package polinomio;

public class PolParImparRec extends Polinomio {
    public PolParImparRec(double[] coeficientes) {
        super(coeficientes);
    }

    @Override
    public double evaluar(double x) {
        return this.coeficientes[0] + evaluarRec(x, this.grado);
    }

    @Override
    public String getNombre() {
        return "Polinomio Par/Impar Recursivo";
    }

    private double evaluarRec(double x, int grado) {
        if (grado == 1)
            return x * this.coeficientes[1];

        double resultado = 0;

        if (grado % 2 == 0) {
            resultado = Math.pow(x * x, grado / 2) * this.coeficientes[grado];
        } else {
            resultado = x * Math.pow(x, grado - 1) * this.coeficientes[grado];
        }


        return resultado + evaluarRec(x, grado - 1);
    }

}
