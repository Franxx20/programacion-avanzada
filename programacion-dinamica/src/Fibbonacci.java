public class Fibbonacci {
    private static int[] xs = new int[1000];

    static int fib(int n) {
        if (n <= 1)
            return n;
        if (xs[n] != 0)
            return xs[n];
        else {
            xs[n] = fib(n - 1) + fib(n - 2);
            return xs[n];
        }
    }
}
