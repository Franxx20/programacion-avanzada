package polinomio;

public class PolHorner extends Polinomio {
    public PolHorner(double[] coeficientes) {
        super(coeficientes);
    }

    @Override
    public double evaluar(double x) {
        return 1 + x * metodoHornerRec2(x, 1);
    }

    private double metodoHornerRec2(double x, int actual) {
        if (actual > this.grado)
            return 0;

        return this.coeficientes[actual] + x * (metodoHornerRec2(x, actual + 1));
    }
}
