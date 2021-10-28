package HW13;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

public class IntStream {
    private static final List<Integer> integerList = new ArrayList<>();
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println(initIntList());
        System.out.println("Average: " + getAverageValue(integerList));
    }

    public static List<Integer> initIntList() {
        for (int i = 0; i < 5; i++) {
            integerList.add(random.nextInt(100));
        }
        return integerList;
    }

    public static double getAverageValue(List<Integer> list) {
        OptionalDouble average = list.stream().mapToDouble(value -> value).average();
        return average.isPresent() ? average.getAsDouble() : 0;
    }
}