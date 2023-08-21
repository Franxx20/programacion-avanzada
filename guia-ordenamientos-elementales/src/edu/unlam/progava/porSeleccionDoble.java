package edu.unlam.progava;

public class porSeleccionDoble extends Ordenadora {
    //A bidirectional variant of selection sort
    // (called double selection sort or sometimes cocktail sort
    // due to its similarity to cocktail shaker sort) finds both the minimum and maximum
    // values in the list in every pass. This requires three comparisons per two items
    // (a pair of elements is compared, then the greater
    // is compared to the maximum and the lesser is compared to the minimum)
    // rather than regular selection sort's one comparison per item,
    // but requires only half as many passes, a net 25% savings.
    @Override

    // el algoritmo de seleccionDoble es no sensible y no estable.
    public void ordenar(int[] array) {
        for (int ind_min = 0, ind_max = array.length - 1; ind_min < ind_max; ind_min++, ind_max--) {

            int min = array[ind_min];
            int max = array[ind_min];
            int pos_min = ind_min;
            int pos_max = ind_min;

            for (int ind_act = ind_min + 1; ind_act <= ind_max; ind_act++) {
                if (array[ind_act] > max) {
                    max = array[ind_act];
                    pos_max = ind_act;
                } else if (array[ind_act] < min) {
                    min = array[ind_act];
                    pos_min = ind_act;
                }
            }
            // intercambiar el minimo
            intercambiar(array, ind_min, pos_min);

            // intercambio el maximo
            if (array[pos_min] == max)
                intercambiar(array, ind_max, pos_min);
            else
                intercambiar(array, ind_max, pos_max);
        }
    }
}
