package Btree;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BtreeTest {
    @ParameterizedTest
    @MethodSource("Btree.ValuesProvider#insertIntegerElementsCheckingSize")
    void insert_InserIntegerElements_CheckingSize(Integer[] elements, int range, int expectedSize) {
        Tree<Integer> tree = new Btree<Integer>(range); 

        tree.insert(elements);

        int actualSize = tree.size(); 
        assertEquals(expectedSize, actualSize);
    }

    @ParameterizedTest
    @MethodSource("Btree.ValuesProvider#insertIntegerElementsCheckingHeadValues")
    void insert_InserIntegerElements_CheckingHeads(Integer[] elements, int range, Integer[] expectedHeadValues) {
        Tree<Integer> tree = new Btree<Integer>(range); 

        tree.insert(elements);

        Integer[] actualHeadValues = tree.getHeadValues(); 
        assertArrayEquals(expectedHeadValues, actualHeadValues);
    }

    @ParameterizedTest
    @MethodSource("Btree.ValuesProvider#findExistingIntegerElements")
    void find_FindExistingIntegerElements_CheckingFindElement(Integer[] elements, int range, Integer toFind) {
        Tree<Integer> tree = new Btree<Integer>(range); 

        tree.insert(elements);
        Integer result = tree.find(toFind);
 
        assertEquals(toFind, result);
    }

    @ParameterizedTest
    @MethodSource("Btree.ValuesProvider#findNonExistingIntegerElements")
    void find_FindNonExistingElements(Integer[] values, int range, int toFind) {
        Tree<Integer> tree = new Btree<Integer>(range); 

        tree.insert(values);

        Integer result = tree.delete(toFind);
        assertNull(result);
    }

    @ParameterizedTest
    @MethodSource("Btree.ValuesProvider#deleteIntegerValuesCheckHead")
    void delete_DeletingIntegerElements_CheckingHeadValues(Integer[] values, int range, int toDelete, Integer[] expectedHeadValues) {
        Tree<Integer> tree = new Btree<Integer>(range);

        tree.insert(values);
        tree.delete(toDelete); 

        Integer[] actualHeadValues = tree.getHeadValues(); 
        assertArrayEquals(expectedHeadValues, actualHeadValues);
    }

    @ParameterizedTest
    @MethodSource("Btree.ValuesProvider#findNonExistingIntegerElements")
    void delete_DeletingIntegerElements_ElementDoesNotExists(Integer[] values, int range, int toDelete) {
        Tree<Integer> tree = new Btree<Integer>(range);

        tree.insert(values);
        tree.delete(toDelete); 
        Integer result = tree.find(toDelete); 

        assertNull(result);
    }
}
