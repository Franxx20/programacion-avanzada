import java.util.Arrays;

public class longestCommonSecuence {
    private static int xys[][] = new int[1000][1000];


    // metodo por memorización
    public static int lcs(String x, String y, int posX, int posY) {

        if (posX == 0 || posY == 0)
            return 0;

        if (xys[posX - 1][posY - 1] != 0)
            return xys[posX - 1][posY - 1];

        if (x.charAt(posX - 1) == y.charAt(posY - 1)) {
            xys[posX - 1][posY - 1] = 1 + lcs(x, y, posX - 1, posY - 1);

            return xys[posX - 1][posY - 1];
        } else {
            xys[posX - 1][posY - 1] = Math.max(lcs(x, y, posX, posY - 1), lcs(x, y, posX - 1, posY));

            return xys[posX - 1][posY - 1];
        }

    }

    // metodo por tabulación
    public int lcsTab(String x, String y) {
        int tamX = x.length();
        int tamY = y.length();
        // se puede obtimizar usando dos array (actual y anterior) en vez de una matriz
        int xys[][] = new int[tamX + 1][tamY + 1];

        for (int i = 0; i <= tamX; i++) {
            for (int j = 0; j <= tamY; j++) {
                if (i == 0 || j == 0)
                    xys[i][i] = 0;
                else if (x.charAt(i - 1) == y.charAt(j - 1))
                    xys[i][j] = xys[i - 1][j - 1] + 1;
                else
                    xys[i][j] = Math.max(xys[i - 1][j], xys[i][j - 1]);
            }
        }

        return xys[tamX][tamY];
    }

    public int lcsTabOpt(String x, String y) {
        int tamX = x.length();
        int tamY = y.length();

        int[] prev = new int[tamY + 1];
        int[] curr = new int[tamY + 1];

        for (int i = 1; i <= tamX; i++) {
            for (int j = 1; j <= tamY; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(curr[j - 1], prev[j - 1]);
            }
            prev = Arrays.copyOf(curr, tamY + 1);
        }

        return curr[tamY];
    }

}
