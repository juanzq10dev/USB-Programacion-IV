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

    public void insertSplittedNode(T midValue, Node<T> leftSide, Node<T> rightSide) {
        int indexInserted = insert(midValue); 

        for (int i = size - 1; i >= indexInserted; i--) {
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
        return split(0, mid);
    }

    public Node<T> rigthSide() {
        int mid = (0 + rank) / 2;
        return split(mid + 1, rank);
    }

    private Node<T> split(int from, int to) {
        Node<T> side = new Node<T>(rank); 

        for (int i = from; i < to; i++) {
            side.insert(key[i]); 
        }

        side.leaf = this.leaf;

        if (side.leaf) {
            int counter = 0;
            for (int i = from; i <= to; i++) {
                side.setChild(counter, child[i]);
            }
        }

        return side; 
    }

    public void setChild(int childIndex, Node<T> child) {
        this.child[childIndex] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public T midKey() {
        int mid = (0 + rank) / 2;
        return key[mid];
    }

    public int binarySearch(T value) {
        return Arrays.binarySearch(this.key, 0, size,  value); 
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

    public T getKey(int index) {
        return key[index];
    }

    public T[] getKey() {
        return (T[]) Arrays.stream(key).filter(s -> (s != null)).toArray(Comparable[]::new); 
    }
}