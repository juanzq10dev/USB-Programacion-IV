package Btree;

import java.util.Arrays;
import java.util.LinkedList;

public class Node<T extends Comparable<T>> {
    private final int MIN_KEYS;
    private int size;
    private T[] key;
    private LinkedList<Node<T>> child;
    private boolean leaf;
    private int rank;
    private Node<T> parent;
    private int maxChilds;

    public Node(int rank) {
        this.size = 0;
        this.key = (T[]) new Comparable[rank];
        this.maxChilds = rank + 1;
        this.child = new LinkedList<Node<T>>();
        this.leaf = true;
        this.rank = rank;
        this.parent = null;
        this.MIN_KEYS = rank % 2 == 0 ? rank / 2 - 1 : rank / 2;
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

    public void insertAll(T[] keys) {
        for (T key : keys) {
            insert(key);
        }
    }

    public void insertSplittedNode(T midValue, Node<T> leftSide, Node<T> rightSide) {
        int indexInserted = insert(midValue);

        if (indexInserted < this.child.size()) {
            removeChild(indexInserted);
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
        if (isLeaf()) {
            return split(mid, rank);
        } else {
            return split(mid + 1, rank);
        }
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
                if (i < child.size()) {
                    side.setChild(counter, child.get(i));
                    counter++;
                } else {
                    break;
                }
            }
        }

        return side;
    }

    public void setChild(int childIndex, Node<T> child) {
        this.child.add(childIndex, child);
        if (child != null) {
            child.parent = this;
        }
    }

    public T midKey() {
        int mid = (0 + rank) / 2;
        return key[mid];
    }

    public int binarySearch(T value) {
        return Arrays.binarySearch(this.key, 0, size, value);
    }

    public boolean contains(T value) {
        return Arrays.binarySearch(this.key, 0, size, value) >= 0;
    }

    public boolean needsSplit() {
        return size == rank;
    }

    public Node<T> getChild(int index) {
        if (index < child.size()) {
            return child.get(index);
        }
        return null;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public Node<T> inorderSuccessorNode(T value) {
        int index = binarySearch(value);

        if (index >= 0) {
            Node<T> child = this.getChild(index + 1);

            while (child != null && !child.isLeaf()) {
                child = child.getChild(0);
            }

            return child;
        }

        return null;
    }

    public T removeKey(int index) {
        T value = key[index];
        key[index] = null;

        for (int i = index; i < key.length - 1; i++) {
            swap(key, i, i + 1);
        }

        size--;
        return value;
    }

    public T pushFirstKey() {
        return removeKey(0);
    }

    public T removeLast() {
        return removeKey(size - 1);
    }

    public void removeChild(int index) {
        this.child.remove(index);
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setKey(int index, T value) {
        key[index] = value;
    }
    public T getKey(int index) {
        return key[index];
    }

    public T replaceKey(int index, T value) {
        if (index < size) {
            T deleted = key[index];
            key[index] = value;
            Arrays.sort(key, 0, size);
            return deleted;
        }

        throw new IndexOutOfBoundsException("Index " + index + " for size " + size);
    }

    public Node<T> getLeftBrother() {
        if (this.parent.child.indexOf(this) > 0) {
            return parent.getChild(this.parent.child.indexOf(this) - 1);
        }
        return null;
    }

    public Node<T> getRightBrother() {
        if (this.parent.child.indexOf(this) < parent.size) {
            return parent.getChild(this.parent.child.indexOf(this) + 1);
        }
        return null;
    }

    public boolean hasMoreThanMinKeys() {
        return size > MIN_KEYS;
    }

    public boolean hasExactlyMinKeys() {
        return size == MIN_KEYS;
    }

    public int getSize() {
        return size;
    }

    public LinkedList<Node<T>> getChild() {
        return child;
    }

    public T[] getKey() {
        return (T[]) Arrays.stream(key).filter(s -> (s != null)).toArray(Comparable[]::new);
    }
}
