package binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> rootNode;
    private int oCount;
    private int totalElements;

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
            this.totalElements++;
            return rootNode;
        }

        this.oCount++;
        if (data.compareTo(rootNode.getData()) < 0) {
            rootNode.setLeftNode(insertRecursive(rootNode.getLeftNode(), data));
        } else if (data.compareTo(rootNode.getData()) > 0) {
            rootNode.setRightNode(insertRecursive(rootNode.getRightNode(), data));
        }

        return rootNode;
    }

    public void insert(List<T> data) {
        for (T d : data) {
            insert(d);
        }
    }

    public Node<T> search(T data) {
        return searchRecursive(this.rootNode, data);
    }

    private Node<T> searchRecursive(Node<T> node, T data) {
        if (node == null) {
            throw new IllegalArgumentException("Node not found");
        }

        if (node.getData().compareTo(data) == 0) {
            return node;
        }

        this.oCount++;
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

        this.oCount++;
        space += 10;
        printRecursive(node.getRightNode(), space, true);

        if (right == false && node.getParentNode() != null) {
            printSpaces(space - 3);
            System.out.println(" \\");
        }

        System.out.println("");
        printSpaces(space);
        System.out.println(node.getData());

        if (right == true && node.getParentNode() != null) {
            printSpaces(space - 3);
            System.out.println(" /");
        }

        printRecursive(node.getLeftNode(), space, false);
    }

    public void printIterativeBFS() {
        if (this.rootNode == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(this.rootNode);

        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.remove();
            System.out.print(currentNode.getData() + " ");

            if (currentNode.getLeftNode() != null) {
                queue.add(currentNode.getLeftNode());
            }

            if (currentNode.getRightNode() != null) {
                queue.add(currentNode.getRightNode());
            }
        }
        System.out.println();
    }

    private void printSpaces(int spaces) {
        for (int i = 10; i < spaces; i++) {
            System.out.print(" ");
        }
    }

    public void delete(T data) {
        this.rootNode = deleteRecursive(this.rootNode, data);
    }

    private Node<T> deleteRecursive(Node<T> root, T data) {
        if (root == null) {
            throw new IllegalArgumentException("Node not found");
        }

        this.oCount++;
        if (data.compareTo(root.getData()) < 0) {
            root.setLeftNode(deleteRecursive(root.getLeftNode(), data));
        } else if (data.compareTo(root.getData()) > 0) {
            root.setRightNode(deleteRecursive(root.getRightNode(), data));
        } else {
            if (root.getLeftNode() == null) {
                this.totalElements--;
                return root.getRightNode();
            } else if (root.getRightNode() == null) {
                this.totalElements--;
                return root.getLeftNode();
            }

            root.setData(getMin(root.getRightNode()));
            root.setRightNode(deleteRecursive(root.getRightNode(), root.getData()));
        }
        return root;
    }

    private T getMin(Node<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("Node not found");
        }

        while (node.getLeftNode() != null) {
            node = node.getLeftNode();
        }

        return node.getData();
    }

    public int oCount(Runnable runnable) {
        this.oCount = 0;
        runnable.run();
        return this.oCount;
    }

    public void printOCount(Runnable runnable) {
        System.out.println(
                "The tree has " + this.totalElements + " elements" + ", the Big O is: O(" + oCount(runnable) + ")");
    }

    public int getTotalElements() {
        return totalElements;
    }

    public int getHeight() {
        return getHeightRecursive(this.rootNode);
    }

    public int getHeightFrom(Node<T> node) {
        return getHeightRecursive(node);
    }

    private int getHeightRecursive(Node<T> node) {
        if (node == null) { 
            return 0;
        }

        int heightSubtreeLeft = getHeightRecursive(node.getLeftNode()); 
        int heightSubtreeRight = getHeightRecursive(node.getRightNode()); 
        return 1 + Math.max(heightSubtreeLeft, heightSubtreeRight); 
    }

    public int countLeafNodes() {
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(this.rootNode);
        int totalLeafNodes = 0;

        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            if (node != null) {
                if (node.isLeafNode()) {
                    totalLeafNodes++;
                }
                queue.add(node.getLeftNode());
                queue.add(node.getRightNode());

            }
        }

        return totalLeafNodes;
    }

    public int countInternalNodes() {
        return getTotalElements() - countLeafNodes();
    }

    public void printBigONotation() {
        System.out.println("The Big O notation for print is O(n) where n is the number of elements in the tree");
        System.out.println("The Big O notation for search is O(h) where h is the height of the tree");
        System.out.println("The Big O notation for insert is O(h) where h is the height of the tree");
        System.out.println("The Big O notation for delete is O(h) where h is the height of the tree");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
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