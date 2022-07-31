package timeMeasure.String;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

import binarySearchTree.BinarySearchTree;
import timeMeasure.TimeMeasure;


public class PrintTimeMeasure {
     @Test
    public void measure_1000Print_BinaryTree() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            list.add((char) i + "");
        }

        Collections.shuffle(list);
        tree.insert(list);
        System.out.print("Printing element 1000 to BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.printIterativeBFS();
        });
    }

    @Test
    public void measure_1000Print_ArrayList() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            list.add((char) i + "");
        }
        System.out.print("Printing element 1000 to ArrayList: ");
        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }

    @Test
    public void measure_10000Print_BinaryTree() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            list.add((char) i + "");
        }

        Collections.shuffle(list);
        tree.insert(list);
        System.out.print("Printing element 10000 to BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.printIterativeBFS();
        });
    }

    @Test
    public void measure_10000Print_ArrayList() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            list.add((char) i + "");
        }

        System.out.print("Printing element 10000 to ArrayList: ");
        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }

    @Test
    public void measure_1000000Print_BinaryTree() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000000; i++) {
            list.add((char) i + "");
        }

        Collections.shuffle(list);
        tree.insert(list);
        System.out.print("Printing element 1000000 to BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.printIterativeBFS();
        });
    }
    
    @Test
    public void measure_1000000Print_ArrayList() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000000; i++) {
            list.add((char) i + "");
        }

        System.out.print("Printing element 1000000 to ArrayList: ");
        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }

    @Test
    public void measure_10000000Print_BinaryTree() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000000; i++) {
            list.add((char) i + "");
        }

        Collections.shuffle(list);
        tree.insert(list);
        System.out.print("Printing element 10000000 to BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.printIterativeBFS();
        });
    }

    @Test
    public void measure_10000000Print_ArrayList() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000000; i++) {
            list.add((char) i + "");
        }

        System.out.print("Printing element 10000000 to ArrayList: ");
        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }
}
