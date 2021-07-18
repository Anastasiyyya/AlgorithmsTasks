package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class MaxProductTests extends BaseTest {
    /**
     * This test checks if the method return maxProductOfArray
     */
    @Test
    public void maxProductOfArrayTest(){
        maxProductOfArray.generateArray();
        int result = maxProductOfArray.maxProductOfArray();
        Assert.assertEquals(result,maxProductOfArray.getProductOfNumbers());
    }
}