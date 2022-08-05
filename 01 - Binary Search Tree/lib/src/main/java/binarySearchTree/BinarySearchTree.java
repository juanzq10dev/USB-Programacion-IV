package binarySearchTree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> rootNode;
    private int totalElements;

    public BinarySearchTree() {
        this.rootNode = null;
    }

    public BinarySearchTree(Node<T> rootNode) {
        this.rootNode = rootNode;
    }

    public void add(T data) {
        this.rootNode = addRecursive(this.rootNode, data);
    }

    private Node<T> addRecursive(Node<T> rootNode, T data) {
        if (rootNode == null) {
            rootNode = new Node<T>(data);
            this.totalElements++;
            return rootNode;
        }

        if (data.compareTo(rootNode.getData()) < 0) {
            rootNode.setLeftNode(addRecursive(rootNode.getLeftNode(), data));
        } else if (data.compareTo(rootNode.getData()) > 0) {
            rootNode.setRightNode(addRecursive(rootNode.getRightNode(), data));
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

        if (node.getData().compareTo(data) == 0) {
            return node;
        }

        if (data.compareTo(node.getData()) < 0) {
            return searchRecursive(node.getLeftNode(), data);
        } else {
            return searchRecursive(node.getRightNode(), data);
        }
    }

    public void print() {
        System.out.println(rootNode.toString());
    }

    public void remove(T data) {
        this.rootNode = removeRecursive(this.rootNode, data);
    }

    private Node<T> removeRecursive(Node<T> root, T data) {
        if (root == null) {
            throw new IllegalArgumentException("Node not found");
        }

        if (data.compareTo(root.getData()) < 0) {
            root.setLeftNode(removeRecursive(root.getLeftNode(), data));
        } else if (data.compareTo(root.getData()) > 0) {
            root.setRightNode(removeRecursive(root.getRightNode(), data));
        } else {
            if (root.getLeftNode() == null) {
                this.totalElements--;
                return root.getRightNode();
            } else if (root.getRightNode() == null) {
                this.totalElements--;
                return root.getLeftNode();
            }

            root.setData(getMin(root.getRightNode()));
            root.setRightNode(removeRecursive(root.getRightNode(), root.getData()));
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