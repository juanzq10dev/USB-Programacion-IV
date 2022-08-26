package Binomial.Heap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

public class BinomialHeapTest {
    @ParameterizedTest
    @MethodSource("Binomial.Heap.ValuesProvider#checkMaxValueArguments")
    void insert_InsertingElements_CheckingMaxValue(Integer[] values, Integer max) {
        BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>(values);

        Integer actualMax = binomialHeap.getMax();

        assertEquals(max, actualMax);
    }

    @ParameterizedTest
    @MethodSource("Binomial.Heap.ValuesProvider#checkTressNumbersArguments")
    void getNumberOfTrees_InsertingElements_CheckingExpectedTrees(Integer[] values, int expectedNumberOfTrees) {
        BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>(values);

        int actualTress = binomialHeap.getNumberOfBinomialTrees();

        assertEquals(expectedNumberOfTrees, actualTress);
    }

    @ParameterizedTest
    @MethodSource("Binomial.Heap.ValuesProvider#checkTressRanksArguments")
    void getTreeRanks_InsertingElements_CheckingTreeRanks(Integer[] values, Integer[] expectedRanks) {
        BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>(values);

        Integer[] actualTress = binomialHeap.getBinomialTreeRanks();

        assertArrayEquals(expectedRanks, actualTress);
    }

    @ParameterizedTest
    @MethodSource("Binomial.Heap.ValuesProvider#checkMaxAfterDelete")
    void deleteMax_deletingMaxElements_CheckingNewMax(Integer[] values, int expectedMaxAfterDelete) {
        BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>(values);

        binomialHeap.deleteMax();

        int actualMax = binomialHeap.getMax();
        assertEquals(expectedMaxAfterDelete, actualMax);
    }

    @ParameterizedTest
    @MethodSource("Binomial.Heap.ValuesProvider#checkTreesNumberAfterDelete")
    void deleteMax_deletingMaxElement_CheckingNewTreesNumber(Integer[] values, int expectedNewTreesNumber) {
        BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>(values);

        binomialHeap.deleteMax();

        int actualTrees = binomialHeap.getNumberOfBinomialTrees();
        assertEquals(expectedNewTreesNumber, actualTrees);
    }

    @ParameterizedTest
    @MethodSource("Binomial.Heap.ValuesProvider#checkTreesRanksAfterDelete")
    void deleteMax_deletingMaxElement_CheckingTreesRank(Integer[] values, Integer[] expectedTreesRank) {
        BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>(values);

        binomialHeap.deleteMax();

        Integer[] actualTreesRanks = binomialHeap.getBinomialTreeRanks();
        assertArrayEquals(expectedTreesRank, actualTreesRanks);
    }

    @ParameterizedTest
    @MethodSource("Binomial.Heap.ValuesProvider#checkMaxInsertAfterDelete")
    void deleteMax_insertingElementAfterDelete_MaxUpdatesCorrectly(Integer[] values, int toInsert, int expectedMax) {
        BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>(values);

        binomialHeap.deleteMax();
        binomialHeap.insert(toInsert);

        int actualMax = binomialHeap.getMax();
        assertEquals(expectedMax, actualMax);
    }

    @ParameterizedTest
    @MethodSource("Binomial.Heap.ValuesProvider#checkInsertionWithSameElements")
    void insert_InsertingSameElements_CheckingBinaryTreesRanks(Integer[] values, Integer[] expectedTreesRanks) {
        BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>(values);

        Integer[] actualTreeRanks = binomialHeap.getBinomialTreeRanks();
        assertArrayEquals(expectedTreesRanks, actualTreeRanks);
    }

    @ParameterizedTest
    @MethodSource("Binomial.Heap.ValuesProvider#checkInsertionWithSameElements")
    void insert_InsertingNullElements_CheckingBinaryTreesRanks(Integer[] values, Integer[] expectedTreesRanks) {
        BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>(values);

        Integer[] actualTreeRanks = binomialHeap.getBinomialTreeRanks();
        assertArrayEquals(expectedTreesRanks, actualTreeRanks);
    }

    @ParameterizedTest
    @MethodSource("Binomial.Heap.ValuesProvider#checkMaxDeletingAllElements")
    void deleteMax_DeletingAllElements_MaxIsNull(Integer[] values) {
        BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>(values);

        for (int i = 0; i < values.length; i++) {
            binomialHeap.deleteMax();
        }

        Integer actualMax = binomialHeap.getMax();
        assertNull(actualMax);
    }
 }
