package polinomio;

public class PolRec extends Polinomio {
    public PolRec(double[] coeficientes) {
        super(coeficientes);
    }

    @Override
    public double evaluar(double x) {
        return evaluarRec(x,this.grado);
    }

    @Override
    public String getNombre() {
        return "Polinomio Recursivo";
    }

    private double evaluarRec(double x, int grado) {
        if (grado == 0)
            return 1;

        double resultado = 0;

        resultado += Math.pow(x, grado) * this.coeficientes[grado];

//        evaluarRec(x, grado - 1);

        return resultado + evaluarRec(x,grado-1);
    }
}
