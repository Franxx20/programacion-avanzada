public class Factorial {
    private static int[] xs = new int[1000];

    static int fact(int n) {
        if (n <= 1)
            return 1;

        if (xs[n] != 0)
            return xs[n];
        else {
            xs[n] = n * fact(n - 1);
            return xs[n];
        }


    }
}
