package monticulo;

import java.util.Comparator;

public class MonticuloDeMaximo <T extends Comparable<T>> extends Monticulo<T>{
    protected MonticuloDeMaximo() {
        super(Comparator.reverseOrder());
    }
}
