package timeMeasure.Integer;

import java.util.ArrayList;
import org.junit.Test;

import binarySearchTree.BinarySearchTree;
import timeMeasure.TimeMeasure;

public class PrintTimeMeasure{
    @Test
    public void measure_1000IntegerPrint_BinaryTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int max = 1000 * 10;
        int min = 0; 
        tree.add(max / 2);
        while (tree.getTotalElements() < 1000 / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.add(value);
        }

        while (tree.getTotalElements() < 1000) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.add(value);
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
        int max = 10000 * 10;
        int min = 0; 
        tree.add(max / 2);
        while (tree.getTotalElements() < 10000 / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.add(value);
        }

        while (tree.getTotalElements() < 10000) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.add(value);
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

        int max = 1000000 * 10;
        int min = 0; 
        tree.add(max / 2);
        while (tree.getTotalElements() < 1000000 / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.add(value);
        }

        while (tree.getTotalElements() < 1000000) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.add(value);
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

        int max = 10000000 * 10;
        int min = 0; 
        tree.add(max / 2);
        while (tree.getTotalElements() < 10000000 / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.add(value);
        }

        while (tree.getTotalElements() < 10000000) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.add(value);
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
