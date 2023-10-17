package grafos;
import monticulo.*;


public class Main {
    public static void main(String[] args) {
        Integer[] array = {5, 5, 9, 7, 13, 10, 15, 20, 14, 17, 12, 18, 21, 23, 24, 25};
        ColaDePrioridad<Integer> mMin = new MonticuloMin<>(array);
        ColaDePrioridad<Integer> mMax = new MonticuloMax<>(array);

        while (!mMax.isEmpty() && !mMin.isEmpty()) {
            System.out.println("mMin" + mMin);
            System.out.println("mMax" + mMax);

            Integer dato1 = mMin.remove();
            Integer dato2 = mMax.remove();
            System.out.println("dato 1 mMin " + dato1);
            System.out.println("dato 2 mMax " + dato2);
        }

    }
}