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

    public Node<T> insertRecursive(Node<T> rootNode, T data) {
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
