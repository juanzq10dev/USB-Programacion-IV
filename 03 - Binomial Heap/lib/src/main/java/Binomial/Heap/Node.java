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
        this.children = new Node[0];
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
        this.children = Arrays.copyOf(this.children, this.children.length + 1);
    }

    public Node[] getChildren() {
        List<Node<T>> childrenList = Arrays.asList(this.children);
        Collections.reverse(childrenList);
        return childrenList.toArray(new Node[childrenList.size()]);
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
