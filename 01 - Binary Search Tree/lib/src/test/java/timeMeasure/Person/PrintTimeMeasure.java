package timeMeasure.Person;

import java.util.ArrayList;
import org.junit.Test;

import binarySearchTree.BinarySearchTree;
import person.Person;
import timeMeasure.TimeMeasure;

public class PrintTimeMeasure {
    @Test
    public void measure_1000Print_BinaryTree() {
        BinarySearchTree<Person> tree = new BinarySearchTree<>();

        int max = 1000 * 10;
        int min = 0; 
        tree.add(new Person("Juan", "2010-06-02", max / 2 + ""));
        while (tree.getTotalElements() < 1000 / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.add(new Person("Juan", "2010-06-02", value + ""));
        }

        while (tree.getTotalElements() < 1000) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.add(new Person("Juan", "2010-06-02", value + ""));
        }

        System.out.print("Printing 1000 elements in BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.print();
        });
    }

    @Test
    public void measure_1000Print_ArrayList() {
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Person("Juan", "2010-06-02", i + ""));

        }

        System.out.print("Printing 1000 elements in ArrayList: ");
        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }

    @Test
    public void measure_10000Print_BinaryTree() {
        BinarySearchTree<Person> tree = new BinarySearchTree<>();
        
        int max = 10000 * 10;
        int min = 0; 
        tree.add(new Person("Juan", "2010-06-02", max / 2 + ""));
        while (tree.getTotalElements() < 10000 / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.add(new Person("Juan", "2010-06-02", value + ""));
        }

        while (tree.getTotalElements() < 10000) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.add(new Person("Juan", "2010-06-02", value + ""));
        }

        System.out.print("Printing 10000 elements in BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.print();
        });
    }

    @Test
    public void measure_10000Print_ArrayList() {
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Person("Juan", "2010-06-02", i + ""));

        }

        System.out.print("Printing 10000 elements in ArrayList: ");
        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }

    @Test
    public void measure_1000000Print_BinaryTree() {
        BinarySearchTree<Person> tree = new BinarySearchTree<>();

        int max = 1000000 * 10;
        int min = 0; 
        tree.add(new Person("Juan", "2010-06-02", max / 2 + ""));
        while (tree.getTotalElements() < 1000000 / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.add(new Person("Juan", "2010-06-02", value + ""));
        }

        while (tree.getTotalElements() < 1000000) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.add(new Person("Juan", "2010-06-02", value + ""));
        }

        System.out.print("Printing 1000000 elements in BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.print();
        });
    }

    @Test
    public void measure_1000000Print_ArrayList() {
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 1000000; i++) {
            list.add(new Person("Juan", "2010-06-02", i + ""));
        }

        System.out.print("Printing 1000000 elements in ArrayList: ");
        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }

    @Test
    public void measure_10000000Print_BinaryTree() {
        BinarySearchTree<Person> tree = new BinarySearchTree<>();

        int max = 10000000 * 10;
        int min = 0; 
        tree.add(new Person("Juan", "2010-06-02", max / 2 + ""));
        while (tree.getTotalElements() < 10000000 / 2) {
            int value = (int) Math.floor(Math.random() * (max / 2 - min + 1) + min);
            tree.add(new Person("Juan", "2010-06-02", value + ""));
        }

        while (tree.getTotalElements() < 10000000) {
            int value = (int) Math.floor(Math.random() * (max - max / 2 + 1) + max / 2);
            tree.add(new Person("Juan", "2010-06-02", value + ""));
        }

        System.out.print("Printing 10000000 elements in BinarySearchTree: ");
        TimeMeasure.measure(() -> {
            tree.print();
        });
    }

    @Test
    public void measure_10000000Print_ArrayList() {
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 10000000; i++) {
            list.add(new Person("Juan", "2010-06-02", i + ""));
        }

        System.out.print("Printing 10000000 elements in ArrayList: ");
        TimeMeasure.measure(() -> {
            System.out.println(list.toString());
        });
    }
}
