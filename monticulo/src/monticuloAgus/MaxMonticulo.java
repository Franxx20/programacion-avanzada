package monticuloAgus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxMonticulo<T extends Comparable<? super T>> implements ColaDePrioridad2<T> {

    private List<T> heap;
    private int size;

    public MaxMonticulo() {
        heap = new ArrayList<>();
        size = 0;
    }

    public List<T> getHeap2() {
        return heap;
    }

    private boolean isBigger(int i, int j) {
        return heap.get(i).compareTo(heap.get(j)) > 0;
    }

    private void sortUp() {
        for (int i = this.size; i > 0 && isBigger(i, (i - 1) / 2); i = (i - 1) / 2) {
            Collections.swap(heap, i, ((i - 1) / 2));
        }
    }

    private void sortDown() {
        heap.add(0, heap.remove(this.size - 1));
        int i = 0;
        int parent;
        int childLeft;
        int childRight;

        do {
            parent = i;
            childLeft = (i * 2) + 1;
            childRight = (i * 2) + 2;

            if (childLeft < this.size && isBigger(childLeft, i)) {
                i = childLeft;
            }

            if (childRight < this.size && isBigger(childRight, i)) {
                i = childRight;
            }

            if (i != parent) {
                Collections.swap(heap, i, parent);
            }
        } while (i != parent);
    }

    @Override
    public void insert(T element) {
        this.heap.add(element);
        this.sortUp();
        this.size++;
    }

    @Override
    public T get() {
        if (heap.isEmpty()) {
            return null;
        }

        return heap.get(0);
    }

    @Override
    public T remove() {
        if (heap.isEmpty()) {
            return null;
        }

        T element = heap.remove(0);
        this.size--;

        if (this.size > 1) {
            this.sortDown();
        }

        return element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("[");
        for (int i = 0; i < this.size; i++) {
            str.append(heap.get(i).toString());
            if (i < this.size - 1) {
                str.append(", ");
            }
        }
        str.append("]");

        return str.toString();
    }

}