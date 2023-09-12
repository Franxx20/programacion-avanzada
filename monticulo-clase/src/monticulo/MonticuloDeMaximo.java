package monticulo;

import java.util.Collections;
import java.util.Comparator;

public class MonticuloDeMaximo <T extends Comparable<T>> extends Monticulo<T>{
    protected MonticuloDeMaximo() {
        super(Comparator.reverseOrder());
    }

    @Override
    public void encolar(T elemento) {
        xs.add(elemento);

        if (xs.size() == 2)
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

    @Override
    public T desencolar() {
        if (xs.size() == 1)
            return null;

        T dato = xs.remove(1);

        if (xs.size() < 3)
            return dato;

        T ultimo = xs.remove(xs.size() - 1);
        xs.add(1, ultimo);

        int i = 1;

        boolean desordenado;
        do {
            desordenado = false;
            if (xs.size() > 3) {

                if ((this.comparador.compare(this.xs.get(i), xs.get(i * 2)) > 0) || (this.comparador.compare(xs.get(i), xs.get(i * 2 + 1)) > 0)) {

                    T maximo = Monticulo.max(xs.get(i * 2), xs.get(i * 2 + 1));
                    int indiceMax = this.xs.indexOf(maximo);

                    Collections.swap(this.xs, i, indiceMax);
                    desordenado = true;

                    i = indiceMax;
                }
            } else {
                if ((this.comparador.compare(this.xs.get(1), this.xs.get(2))) > 0) {
                    Collections.swap(this.xs, 1, 2);
                }
            }

        } while (desordenado && i * 2 < this.xs.size() && i * 2 + 1 < this.xs.size());

        return dato;
    }
}
