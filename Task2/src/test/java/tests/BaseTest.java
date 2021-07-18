package tests;

import array.MaxProductOfArray;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;


public class BaseTest  {

    MaxProductOfArray maxProductOfArray;

    @BeforeMethod
    public void initPages(ITestContext context) {
        maxProductOfArray = new MaxProductOfArray();
    }
}
