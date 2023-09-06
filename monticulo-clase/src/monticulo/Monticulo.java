package monticulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Monticulo<T extends Comparable<T>> {
    private List<T> xs;
    private Comparator<T> comparador;


    protected Monticulo(Comparator<T> comparador) {
        this.comparador = comparador;
        this.xs = new ArrayList<>();
    }


    public void encolar(T elemento) {
        xs.add(elemento);
    }

    public T desencolar() {
        T dato = xs.remove(1);

        T ultimo = xs.remove(xs.size() - 1);
        xs.add(1, ultimo);

        int i = 1;

        boolean desordenado;
        do {
            desordenado = false;
            if ((this.comparador.compare(this.xs.get(i), xs.get(i * 2)) > 0) || (this.comparador.compare(xs.get(i), xs.get(i * 2 + 1)) > 0)) {

                T minimo = Monticulo.min(xs.get(i * 2), xs.get(i * 2 + 1));
                int indiceMin = this.xs.indexOf(minimo);

                Collections.swap(this.xs, i, indiceMin);
                desordenado = true;

                i = indiceMin;
            }
        } while (desordenado && i *2 < this.xs.size()-1 && i*2+1 < this.xs.size()-1);

        return dato;
    }

    public static <T extends Comparable<T>> T min(T a, T b) {
        if (a.compareTo(b) < 0) {
            return a;
        }
        return b;
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

