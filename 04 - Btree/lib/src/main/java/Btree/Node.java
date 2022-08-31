package Btree;

import java.util.Arrays;

public class Node<T extends Comparable<T>> {
    private int size; 
    private T[] key;
    private Node<T>[] child; 
    private boolean leaf; 
    private int rank;
    private Node<T> parent; 

    public Node(int rank) {
        this.size = 0; 
        this.key = (T[]) new Comparable[rank];
        this.child = new Node[rank + 1];
        this.leaf = true;
        this.rank = rank;
        this.parent = null;
    }

    public int insert(T value) {
        if (!contains(value)) {
            key[size] = value;
            int j = size;
    
            while (j > 0 && key[j].compareTo(key[j - 1]) < 0) {
                swap(key, j, j - 1);
                j--;
            }
            size++; 
            return j;
        }

        return -1; 
    }

    public void insert(T midValue, Node<T> leftSide, Node<T> rightSide) {
        int indexInserted = insert(midValue); 
        for (int i = size - 2; i >= indexInserted; i--) {
            child[i + 1] = child[i];
            child[i] = null;  
        }
        for (int i = size - 2; i >= indexInserted; i--) {
            child[i + 1] = child[i];
            child[i] = null;  
        }

        setChild(indexInserted, leftSide);
        setChild(indexInserted + 1, rightSide);
    }

    public Node<T> leftSide() {
        int mid = (0 + rank) / 2;
        Node<T> leftSide = new Node<T>(rank); 

        for (int i = 0; i < mid; i++) {
            leftSide.insert(key[i]); 
        }

        leftSide.leaf = this.leaf;

        if (leftSide.leaf) {
            for (int i = 0; i <= mid; i++) {
                leftSide.setChild(i, child[i]);
            }
        }

        return leftSide; 
    }

    public void setChild(int childIndex, Node<T> child) {
        this.child[childIndex] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node<T> rigthSide() {
        int mid = (0 + rank) / 2;
        Node<T> rigthSide = new Node<T>(rank); 

        for (int i = mid + 1; i < key.length; i++) {
            rigthSide.insert(key[i]); 
        }

        rigthSide.leaf = this.leaf;

        if (rigthSide.leaf) {
            int counter = 0;
            for (int i = mid + 1; i < child.length; i++) {
                rigthSide.setChild(counter, child[i]);
            }
        }
        return rigthSide; 
    }

    public T midKey() {
        int mid = (0 + rank) / 2;
        return key[mid];
    }

    public int getChildIndex(T value) {
        int i = 0; 
        for (i = 0; i < size; i++) {
            if (key[i].compareTo(value) == 0) {
                return -1;
            }

            if (key[i].compareTo(value) > 0) {
                return i; 
            }
        }

        return size; 
    }

    public boolean contains(T value) {
        return Arrays.binarySearch(this.key, 0, size,  value) >= 0;
    }

    public boolean needsSplit() {
        return size == rank; 
    }

    public Node<T> getChild(int index) {
        return child[index];
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Node<T> getParent() {
        return parent;
    }

    public T[] getKey() {
        return (T[]) Arrays.stream(key).filter(s -> (s != null)).toArray(Comparable[]::new); 
    }
}
