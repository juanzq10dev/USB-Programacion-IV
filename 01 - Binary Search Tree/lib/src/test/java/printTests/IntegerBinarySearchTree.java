package printTests;

import binarySearchTree.BinarySearchTree;

public class IntegerBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);
        tree.insert(-2);
        tree.insert(4);
        tree.insert(-5);
        tree.insert(-3);
        tree.insert(-1);

        tree.print();
    }
}