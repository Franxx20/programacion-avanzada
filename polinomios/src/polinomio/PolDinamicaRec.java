package polinomio;

import java.util.HashMap;
import java.util.Map;

public class PolDinamicaRec extends Polinomio {
    private Map<Double, Double> cache = new HashMap<>();

    public PolDinamicaRec(double[] coeficientes) {
        super(coeficientes);
    }

    @Override
    public double evaluar(double x) {
        return evaluarRec(x, this.grado);
    }

    @Override
    public String getNombre() {
        return "Polinomio Dinamico Recursivo";
    }

    private double evaluarRec(double x, int grado) {
        if (grado == 0)
            return 1;

        double resultado = 0;

        if (this.cache.containsKey(this.coeficientes[grado])) {
            resultado += this.cache.get(this.coeficientes[grado]);
        } else {
            resultado += Math.pow(x, grado) * this.coeficientes[grado];
//            cache.put(this.coeficientes[grado], resultado);
            cache.put(this.coeficientes[grado],resultado);
        }

        return resultado + evaluarRec(x, grado - 1);
    }

}
