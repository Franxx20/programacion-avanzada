package monticulo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Monticulo<Integer> mMin = new MonticuloDeMinimo<>();
        Monticulo<Integer> mMax = new MonticuloDeMaximo<>();

        Integer[] array = {5,5,9,7,13,10,15,20,14,17,12,18,21,23,24,25};

        List<Integer> intList = Arrays.asList(array);

        Collections.shuffle(intList);


        for (Integer dato : intList)
        {
            mMax.encolar(dato);
        }

        mMax.imprimirMonticulo();

        while(mMax.xs.size()>1){

            Integer dato = mMax.desencolar();
            System.out.println("Dato " + dato);
            mMax.imprimirMonticulo();
        }

    }
}