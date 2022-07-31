package timeMeasure.Integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

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
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < quantity - 1; i++) {
            list.add(i);

        }

        Collections.shuffle(list);
        tree.insert(list);
        System.out.print("Adding element " + quantity + " to BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.insert(quantity);
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
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < quantity - 1; i++) {
            list.add(i);

        }

        Collections.shuffle(list);
        tree.insert(list);
        tree.insert(quantity);

        System.out.print("Searching element " + quantity + " elements in BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.search(quantity);
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
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < quantity - 1; i++) {
            list.add(i);

        }

        Collections.shuffle(list);
        tree.insert(list);
        tree.insert(quantity);

        System.out.print("Deleting element " + quantity + " in BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.delete(quantity);
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

    @Test
    public void measure_1000IntegerPrint_BinaryTree() {
        Assume.assumeTrue(operation == Operation.PRINT && dataStructure == DataStructure.BINARY_SEARCH_TREE);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for (int integer : list) {
            tree.insert(integer);
        }

        TimeMeasure.measure(() -> {
            tree.printIterativeBFS();
        });
    }

    @Test
    public void measure_1000IntegerPrint_ArrayList() {
        Assume.assumeTrue(operation == Operation.PRINT && dataStructure == DataStructure.ARRAY_LIST);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }

    @Test
    public void measure_10000IntegerPrint_BinaryTree() {
        Assume.assumeTrue(operation == Operation.PRINT && dataStructure == DataStructure.BINARY_SEARCH_TREE);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for (int integer : list) {
            tree.insert(integer);
        }

        TimeMeasure.measure(() -> {
            tree.printIterativeBFS();
        });
    }

    @Test
    public void measure_10000IntegerPrint_ArrayList() {
        Assume.assumeTrue(operation == Operation.PRINT && dataStructure == DataStructure.ARRAY_LIST);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }

    @Test
    public void measure_1000000IntegerPrint_BinaryTree() {
        Assume.assumeTrue(operation == Operation.PRINT && dataStructure == DataStructure.BINARY_SEARCH_TREE);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for (int integer : list) {
            tree.insert(integer);
        }

        TimeMeasure.measure(() -> {
            tree.printIterativeBFS();
        });
    }

    @Test
    public void measure_1000000IntegerPrint_ArrayList() {
        Assume.assumeTrue(operation == Operation.PRINT && dataStructure == DataStructure.ARRAY_LIST);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }

        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }

    @Test
    public void measure_10000000IntegerPrint_BinaryTree() {
        Assume.assumeTrue(operation == Operation.PRINT && dataStructure == DataStructure.BINARY_SEARCH_TREE);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for (int integer : list) {
            tree.insert(integer);
        }

        TimeMeasure.measure(() -> {
            tree.printIterativeBFS();
        });
    }

    @Test
    public void measure_10000000IntegerPrint_ArrayList() {
        Assume.assumeTrue(operation == Operation.PRINT && dataStructure == DataStructure.ARRAY_LIST);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }

        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }

}