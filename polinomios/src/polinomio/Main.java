package polinomio;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Polinomio pol = new PolHorner(new double[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println("polinomo " + pol);
        double val = 10000;
        System.out.println("evaluado a " + val + " = "+ pol.evaluar(val));

    }
}