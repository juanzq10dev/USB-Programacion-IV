package printTests;

import binarySearchTree.BinarySearchTree;

public class StringBinarySearchTreePrint {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.add("John");
        tree.add("Brandon");
        tree.add("Pedro");
        tree.add("Carlos");
        tree.add("Roman");
        tree.add("Romario");
        tree.add("Roma");
        tree.add("Brald");
        
        tree.print();
    }
}
