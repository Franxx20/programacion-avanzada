package polinomio;

public class PolParImparIter extends Polinomio {

    public PolParImparIter(double[] coeficientes) {
        super(coeficientes);
    }

    @Override
    public double evaluar(double x) {
        double resultado = 0;
        int i;
        for (i = grado; i > 0; i--) {
//            resultado += multSus(x, i) * this.coeficientes[i];
            if (grado % 2 == 0) {
                resultado += Math.pow(x * x, i / 2) * this.coeficientes[i];
            } else {
                resultado += x * Math.pow(x, i - 1) * this.coeficientes[i];
            }
        }
        resultado += this.coeficientes[i];
        return resultado;
    }


    private double multSus(double x, int grado) {
        double resultado = x;
        for (int i = 1; i < grado; i++) {
            resultado *= x;
        }
        return resultado;
    }
}
