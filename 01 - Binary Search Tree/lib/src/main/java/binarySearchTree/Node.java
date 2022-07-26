package binarySearchTree;

import java.util.Objects;

public class Node<T> {
    private T data; 
    private Node<T> parentNode; 
    private Node<T> leftNode;
    private Node<T> rightNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        if (leftNode != null) {
            leftNode.setParentNode(this);
        }
        
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        if (rightNode != null) {
            rightNode.setParentNode(this);
        }
        this.rightNode = rightNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;

        boolean isEqual = Objects.equals(data, node.data) && Objects.equals(leftNode, node.leftNode) && Objects.equals(rightNode, node.rightNode);
        if (parentNode != null) {
            isEqual = isEqual && Objects.equals(parentNode.data, node.parentNode.data);
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, parentNode, leftNode, rightNode);
    }
}
