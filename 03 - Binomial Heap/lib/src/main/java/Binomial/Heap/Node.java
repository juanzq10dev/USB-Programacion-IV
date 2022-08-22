package Binomial.Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Node<T> {
    private T value; 
    private int degree;
    private Node<T> [] children;

    public Node(T value) {
        this.value = value;
        this.degree = 0;
        this.children = new Node[1];
    }

    public void merge(Node<T> node) {
        if (node.degree != this.degree) {
            throw new IllegalArgumentException("Cannot merge nodes of different degrees");
        }

        if (this.children.length == this.degree) {
            resizeChildrenArray();
        }

        this.children[this.degree] = node;
        this.degree++;
    }

    public void resizeChildrenArray() {
        this.children = Arrays.copyOf(this.children, this.children.length * 2);
    }

    public Node[] getChildren() {
        List<Node<T>> childrenList = Arrays.asList(this.children);
        Collections.reverse(childrenList);
        Node[] childrenArray = Arrays.stream(childrenList.toArray()).filter(x -> x != null).toArray(Node[]::new);
        return childrenArray;
    }

    public int getDegree() {
        return degree;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return this.value.equals(((Node<T>) obj).value);
    }
 }
