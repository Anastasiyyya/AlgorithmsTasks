package tests;

import constants.ITestConst;
import methods.UniquenessOfChars;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;


public class BaseTest implements ITestConst {
    UniquenessOfChars uniquenessOfChars;

    @BeforeMethod
    public void initMethods(ITestContext context) {
        uniquenessOfChars = new UniquenessOfChars();
    }
}
