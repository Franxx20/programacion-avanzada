// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(Fibbonacci.fib(9) + " " + Fibbonacci.fib(5) + " " + Fibbonacci.fib(3) + " ");
        System.out.println(Factorial.fact(9) + " " + Factorial.fact(5) + " " + Factorial.fact(3) + " ");

        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of LCS is " + longestCommonSecuence.lcs(X, Y, m, n));
        System.out.println("Length of LCS Tab is " + new longestCommonSecuence().lcsTab(X, Y));
        System.out.println("Length of LCS Tab opt is " + new longestCommonSecuence().lcsTabOpt(X, Y));
    }

}