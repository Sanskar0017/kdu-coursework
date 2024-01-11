package org.backend1.que3;
import java.util.logging.Logger;

public class ArrayGenerics {

    public static final Logger LOGGER = Logger.getLogger(ArrayGenerics.class.getName());

    /**
     * @param arr
     * @param index1
     * @param index2
     * @param <T> is a type parameter / A generic type placeholder here
     */
    public static <T> void exchangeElementsPositions(T[] arr, int index1, int index2)
    {
        // Boundary conditions
        if(index1 < 0 || index2 < 0 || (index1 > arr.length - 1) || (index2 > arr.length - 1)){
            LOGGER.info("Out of bounds, check index to be switched again");
            return;
        }

        // Swapping using third variable of type 'T'
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String args[]){
            Double[] elements = {2.3, 4.5, 1.6, 7.9};
            exchangeElementsPositions(elements, 1, 3);
            exchangeElementsPositions(elements, 1, 9);

            for(double val : elements) LOGGER.info(String.valueOf(val));

            Integer[] arr = new Integer[]{1, 6, 8, 10, 6};
            exchangeElementsPositions(arr, 1, 3);
            for(Integer val : arr) LOGGER.info(String.valueOf(val));

            String[] words = new String[]{"Sanskar", "John", "Sherlock", "Axe", "Harvey"};
            exchangeElementsPositions(words, 0, 4);
            for(String val : words) LOGGER.info(String.valueOf(val));
    }
}
