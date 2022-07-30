package timeMeasure;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import binarySearchTree.BinarySearchTree;

public class TimeMeasureTest {
    @Test
    public void measure_1000IntegerInsert_BinaryTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1000 - 1; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        TimeMeasure.measure(() -> {
            for (int integer : list) {
                tree.insert(integer);
            }
        });
    }

    @Test
    public void measure_1000IntegerInsert_ArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        TimeMeasure.measure(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });
    }

    @Test
    public void measure_10000IntegerInsert_BinaryTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        TimeMeasure.measure(() -> {
            for (int integer : list) {
                tree.insert(integer);
            }
        });
    }

    @Test
    public void measure_10000IntegerInsert_ArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        TimeMeasure.measure(() -> {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
        });
    }

    @Test
    public void measure_1000000IntegerInsert_BinaryTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        TimeMeasure.measure(() -> {
            for (int integer : list) {
                tree.insert(integer);
            }
        });
    }

    @Test
    public void measure_1000000IntegerInsert_ArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        TimeMeasure.measure(() -> {
            for (int i = 0; i < 1000000; i++) {
                list.add(i);
            }
        });
    }

    @Test
    public void measure_10000000IntegerInsert_BinaryTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        TimeMeasure.measure(() -> {
            for (int integer : list) {
                tree.insert(integer);
            }
        });
    }

    @Test
    public void measure_10000000IntegerInsert_ArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        TimeMeasure.measure(() -> {
            for (int i = 0; i < 10000000; i++) {
                list.add(i);
            }
        });
    }

    @Test
    public void measure_100000000000IntegerInsert_BinaryTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        BigInteger bigInteger = new BigInteger("100000000000");
        for (BigInteger i = new BigInteger("0"); i.compareTo(bigInteger) < 0; i = i.add(BigInteger.ONE)) {
            list.add(i.intValue());
        }

        Collections.shuffle(list);
        TimeMeasure.measure(() -> {
            for (int integer : list) {
                tree.insert(integer);
            }
        });
    }

    @Test
    public void measure_100000000000IntegerInsert_ArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        BigInteger bigInteger = new BigInteger("100000000000");

        TimeMeasure.measure(() -> {
            for (BigInteger i = new BigInteger("0"); i.compareTo(bigInteger) < 0; i = i.add(BigInteger.ONE)) {
                list.add(i.intValue());
            }
        });

    }

    @Test
    public void measure_1000IntegerSearch_BinaryTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1000 - 1; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for (int integer : list) {
            tree.insert(integer);
        }
        tree.insert(1000);

        TimeMeasure.measure(() -> {
            tree.search(1000);

        });
    }

    @Test
    public void measure_1000IntegerSearch_ArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        TimeMeasure.measure(() -> {
            list.contains(1000);

        });
    }

    @Test
    public void measure_10000IntegerSearch_BinaryTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000 - 1; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for (int integer : list) {
            tree.insert(integer);
        }
        tree.insert(10000);

        TimeMeasure.measure(() -> {
            tree.search(10000);
        });
    }

    @Test
    public void measure_10000IntegerSearch_ArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        TimeMeasure.measure(() -> {
            list.contains(10000);
            
        });
    }

    @Test
    public void measure_1000000IntegerSearch_BinaryTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1000000 - 1; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for (int integer : list) {
            tree.insert(integer);
        }
        tree.insert(1000000);

        TimeMeasure.measure(() -> {
            tree.search(1000000);
        });
    }

    @Test
    public void measure_1000000IntegerSearch_ArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }

        TimeMeasure.measure(() -> {
            list.contains(1000000);
        });
    }

    @Test
    public void measure_10000000IntegerSearch_BinaryTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000000 - 1; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for (int integer : list) {
            tree.insert(integer);
        }
        tree.insert(10000000);

        TimeMeasure.measure(() -> {
            tree.search(10000000);
        });
    }

    @Test
    public void measure_10000000IntegerSearch_ArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }

        TimeMeasure.measure(() -> {
            list.contains(10000000);
        });
    }

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
            tree.printIterativeBFS();
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
            tree.printIterativeBFS();
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
            tree.printIterativeBFS();
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
            tree.printIterativeBFS();
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
