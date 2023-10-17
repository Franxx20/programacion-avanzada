package monticuloAgus;

import java.util.List;

public interface ColaDePrioridad2<T extends Comparable<? super T>> {

    public void insert(T element);

    public T get();

    public T remove();

    public int size();

    public boolean isEmpty();

    List<T> getHeap2();
}