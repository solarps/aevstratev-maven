package HW12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCollectionImpTest {
    private StringCollection stringCollection;
    private final int initCapacity = 10;
    private int actualCapacity = initCapacity;

    @BeforeEach
    public void initCollection() {
        stringCollection = new StringCollectionImp();
        for (int i = 0; i < initCapacity; i++) {
            stringCollection.add("str" + i);
        }
    }

    @Test
    public void test_get_normal_case() {
        //expected results
        String expected = "str1";
        //actual result
        String actual = stringCollection.get(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_get_negative_case() {
        //expected results
        String expected = "Index out of bounds";
        //actual result
        String actual = stringCollection.get(actualCapacity + 100);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void test_add_element() {
        String element = "Added element";
        //expected results
        actualCapacity++;
        //actual result
        stringCollection.add(element);
        Assertions.assertTrue(stringCollection.contains(element));
        Assertions.assertEquals(stringCollection.size(), actualCapacity);
    }

    @Test
    public void test_add_by_index_element_normal_case() {
        String element = "Added by index element";
        //expected results
        actualCapacity++;
        //actual result
        stringCollection.add(2, element);
        Assertions.assertTrue(stringCollection.contains(element));
        Assertions.assertEquals(stringCollection.get(2), element);
        Assertions.assertEquals(stringCollection.size(), actualCapacity);
    }

    @Test
    public void test_add_by_index_element_negative_case(){
        Assertions.assertFalse(stringCollection.add(actualCapacity+100,"element"));
    }

    @Test
    public void test_delete_element_normal_case() {
        //expected result
        String deleted_Element = "str5";
        actualCapacity--;
        //actual result
        Assertions.assertTrue(stringCollection.contains(deleted_Element));
        Assertions.assertTrue(stringCollection.delete(deleted_Element));
        Assertions.assertEquals(actualCapacity, stringCollection.size());
        Assertions.assertFalse(stringCollection.contains(deleted_Element));
    }

    @Test
    public void test_delete_element_negative_case() {
        String deleted_element = "Doesn't exist element";
        Assertions.assertFalse(stringCollection.contains(deleted_element));
        Assertions.assertFalse(stringCollection.delete(deleted_element));
    }

    @Test
    public void test_contains_element_normal_case() {
        Assertions.assertTrue(stringCollection.contains("str1"));
    }

    @Test
    public void test_contains_element_negative_case(){
        Assertions.assertFalse(stringCollection.contains("Doesn't exist element"));
    }
    @Test
    public void test_equals_collections_normal_case() {
        StringCollection newCollection = stringCollection;
        Assertions.assertTrue(stringCollection.equals(newCollection));
    }

    @Test
    public void test_equals_collections_negative_case() {
        StringCollection newCollection = new StringCollectionImp();
        Assertions.assertFalse(stringCollection.equals(newCollection));
    }

    @Test
    public void test_clear_collection() {
        //expected result
        actualCapacity = 0;
        //actual result
        Assertions.assertTrue(stringCollection.clear());
        Assertions.assertEquals(actualCapacity, stringCollection.size());
        Assertions.assertFalse(stringCollection.contains("str1"));
    }

    @Test
    public void test_size_collection() {
        Assertions.assertEquals(initCapacity, stringCollection.size());
    }
}