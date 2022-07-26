package printTests;

import binarySearchTree.BinarySearchTree;

public class StringBinarySearchTreePrint {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.insert("John");
        tree.insert("Brandon");
        tree.insert("Pedro");
        tree.insert("Carlos");
        tree.insert("Roman");
        tree.insert("Romario");
        tree.insert("Roma");
        tree.insert("Brald");
        
        tree.print();
    }
}
