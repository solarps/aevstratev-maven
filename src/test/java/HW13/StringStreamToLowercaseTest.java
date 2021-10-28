package HW13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class StringStreamToLowercaseTest {
    List<String> list = Arrays.asList("text", "word", "people", "robots");

    @Test
    public void test_filter_string() {
        //expected result
        StringBuilder expectedResult = new StringBuilder();
        for (String word : list) {
            if (word.length() == 4) {
                if (word.matches("^([a-z]).*")) {
                    if (expectedResult.toString().equals(""))
                        expectedResult.append(word);
                    else expectedResult.append(System.lineSeparator()).append(word);
                }
            }
        }
        //actual result
        Assertions.assertEquals(expectedResult.toString(), StringStreamToLowercase.filterList(list));
    }
}
