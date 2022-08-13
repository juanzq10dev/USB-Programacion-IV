package LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleLinkedListTest {

    @Test
    public void add_AddingTwoElements_TheSecondElement() {
        LinkedList<String> fruitList = new SimpleLinkedList<String>();

        fruitList.add("banana");
        fruitList.add("apple");
        String result = fruitList.get(1); 
        String expected = "apple"; 

        assertEquals(expected, result);
    }

    @Test 
    public void add_AddingTwoElements_TheSizeIncreases() {
        LinkedList<String> fruitList = new SimpleLinkedList<String>();

        fruitList.add("banana");
        fruitList.add("apple");
        int result = fruitList.getSize(); 
        int expected = 2; 

        assertEquals(expected, result);
    }

    @Test 
    public void add_AddingAndElementNextToOther_TheElementAddedSuccesfully() {
        LinkedList<String> fruitList = new SimpleLinkedList<String>();

        fruitList.add("banana");
        fruitList.add("apple");
        fruitList.add("banana", "tomato");
        String result = fruitList.get(1);
        String expected = "tomato";

        assertEquals(expected, result);
    }

    @Test
    public void add_AddingAnElementAfterTheHead_TheElementAddedSuccesfully() {
        LinkedList<String> fruitList = new SimpleLinkedList<String>();

        fruitList.add("banana");
        fruitList.add("apple");
        fruitList.add("apple", "tomato");
        String result = fruitList.get(2);
        String expected = "tomato";

        assertEquals(expected, result);
    }

    @Test 
    public void add_AddingAnInvalidPrevValue_InvalidArgumentException() {
        LinkedList<String> fruitList = new SimpleLinkedList<String>();

        fruitList.add("banana");
        fruitList.add("apple");

        assertThrows(IllegalArgumentException.class, () -> fruitList.add("pie", "tomato"));
    }

    @Test 
    public void remove_RemovingTheHead_TheHeadWasRemoved() {
        LinkedList<String> fruitList = new SimpleLinkedList<String>();

        fruitList.add("pinneaple"); 
        fruitList.add("apple"); 
        fruitList.add("orange");
        fruitList.add("banana");
        fruitList.remove("pinneaple");
        String result = fruitList.get(0); 
        String expected = "apple"; 

        assertEquals(expected, result);
    }

    @Test 
    public void remove_RemovingTheTale_TheTaleWasRemoved() {
        LinkedList<String> fruitList = new SimpleLinkedList<String>();

        fruitList.add("pinneaple"); 
        fruitList.add("apple"); 
        fruitList.add("orange");
        fruitList.add("banana");
        fruitList.remove("apple");
        fruitList.add("tomato");
        String result = fruitList.get(3); 
        String expected = "tomato"; 

        assertEquals(expected, result);
    }

    @Test
    public void remove_RemovingAnElement_TheSizeDecreases() {
        LinkedList<String> fruitList = new SimpleLinkedList<String>();

        fruitList.add("pinneaple"); 
        fruitList.add("apple"); 
        fruitList.add("orange");
        fruitList.add("banana");
        fruitList.remove("apple");
        int result = fruitList.getSize();
        int expected = 3;

        assertEquals(expected, result);
    }

    @Test 
    public void isEmpty_AddingAnElement_False() {
        LinkedList<Integer> numbersList = new SimpleLinkedList<Integer>();

        numbersList.add(1);
        boolean result = numbersList.isEmpty(); 

        assertFalse(result);
    }

    @Test 
    public void isEmpty_AddingNoElement_True() {
        LinkedList<Integer> numbersList = new SimpleLinkedList<Integer>();

        boolean result = numbersList.isEmpty(); 

        assertTrue(result);
    }

    @Test
    public void add_AddingWithOrder_ListSorted() {
        LinkedList<Integer> numbersList = new SimpleLinkedList<Integer>();
        numbersList.add(5, Comparator.naturalOrder());
        numbersList.add(3, Comparator.naturalOrder());
        numbersList.add(1, Comparator.naturalOrder());
        numbersList.add(4, Comparator.naturalOrder());
        numbersList.add(2, Comparator.naturalOrder());
        numbersList.add(6, Comparator.naturalOrder());

        Object[] expected = {1, 2, 3, 4, 5, 6};
        Object[] result = numbersList.toArray();
        assertArrayEquals(expected, result);
    }
}
