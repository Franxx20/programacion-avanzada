package edu.unlam.progava;

public class ShellSort extends Ordenadora {
    // sensible y no estable O(n^(3/2)
    @Override
    public void ordenar(int[] array) {
        // serie ki = ki-1 * 3 + 1

        int serieK=1;
        while(serieK<array.length)
        {
            serieK=serieK*3 +1;
        }

        while (serieK > 0) {
            OrdInsercion(array, serieK);

            // decremento la serie
            serieK = (serieK - 1) / 3;
        }
    }

    private static void OrdInsercion(int[] array, int serieK) {
        for (int externo = serieK; externo < array.length; externo++) {
            int extraido = array[externo];
            int interno = externo - serieK;

            while (interno >= 0 && array[interno] > extraido) {
                array[interno + serieK] = array[interno];
                interno -= serieK;
            }
            array[interno + serieK] = extraido;
        }
    }
}
