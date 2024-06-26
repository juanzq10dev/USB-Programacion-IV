package Heaps;

import java.util.Arrays;


import Person.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTests {
    @Test
    public void sort_LongArray_ArraySorted() {
        MaxHeap<Long> heap = new MaxHeap<Long>(new Long[] { 9L, 10L, 7L, 8L, 5L, 6L, 3L, 4L, 1L, 2L, 0L });
        Long[] result = heap.getArray();
        Long[] expected = {10L, 9L , 8L, 7L, 6L, 5L, 4L, 3L, 2L, 1L, 0L };
        assertArrayEquals(expected, result);
    }

    @Test
    public void sort_StringArray_ArraySorted() {
        MaxHeap<String> heap = new MaxHeap<String>(new String[] {"k", "j", "a", "d", "b", "f", "c", "e", "g", "h"});
        String[] result = heap.getArray();
        String[] expected = {"k", "j", "h", "g", "f", "e", "d", "c", "b", "a"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void sort_PersonArray_ArraySorted() {
        Person[] array = {
            new Person("b", "2000-01-01", "7"),
            new Person("c", "2000-01-01", "3"),
            new Person("d", "2000-01-01", "9"),
            new Person("e", "2000-01-01", "5"),
            new Person("f", "2000-01-01", "6"),
            new Person("g", "2000-01-01", "2"),
            new Person("h", "2000-01-01", "8"),
            new Person("i", "2000-01-01", "4"),
            new Person("j", "2000-01-01", "1")
        };
        MaxHeap<Person> heap = new MaxHeap<Person>(array);
        
        Person[] expected = {
            new Person("d", "2000-01-01", "9"),
            new Person("h", "2000-01-01", "8"),
            new Person("b", "2000-01-01", "7"),
            new Person("f", "2000-01-01", "6"),
            new Person("e", "2000-01-01", "5"),
            new Person("i", "2000-01-01", "4"),
            new Person("c", "2000-01-01", "3"),
            new Person("g", "2000-01-01", "2"),
            new Person("j", "2000-01-01", "1"),
        };
        Person[] result = heap.getArray();

        assertArrayEquals(expected, result);
    }
    
    @Test
    public void add_InsertingElementAtTheBeginning_arraySorted() {
        MaxHeap<Long> heap = new MaxHeap<Long>(new Long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L});
        heap.add(11L);

        Long[] result = heap.getArray();
        result = Arrays.stream(result).filter(x -> x != null).toArray(Long[]::new);
        Long[] expected = {11L, 10L, 8L, 7L, 9L, 5L, 4L, 3L, 2L, 1L, 6L};

        assertArrayEquals(expected, result);
    }

    @Test
    public void removeRoot_removingRoot_RemovesRootAndReorderedHeap() {
        MaxHeap<Long> heap = new MaxHeap<>(new Long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L});

        long actualRoot = heap.removeRoot();
        long expectedRoot = 10L;
        Long[] resultArray = heap.getArray();
        resultArray = Arrays.stream(resultArray).filter(x -> x != null).toArray(Long[]::new);
        Long[] expectedArray = {9L, 7L, 8L, 3L, 6L, 5L, 4L, 1L, 2L};

        assertArrayEquals(expectedArray, resultArray);
        assertEquals(expectedRoot, actualRoot);
    }

    @Test
    public void removeRoot_removingRootFromEmptyHeap_ReturnsNull() {
        MaxHeap<Long> heap = new MaxHeap<>();
        Long actualRoot = heap.removeRoot();
        assertNull(actualRoot);
    }

    @Test
    public void peek_peekingRootTwice_ReturnsRoot() {
        MaxHeap<Long> heap = new MaxHeap<>(new Long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L});
        long actualFirstPeek = heap.peek();
        long actualSecondPeek = heap.peek();
        long expectedFirstPeek = 10L;
        long expectedSecondPeek = 10L;
        assertEquals(actualFirstPeek, expectedFirstPeek);
        assertEquals(actualSecondPeek, expectedSecondPeek);
    }

    @Test
    public void peek_peekingRootFromEmptyHeap_ReturnsNull() {
        MaxHeap<Long> heap = new MaxHeap<>();
        Long actualRoot = heap.peek();
        assertNull(actualRoot);
    }
}
