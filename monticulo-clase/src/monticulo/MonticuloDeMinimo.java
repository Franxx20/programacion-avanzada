package monticulo;

import java.util.Collections;
import java.util.Comparator;

public class MonticuloDeMinimo<T extends Comparable<T>> extends Monticulo<T> {
    protected MonticuloDeMinimo() {
        super(Comparator.naturalOrder());
    }


}
