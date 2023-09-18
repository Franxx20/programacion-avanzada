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


    public void encolar(T elemento) {
        xs.add(elemento);

        if (xs.size() < 3)
            return;

        int i = xs.size() - 1;
        boolean desordenado;
        do {
            desordenado = false;
            int padre = i / 2;

            if (this.comparador.compare(elemento, xs.get(padre)) < 0) {
                Collections.swap(this.xs, i, padre);
                desordenado = true;
            }
            i = padre;
        } while (desordenado && !esRaiz(elemento));
    }

    public T desencolar() {
        if (xs.size() == 1)
            return null;

        T dato = xs.remove(1);

        if (xs.size() <= 2)
            return dato;

        T ultimo = xs.remove(xs.size() - 1);
        xs.add(1, ultimo);

        int ind_padre = 1;

        boolean desordenado;

        if (xs.size() > 3) {
            do {
                desordenado = false;
                if (condicionIntercambio(ind_padre)) {
                    int ind_hijo_izq = ind_padre * 2;
                    int ind_hijo_der = ind_padre * 2 + 1;

                    int indInter = this.comparador.compare(xs.get(ind_hijo_izq), xs.get(ind_hijo_der)) <= 0 ? ind_hijo_izq : ind_hijo_der;
                    Collections.swap(this.xs, ind_padre, indInter);
                    desordenado = true;

                    ind_padre = indInter;
                }
            } while (desordenado && poseeNodosHijos(ind_padre));
        } else {
            if ((this.comparador.compare(this.xs.get(1), this.xs.get(2))) >= 0) {
                Collections.swap(this.xs, 1, 2);
            }
        }


        return dato;
    }

    private boolean poseeNodosHijos(int i) {
        return i * 2 < this.xs.size() && i * 2 + 1 < this.xs.size();
    }

    private boolean condicionIntercambio(int i) {
        return (this.comparador.compare(this.xs.get(i), xs.get(i * 2)) >= 0) || (this.comparador.compare(xs.get(i), xs.get(i * 2 + 1)) >= 0);
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

