package monticulo;

public class Main {
    public static void main(String[] args) {
        Monticulo<Integer> mMin = new MonticuloDeMinimo<>();
        Monticulo<Integer> mMax = new MonticuloDeMaximo<>();

        mMin.encolar(0);
        mMin.encolar(5);
        mMin.encolar(9);
        mMin.encolar(7);
        mMin.encolar(13);
        mMin.encolar(10);
        mMin.encolar(15);
        mMin.encolar(20);
        mMin.encolar(14);
        mMin.encolar(17);
        mMin.encolar(12);
        mMin.encolar(18);
        mMin.encolar(21);
        mMin.encolar(23);
        mMin.encolar(24);
        mMin.encolar(25);

        Integer dato = mMin.desencolar();
        System.out.println("Dato " + dato);
        mMin.imprimirMonticulo();
    }
}