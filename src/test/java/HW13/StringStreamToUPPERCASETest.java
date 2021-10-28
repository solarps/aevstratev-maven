package HW13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StringStreamToUPPERCASETest {
    List<String> list = Arrays.asList("apple", "word", "people", "robots");

    @Test
    public void filter_to_uppercase_test() {
        //expected result
        List<String> newList = new ArrayList<>();
        for (String str : list) {
            if (str.matches("^(?i:[aeiouy]).*")) {
                newList.add(str.toUpperCase());
            }
        }
        //actual result
        Assertions.assertEquals(newList, StringStreamToUPPERCASE.filterList(list));
    }
}