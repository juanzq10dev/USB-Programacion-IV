package timeMeasure.Integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import binarySearchTree.BinarySearchTree;
import timeMeasure.TimeMeasure;

@RunWith(Parameterized.class)
public class TimeMeasureTest {
    enum Operation {
        ADD, PRINT, SEARCH, DELETE
    }

    enum DataStructure {
        BINARY_SEARCH_TREE, ARRAY_LIST
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { Operation.ADD, DataStructure.BINARY_SEARCH_TREE, 1000 },
                { Operation.ADD, DataStructure.ARRAY_LIST, 1000 },
                { Operation.ADD, DataStructure.BINARY_SEARCH_TREE, 10000 },
                { Operation.ADD, DataStructure.ARRAY_LIST, 10000 },
                { Operation.ADD, DataStructure.BINARY_SEARCH_TREE, 1000000 },
                { Operation.ADD, DataStructure.ARRAY_LIST, 1000000 },
                { Operation.ADD, DataStructure.BINARY_SEARCH_TREE, 10000000 },
                { Operation.ADD, DataStructure.ARRAY_LIST, 10000000 },
                { Operation.SEARCH, DataStructure.BINARY_SEARCH_TREE, 1000 },
                { Operation.SEARCH, DataStructure.ARRAY_LIST, 1000 },
                { Operation.SEARCH, DataStructure.BINARY_SEARCH_TREE, 10000 },
                { Operation.SEARCH, DataStructure.ARRAY_LIST, 10000 },
                { Operation.SEARCH, DataStructure.BINARY_SEARCH_TREE, 1000000 },
                { Operation.SEARCH, DataStructure.ARRAY_LIST, 1000000 },
                { Operation.SEARCH, DataStructure.BINARY_SEARCH_TREE, 10000000 },
                { Operation.SEARCH, DataStructure.ARRAY_LIST, 10000000 },
                { Operation.DELETE, DataStructure.BINARY_SEARCH_TREE, 1000 },
                { Operation.DELETE, DataStructure.ARRAY_LIST, 1000 },
                { Operation.DELETE, DataStructure.BINARY_SEARCH_TREE, 10000 },
                { Operation.DELETE, DataStructure.ARRAY_LIST, 10000 },
                { Operation.DELETE, DataStructure.BINARY_SEARCH_TREE, 1000000 },
                { Operation.DELETE, DataStructure.ARRAY_LIST, 1000000 },
                { Operation.DELETE, DataStructure.BINARY_SEARCH_TREE, 10000000 },
                { Operation.DELETE, DataStructure.ARRAY_LIST, 10000000 },
        });
    }

    private Operation operation;
    private DataStructure dataStructure;
    private int quantity;

    public TimeMeasureTest(Operation operation, DataStructure dataStructure, int quantity) {
        this.operation = operation;
        this.dataStructure = dataStructure;
        this.quantity = quantity;
    }

    @Test
    public void measure_IntegerInsert_BinaryTree() {
        Assume.assumeTrue(operation == Operation.ADD && dataStructure == DataStructure.BINARY_SEARCH_TREE);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        int max = quantity * 10;
        int min = 0; 
        tree.insert(max / 2);
        while (tree.getTotalElements() < quantity / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.insert(value);
        }

        while (tree.getTotalElements() < quantity - 1) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.insert(value);
        }

        System.out.print("Adding element " + quantity + " to BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.insert(max + 1);
        });
    }

    @Test
    public void measure_IntegerInsert_ArrayList() {
        Assume.assumeTrue(operation == Operation.ADD && dataStructure == DataStructure.ARRAY_LIST);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < quantity - 1; i++) {
            list.add(i);
        }

        System.out.print("Adding element " + quantity + " to ArrayList: ");
        TimeMeasure.measure(() -> {
            list.add(quantity);
        });
    }

    @Test
    public void measure_IntegerSearch_BinaryTree() {
        Assume.assumeTrue(operation == Operation.SEARCH && dataStructure == DataStructure.BINARY_SEARCH_TREE);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        int max = quantity * 10;
        int min = 0; 
        tree.insert(max / 2);
        while (tree.getTotalElements() < quantity / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.insert(value);
        }

        while (tree.getTotalElements() < quantity - 1) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.insert(value);
        }

        tree.insert(max + 1);

        System.out.print("Searching element " + quantity + " elements in BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.search(max + 1);
        });
    }

    @Test
    public void measure_IntegerSearch_ArrayList() {
        Assume.assumeTrue(operation == Operation.SEARCH && dataStructure == DataStructure.ARRAY_LIST);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < quantity; i++) {
            list.add(i);
        }

        System.out.print("Searching element " + quantity + " in ArrayList: ");
        TimeMeasure.measure(() -> {
            list.contains(quantity);
        });
    }

    @Test
    public void measure_IntegerDelete_BinarySearch() {
        Assume.assumeTrue(operation == Operation.DELETE && dataStructure == DataStructure.BINARY_SEARCH_TREE);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        int max = quantity * 10;
        int min = 0; 
        tree.insert(max / 2);
        while (tree.getTotalElements() < quantity / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.insert(value);
        }

        while (tree.getTotalElements() < quantity - 1) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.insert(value);
        }

        tree.insert(max + 1);

        System.out.print("Deleting element " + quantity + " in BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.delete(max + 1);
        });
    }

    @Test
    public void measure_IntegerDelete_ArrayList() {
        Assume.assumeTrue(operation == Operation.DELETE && dataStructure == DataStructure.ARRAY_LIST);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < quantity; i++) {
            list.add(i);
        }

        System.out.print("Deleting element " + quantity + "  in ArrayList: ");
        TimeMeasure.measure(() -> {
            list.remove((Object) quantity);
        });
    }
}