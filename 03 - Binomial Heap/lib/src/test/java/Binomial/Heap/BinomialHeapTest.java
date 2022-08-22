package Binomial.Heap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinomialHeapTest {
    @Test
    void insert_InsertingUnsortedElements_TheTreesResizeCorrectly() {
        BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>(); 
        binomialHeap.insert(10);
        binomialHeap.insert(50);
        binomialHeap.insert(30);
        binomialHeap.insert(40);

        int expectedMax = 50; 
        int actualMax = binomialHeap.getMax();
        int expectedTress = 1; 
        int actualTress = binomialHeap.getNumberOfBinomialTrees();
        Integer[] expectedDegrees = {2};
        Integer[] actualDegrees = binomialHeap.getBinomialTreeRanks();

        assertEquals(expectedMax, actualMax);
        assertEquals(expectedTress, actualTress);
        assertArrayEquals(expectedDegrees, actualDegrees);
    }
    
    @Test
    void deleteMax_DeletingMax_TreesResizeCorrectly() {
        BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>(); 
        binomialHeap.insert(67);
        binomialHeap.insert(5);
        binomialHeap.insert(35);
        binomialHeap.insert(25);
        binomialHeap.insert(26);
        binomialHeap.insert(15);
        binomialHeap.insert(4);
        binomialHeap.insert(3);
        binomialHeap.insert(45);

        binomialHeap.deleteMax();

        int expectedMax = 45; 
        int actualMax = binomialHeap.getMax();
        int expectedTress = 1; 
        int actualTress = binomialHeap.getNumberOfBinomialTrees();
        Integer[] expectedDegrees = {3};
        Integer[] actualDegrees = binomialHeap.getBinomialTreeRanks();

        assertEquals(expectedMax, actualMax);
        assertEquals(expectedTress, actualTress);
        assertArrayEquals(expectedDegrees, actualDegrees);
    }
}
