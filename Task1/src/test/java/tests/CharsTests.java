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
        String res = uniquenessOfChars.isAllCharsAreUnique(STRING_WITH_UNIQUE_CHARS);
        Assert.assertEquals(res, STRING_WITH_UNIQUE_CHARS);
    }

    @Test(description = "Checking with non-unique chars")
    public void checkWithNonUniqueCharsTest() {
        String res = uniquenessOfChars.isAllCharsAreUnique(STRING_WITH_NON_UNIQUE_CHARS);
        Assert.assertEquals(res, "String has non-unique chars");
    }

    @Test(description = "Checking with empty string")
    public void checkWithEmptyStringTest() {
        String res = uniquenessOfChars.isAllCharsAreUnique(EMPTY_STRING);
        Assert.assertEquals(res, EMPTY_STRING);
    }

    @Test(description = "Checking with user-entered string")
    public void checkWithUserInputStringTest() {
        try {
            String resOfMethod = uniquenessOfChars.isAllCharsAreUnique(USER_INPUT);
            if (resOfMethod.equals("String has non-unique chars")) {
                Assert.assertEquals(resOfMethod, "String has non-unique chars");
            } else {
                Assert.assertEquals(resOfMethod, USER_INPUT);
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
        String res = uniquenessOfChars.isAllCharsAreUnique(str);
        Assert.assertEquals(res, str);
    }
}
