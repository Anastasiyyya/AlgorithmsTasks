package array;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class MaxProductOfArray {

    int array[];
    int length;
    int productOfNumbers;

    public String generateArray() {
        Random generator = new Random();
        length = Integer.parseInt(JOptionPane.showInputDialog(
                null, "Please, enter a number > 3:"));
        if (length > 3) {
            array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = 100 - generator.nextInt(201);
            }
            Arrays.sort(array);
            System.out.print(Arrays.toString(array));
        }
        return "Error, please enter a number > 3!!!";
    }

    public int maxProductOfArray() {
        if (array[0] * array[1] > array[length - 1] * array[length - 2]) {
            productOfNumbers = array[0] * array[1] * array[length - 1];
        } else {
            productOfNumbers = array[length - 3] * array[length - 2] * array[length - 1];
        }
        return productOfNumbers;
    }

    public int getProductOfNumbers() {
        return productOfNumbers;
    }
}


