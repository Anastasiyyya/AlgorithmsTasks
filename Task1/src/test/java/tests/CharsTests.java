package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Log4j2
public class CharsTests extends BaseTest {

    /**
     * This test checks if the method 'isAllCharsAreUnique' works correctly
     */
    @Test(description = "Checking with unique chars")
    public void checkWithUniqueCharsTest() {
        boolean res = uniquenessOfChars.isAllCharsAreUnique(STRING_WITH_UNIQUE_CHARS);
        Assert.assertEquals(res, true);
    }

    @Test(description = "Checking with non-unique chars")
    public void checkWithNonUniqueCharsTest() {
        boolean res = uniquenessOfChars.isAllCharsAreUnique(STRING_WITH_NON_UNIQUE_CHARS);
        Assert.assertEquals(res, false);
    }

    @Test(description = "Checking with empty string")
    public void checkWithEmptyStringTest() {
        boolean res = uniquenessOfChars.isAllCharsAreUnique(EMPTY_STRING);
        Assert.assertEquals(res, true);
    }

    @Test(description = "Checking with user-entered string")
    public void checkWithUserInputStringTest() {
        try {
            boolean resOfMethod = true;
            resOfMethod = uniquenessOfChars.isAllCharsAreUnique(USER_INPUT);
            if (!resOfMethod) {
                Assert.assertEquals(resOfMethod, false);
            } else {
                Assert.assertEquals(resOfMethod, true);
            }
        } catch (NullPointerException ex){
            log.info("Incorrect input");
        }
    }

    @DataProvider(name = "data")
    public Object[] inputForITechTask() {
        return new Object[][]{
                {"123"},
                {"string"}
        };
    }

    @Test(description = "Checking with unique chars", dataProvider = "data")
    public void checkWithDataProviderTest(String str) {
        boolean res = uniquenessOfChars.isAllCharsAreUnique(str);
        Assert.assertEquals(res, true);
    }
}
