package HW13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStreamToLowercase {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("some", "words", "in", "list", "and", "I", "don't", "know", "what", "to", "add");
        System.out.println(filterList(list));
    }

    static String filterList(List<String> list) {
        return list.stream().filter(s -> s.length() == 4).filter(s -> s.matches("^([a-z]).*")).collect(Collectors.joining(System.lineSeparator()));
    }
}
