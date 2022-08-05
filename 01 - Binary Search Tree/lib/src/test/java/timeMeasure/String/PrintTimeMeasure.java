package timeMeasure.String;

import java.util.ArrayList;
import org.junit.Test;

import binarySearchTree.BinarySearchTree;
import timeMeasure.TimeMeasure;


public class PrintTimeMeasure {
     @Test
    public void measure_1000Print_BinaryTree() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();

        int max = 1000 * 10;
        int min = 0; 
        tree.add((char) max / 2 + "" );
        while (tree.getTotalElements() < 1000 / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.add((char) value + "");
        }

        while (tree.getTotalElements() < 1000) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.add((char) value + "");
        }

        System.out.print("Printing element 1000 to BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.print();
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

        int max = 1000 * 10;
        int min = 0; 
        tree.add((char) max / 2 + "" );
        while (tree.getTotalElements() < 1000 / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.add((char) value + "");
        }

        while (tree.getTotalElements() < 1000) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.add((char) value + "");
        }

        System.out.print("Printing element 10000 to BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.print();
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

        int max = 1000 * 10;
        int min = 0; 
        tree.add((char) max / 2 + "" );
        while (tree.getTotalElements() < 1000 / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.add((char) value + "");
        }

        while (tree.getTotalElements() < 1000) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.add((char) value + "");
        }

        System.out.print("Printing element 1000000 to BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.print();
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

        int max = 1000 * 10;
        int min = 0; 
        tree.add((char) max / 2 + "" );
        while (tree.getTotalElements() < 1000 / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.add((char) value + "");
        }

        while (tree.getTotalElements() < 1000) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.add((char) value + "");
        }

        System.out.print("Printing element 10000000 to BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.print();
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
