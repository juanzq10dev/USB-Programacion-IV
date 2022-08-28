package Btree;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BtreeTest<T extends Comparable<T>> {
    @ParameterizedTest
    @MethodSource({"Btree.IntegersProvider#insertElementsCheckingSize",
        "Btree.PersonProvider#insertElementsCheckingSize",})
    void insert_InsertIntegerElements_CheckingSize(T[] elements, int range, int expectedSize) {
        Tree<T> tree = new Btree<T>(range); 

        tree.insert(elements);

        int actualSize = tree.size(); 
        assertEquals(expectedSize, actualSize);
    }

    @ParameterizedTest
    @MethodSource({"Btree.IntegersProvider#insertElementsCheckingHeadValues", 
        "Btree.PersonProvider#insertElementsCheckingHeadValues"})
    void insert_InserIntegerElements_CheckingHeads(T[] elements, int range, T[] expectedHeadValues) {
        Tree<T> tree = new Btree<T>(range); 

        tree.insert(elements);

        T[] actualHeadValues = tree.getHeadValues(); 
        assertArrayEquals(expectedHeadValues, actualHeadValues);
    }

    @ParameterizedTest
    @MethodSource({"Btree.IntegersProvider#findExistingElements", 
        "Btree.PersonProvider#findExistingElements"})
    void find_FindExistingIntegerElements_CheckingFindElement(T[] elements, int range, T toFind) {
        Tree<T> tree = new Btree<T>(range); 

        tree.insert(elements);
        T result = tree.find(toFind);
 
        assertEquals(toFind, result);
    }

    @ParameterizedTest
    @MethodSource({"Btree.IntegersProvider#findNonExistingElements", 
        "Btree.PersonProvider#findNonExistingElements"})
    void find_FindNonExistingElements(T[] values, int range, T toFind) {
        Tree<T> tree = new Btree<T>(range); 

        tree.insert(values);

        T result = tree.delete(toFind);
        assertNull(result);
    }

    @ParameterizedTest
    @MethodSource({"Btree.IntegersProvider#deleteValuesCheckHead", 
        "Btree.PersonProvider#deleteValuesCheckHead"})
    void delete_DeletingIntegerElements_CheckingHeadValues(T[] values, int range, T toDelete, T[] expectedHeadValues) {
        Tree<T> tree = new Btree<T>(range);

        tree.insert(values);
        tree.delete(toDelete); 

        T[] actualHeadValues = tree.getHeadValues(); 
        assertArrayEquals(expectedHeadValues, actualHeadValues);
    }

    @ParameterizedTest
    @MethodSource({"Btree.IntegersProvider#deleteNullElements", 
        "Btree.PersonProvider#deleteNullElements"})
    void delete_DeletingNullElements_Null(T[] values, int range) {
        Tree<T> tree = new Btree<T>(range); 

        tree.insert(values);
        
        T result = tree.delete(null); 
        assertNull(result);
    }

    @ParameterizedTest
    @MethodSource({"Btree.IntegersProvider#findNonExistingElements",
        "Btree.PersonProvider#findNonExistingElements"})
    void delete_DeletingIntegerElements_ElementDoesNotExists(T[] values, int range, T toDelete) {
        Tree<T> tree = new Btree<T>(range);

        tree.insert(values);
        tree.delete(toDelete); 
        T result = tree.find(toDelete); 

        assertNull(result);
    }
}
