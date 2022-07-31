package timeMeasure.Person;

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
import person.Person;
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
    public void measure_PersonInsert_BinaryTree() {
        Assume.assumeTrue(operation == Operation.ADD && dataStructure == DataStructure.BINARY_SEARCH_TREE);
        BinarySearchTree<Person> tree = new BinarySearchTree<>();
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < quantity - 1; i++) {
            list.add(new Person("Juan", "2010-06-02", i + ""));

        }

        Collections.shuffle(list);
        tree.insert(list);
        System.out.print("Adding element " + quantity + " to BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.insert(new Person("Juan", "2010-06-02", quantity + ""));
        });
    }

    @Test
    public void measure_PersonInsert_ArrayList() {
        Assume.assumeTrue(operation == Operation.ADD && dataStructure == DataStructure.ARRAY_LIST);
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < quantity - 1; i++) {
            list.add(new Person("Juan", "2010-06-02", i + ""));

        }

        System.out.print("Adding element " + quantity + " to ArrayList: ");
        TimeMeasure.measure(() -> {
            list.add(new Person("Juan", "2010-06-02", quantity + ""));
        });
    }

    @Test
    public void measure_PersonSearch_BinaryTree() {
        Assume.assumeTrue(operation == Operation.SEARCH && dataStructure == DataStructure.BINARY_SEARCH_TREE);
        BinarySearchTree<Person> tree = new BinarySearchTree<>();
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < quantity - 1; i++) {
            list.add(new Person("Juan", "2010-06-02", i + ""));

        }

        Collections.shuffle(list);
        tree.insert(list);
        tree.insert(new Person("Juan", "2010-06-02", quantity + ""));
        System.out.print("Searching element " + quantity + " in BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.search(new Person("Juan", "2010-06-02", quantity + ""));
        });
    }

    @Test
    public void measure_PersonSearch_ArrayList() {
        Assume.assumeTrue(operation == Operation.SEARCH && dataStructure == DataStructure.ARRAY_LIST);
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < quantity; i++) {
            list.add(new Person("Juan", "2010-06-02", i + ""));

        }

        System.out.print("Searching element " + quantity + " in ArrayList: ");
        TimeMeasure.measure(() -> {
            list.contains(new Person("Juan", "2010-06-02", quantity + ""));
        });
    }

    @Test
    public void measure_PersonDelete_BinaryTree() {
        Assume.assumeTrue(operation == Operation.DELETE && dataStructure == DataStructure.BINARY_SEARCH_TREE);
        BinarySearchTree<Person> tree = new BinarySearchTree<>();
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < quantity - 1; i++) {
            list.add(new Person("Juan", "2010-06-02", i + ""));

        }

        Collections.shuffle(list);
        tree.insert(list);
        tree.insert(new Person("Juan", "2010-06-02", quantity + ""));
        System.out.print("Deleting element " + quantity + " in BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.delete(new Person("Juan", "2010-06-02", quantity + ""));
        });
    }

    @Test
    public void measure_PersonDelete_ArrayList() {
        Assume.assumeTrue(operation == Operation.DELETE && dataStructure == DataStructure.ARRAY_LIST);
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < quantity; i++) {
            list.add(new Person("Juan", "2010-06-02", i + ""));

        }

        list.add(new Person("Juan", "2010-06-02", quantity + ""));
        System.out.print("Deleting element " + quantity + " in ArrayList: ");
        TimeMeasure.measure(() -> {
            list.remove(new Person("Juan", "2010-06-02", quantity + ""));
        });
    }

    
}