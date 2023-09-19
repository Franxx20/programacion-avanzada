package polinomio;

public class PolParImparIter extends Polinomio {

    public PolParImparIter(double[] coeficientes) {
        super(coeficientes);
    }

    @Override
    public double evaluar(double x) {
//        double resultado = 1 + x *this.coeficientes[1];
        double resultado = 0;

        for (int i = 0; i <= grado; i++) {
            if (grado % 2 == 0) {
                resultado += Math.pow(x * x, i / 2) * this.coeficientes[i];
            } else {
                resultado += x * Math.pow(x, i - 1) * this.coeficientes[i];
            }

        }
//        double resultado = 0;
//        int i;
//        for (i = grado; i > 0; i--) {
////            resultado += multSus(x, i) * this.coeficientes[i];
//            if (grado % 2 == 0) {
//                resultado += Math.pow(x * x, i / 2) * this.coeficientes[i];
//            } else {
//                resultado += x * Math.pow(x, i - 1) * this.coeficientes[i];
//            }
//        }
//        resultado += this.coeficientes[i];
        return resultado;
    }

    @Override
    public String getNombre() {
        return "Polinomio Par/Impar Iterativo";
    }


}
