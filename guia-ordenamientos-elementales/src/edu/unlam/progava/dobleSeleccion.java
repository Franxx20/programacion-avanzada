package edu.unlam.progava;

public class dobleSeleccion extends Ordenadora{
    //A bidirectional variant of selection sort
    // (called double selection sort or sometimes cocktail sort
    // due to its similarity to cocktail shaker sort) finds both the minimum and maximum
    // values in the list in every pass. This requires three comparisons per two items
    // (a pair of elements is compared, then the greater
    // is compared to the maximum and the lesser is compared to the minimum)
    // rather than regular selection sort's one comparison per item,
    // but requires only half as many passes, a net 25% savings.
    @Override

    public void ordenar(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[posMenor])
                    posMenor = j;
            }
            intercambiar(array, i, posMenor);
        }
    }
}
