package Heaps;

public interface Heap<T extends Comparable<T>> {
    void add(T value);

    T removeRoot();

    T peek();

    void sort();

    void heapifyUp(int index);

    void heapifyDown(int length, int i);

    int size();
}
