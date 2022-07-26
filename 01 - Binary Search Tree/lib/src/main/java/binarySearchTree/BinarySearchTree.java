package binarySearchTree;

import java.util.Objects;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> rootNode;

    public BinarySearchTree() {
        this.rootNode = null;
    }

    public BinarySearchTree(Node<T> rootNode) {
        this.rootNode = rootNode;
    }

    public void insert(T data) {
        this.rootNode = insertRecursive(this.rootNode, data);
    }

    private Node<T> insertRecursive(Node<T> rootNode, T data) {
        if (rootNode == null) {
            rootNode = new Node<T>(data);
            return rootNode;
        }

        if (data.compareTo(rootNode.getData()) < 0) {
            rootNode.setLeftNode(insertRecursive(rootNode.getLeftNode(), data));
        } else if(data.compareTo(rootNode.getData()) > 0) {
            rootNode.setRightNode(insertRecursive(rootNode.getRightNode(), data));
        }

        return rootNode;
    }

    public Node<T> search(T data) {
        return searchRecursive(this.rootNode, data);
    }

    private Node<T> searchRecursive(Node<T> node, T data) {
        if (node == null) {
            throw new IllegalArgumentException("Node not found");
        }

        if (node == null || node.getData().compareTo(data) == 0) {
            return node;
        } 

        if (data.compareTo(node.getData()) < 0) {
            return searchRecursive(node.getLeftNode(), data);
        } else {
            return searchRecursive(node.getRightNode(), data);
        }
    }

    public void print() {
        printRecursive(this.rootNode, 0, true);
    }

    private void printRecursive(Node<T> node, int space, boolean right) {
        if (node == null) {
            return;
        }

        space += 10;
    
        printRecursive(node.getRightNode(), space, true);

        if (right == false && node.getParentNode() != null) {
            printSpaces(space - 3);
            System.out.println(" \\");
        } 

        printSpaces(space);
        System.out.println(node.getData());

        if (right == true && node.getParentNode() != null) {
            printSpaces(space - 3);
            System.out.println(" /");
        } 
        
        printRecursive(node.getLeftNode(), space, false);
    }

    private void printSpaces(int spaces) {
        for (int i = 10; i < spaces; i++) {
            System.out.print(" ");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinarySearchTree<?> that = (BinarySearchTree<?>) o;
        return Objects.equals(rootNode, that.rootNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rootNode);
    }

    public Node<T> getRootNode() {
        return rootNode;
    }
}
