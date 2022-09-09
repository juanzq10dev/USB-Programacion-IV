package Btree;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BPlusTreeTest<T> {
    @ParameterizedTest
    @MethodSource({"IntegerProvider#addElementsCheckHead"})
    void add_addElements_CheckHeads(T[] values, int range, T[] expectedHeadValues) {
        BTree<T> tree = new BPlusTree<>(range); 

        tree.insertAll(values);

        T[] actualHeadValues = tree.getHeadValues();
        assertArrayEquals(expectedHeadValues, actualHeadValues);
    }

    @ParameterizedTest
    @MethodSource({"IntegerProvider#addElementsCheckSize"})
    void add_addElements_CheckSize(T[] values, int range, int expectedSize) {
        BTree<T> tree = new BPlusTree<>(range); 

        tree.insertAll(values);

        int actualSize = tree.size(); 
        assertEquals(expectedSize, actualSize);
    }
    
    @ParameterizedTest
    @MethodSource({"IntegerProvider#searchNonExistingElements"})
    void search_searchAllExistingElements_True(T[] values, int range) {
        BTree<T> tree = new BPlusTree<>(range); 

        tree.insertAll(values);
        
        boolean allFound = tree.searchAll(values); 
        assertTrue(allFound);
    }

    @ParameterizedTest
    @MethodSource({"IntegerProvider#searchNonExistingElements"})
    void search_searchNonExistingElements_False(T[] values, int range, T toSearch) {
        BTree<T> tree = new BPlusTree<>(range); 

        tree.insertAll(values);

        boolean found = tree.search(toSearch); 
        assertFalse(found);
    }
    
    @ParameterizedTest
    @MethodSource({"IntegerProvider#removeExistingElementsCheckSize"})
    void remove_removeExistingElement_CheckSize(T[] values, int range, T toRemove) {
        BTree<T> tree = new BPlusTree<>(range); 

        tree.insertAll(values);
        tree.remove(toRemove); 

        int expectedSize = values.length - 1; 
        int actualSize = tree.size();
        assertEquals(expectedSize, actualSize);
    }

    @ParameterizedTest
    @MethodSource({"IntegerProvider#removeExistingElementsSearchAllElements"})
    void remove_removeExistingElementsSearchAll(T[] values, int range, T toRemove, T[] toSearch) {
        BTree<T> tree = new BPlusTree<>(range);

        tree.insertAll(values);
        tree.remove(toRemove); 
     
        boolean allFound = tree.searchAll(toSearch);
        assertTrue(allFound);
    }

    @ParameterizedTest
    @MethodSource({"IntegerProvider#removeExistingElementsCheckHeadValues"})
    void remove_removeExistingElement_CheckHeadValues(T[] values, int range, T toRemove, T[] expectedHeadValues) {
        BTree<T> tree = new BPlusTree<>(range);

        tree.insertAll(values);
        tree.remove(toRemove);

        T[] actualHeadValues = tree.getHeadValues(); 
        assertArrayEquals(expectedHeadValues, actualHeadValues);   
    }

    @ParameterizedTest
    @MethodSource({""})
    void remove_removeManyElements_CheckHeadValues(T[] values, int range, T[] toRemove, T[] expectedHeadValues) {
        BTree<T> tree = new BPlusTree<>(range); 

        tree.insertAll(values);
        tree.removeAll(toRemove);

        T[] actualHeadValues = tree.getHeadValues(); 
        assertArrayEquals(expectedHeadValues, actualHeadValues);
    }

    @ParameterizedTest
    @MethodSource({"IntegerProvider#removeExistingElementsSearchAllElements"})
    void remove_removeNonExistingElements_Size(T[] values, int range, T toRemove) {
        BTree<T> tree = new BPlusTree<>(range); 

        tree.insertAll(values);

        T removed = tree.remove(toRemove); 
        assertNull(removed);
    }
}
