package array;

import java.util.Arrays;

public class Array {

    int productOfNumbers;

    public String maxProductOfArray(int[] array) {
        int length = array.length;
        if (length >= 3) {
            Arrays.sort(array);
            System.out.println(Arrays.toString(array));
            if (array[0] * array[1] > array[length - 1] * array[length - 2]) {
                productOfNumbers = array[0] * array[1] * array[length - 1];
            } else {
                productOfNumbers = array[length - 3] * array[length - 2] * array[length - 1];
            }
            System.out.print(productOfNumbers);
        } else {
            return "Error, please enter a number > 3!!!";
        }
        return Integer.toString(productOfNumbers);
    }
}


