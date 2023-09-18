package polinomio;

public abstract class Polinomio {
    protected int grado;
    protected double[] coeficientes;

    public Polinomio(double[] coeficientes) {
        this.grado = coeficientes.length - 1;

        this.coeficientes = coeficientes;

    }

    public void setCoeficientes(double [] coeficientes){
        this.coeficientes = coeficientes;
        this.grado = coeficientes.length-1;
    }
    public abstract double evaluar(double x);

    @Override
    public String toString() {
        String cadena = new String();
        for (int coef = grado; coef >= 0; coef--) {
            if (coef > 1) {
                cadena += this.coeficientes[coef] + "*n^" + coef + " + ";
            } else if (coef == 1) {
                cadena += this.coeficientes[coef] + "*n + ";
            } else {
                cadena += this.coeficientes[coef];
            }
        }
        return cadena;
    }

    public abstract String getNombre();
    protected double multSus(double x, int grado) {
        double resultado = x;
        for (int i = 1; i < grado; i++) {
            resultado *= x;
        }
        return resultado;
    }
}
