package timeMeasure.Integer;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

import binarySearchTree.BinarySearchTree;
import timeMeasure.TimeMeasure;

public class PrintTimeMeasure{
    @Test
    public void measure_1000IntegerPrint_BinaryTree() {
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
            tree.print();
        });
    }

    @Test
    public void measure_1000IntegerPrint_ArrayList() {
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
            tree.print();
        });
    }

    @Test
    public void measure_10000IntegerPrint_ArrayList() {
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
            tree.print();
        });
    }

    @Test
    public void measure_1000000IntegerPrint_ArrayList() {
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
            tree.print();
        });
    }

    @Test
    public void measure_10000000IntegerPrint_ArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }

        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }

}
