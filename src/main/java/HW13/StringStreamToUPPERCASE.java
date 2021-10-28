package HW13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStreamToUPPERCASE {
    static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(initStringList());
        System.out.println(filterList(stringList));
    }

    private static List<String> initStringList(){
        stringList = Arrays.asList("Some","interesting","text","here","and","something","else");
        return stringList;
    }

    static List<String> filterList(List<String> list){
        list  =  list.stream()
                .filter(str -> str.matches("^(?i:[aeiouy]).*"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        return list;
    }
}
