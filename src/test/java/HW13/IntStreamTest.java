package HW13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class IntStreamTest {
    List<Integer> list = new ArrayList<>();
    Random random = new Random();

    @BeforeEach
    public void init(){
        for (int i = 0; i < 5; i++) {
            list.add(random.nextInt(100));
        }
    }

    @Test
    public void test_getAverage() {
        //expected result
        double expectedAverage = 0;
        for (Integer integer : list) {
            expectedAverage += integer;
        }
        expectedAverage /= list.size();
        //actual result
        double actualAverage = IntStream.getAverageValue(list);
        Assertions.assertEquals(expectedAverage,actualAverage);
    }
}