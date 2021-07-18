package methods;

import lombok.extern.log4j.Log4j2;

import java.util.HashSet;
import java.util.Locale;

@Log4j2
public class UniquenessOfChars {
    /**
     * This method checks if the chars are unique
     * @param str
     * @return str or message 'String has non-unique chars'
     */
    public String isAllCharsAreUnique(String str) {
        str = str.toLowerCase(Locale.ROOT);
        int count = 0;
        HashSet<Character> charsOfStr = new HashSet<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            charsOfStr.add(str.charAt(i));
            count ++;
            if (count != charsOfStr.size()) {
                return "String has non-unique chars";
            }
        }
        return str;
    }
}
