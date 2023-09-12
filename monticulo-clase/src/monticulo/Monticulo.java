package monticulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Monticulo<T extends Comparable<T>> {
    protected List<T> xs;
    protected Comparator<T> comparador;


    protected Monticulo(Comparator<T> comparador) {
        this.comparador = comparador;
        this.xs = new ArrayList<>();
        this.xs.add(null);
    }

    protected boolean esRaiz(Object T) {

        return T.equals(this.xs.get(1));
    }

    public T mirarTope() {
        return this.xs.isEmpty() ? null : this.xs.get(1);
    }

    public abstract void encolar(T elemento);

    public abstract T desencolar();

    protected static <T extends Comparable<T>> T min(T a, T b) {
        if (a.compareTo(b) < 0) {
            return a;
        }
        return b;
    }

    protected static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) < 0) {
            return b;
        }
        return a;
    }

    public void imprimirMonticulo() {
        imprimirMonticuloRec(0, 1);
    }

    private void imprimirMonticuloRec(int nivel, int i) {
        if (i > xs.size() - 1) return;

        imprimirMonticuloRec(nivel + 1, 2 * i + 1);

        for (int j = 0; j < nivel; j++) {
            System.out.print("\t\t");
        }

        System.out.println(this.xs.get(i));

        imprimirMonticuloRec(nivel + 1, 2 * i);

    }


}

