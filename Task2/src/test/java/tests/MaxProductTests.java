package tests;

import array.Array;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class MaxProductTests {

    Array array =  new Array();

    int array1[] = {-1, 1};
    int array2[] = {-2, 2, 3};
    int array3[] = {-100, -10, 1, 2, 3, 4};
    int array4[] = {20,  -30, -10, -50, 7, 0, 6};

    /**
     * This test checks if the method return maxProductOfArray
     */
    @Test
    public void maxProductOfArrayTest1(){
        String result = array.maxProductOfArray(array1);
        Assert.assertEquals(result, "Error, please enter a number > 3!!!");
    }

    /**
     * This test checks if the method return maxProductOfArray
     */
    @Test
    public void maxProductOfArrayTest2(){
        String result = array.maxProductOfArray(array2);
        Assert.assertEquals(result, "-12");
    }

    /**
     * This test checks if the method return maxProductOfArray
     */
    @Test
    public void maxProductOfArrayTest3(){
        String result = array.maxProductOfArray(array3);
        Assert.assertEquals(result, "4000");
    }

    /**
     * This test checks if the method return maxProductOfArray
     */
    @Test
    public void maxProductOfArrayTest4(){
        String result = array.maxProductOfArray(array4);
        Assert.assertEquals(result, "30000");
    }
}