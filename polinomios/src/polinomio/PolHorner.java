package polinomio;

public class PolHorner extends Polinomio {
    public PolHorner(double[] coeficientes) {
        super(coeficientes);
    }

    @Override
    public double evaluar(double x) {
        return this.coeficientes[0] + x * metodoHornerRec2(x, 1);
    }

    @Override
    public String getNombre() {
        return "Polinomio de Horner";
    }

    private double metodoHornerRec2(double x, int actual) {
        if (actual > this.grado)
            return 0;

        return this.coeficientes[actual] + x * (metodoHornerRec2(x, actual + 1));
    }
}
