package Heaps;

public interface Heap<T extends Comparable<T>> {
    void add(T value); 

    T search(T value); 

    void remove(T value);

    void print(); 

    void sort();

    void heapifyUp(int index);

    void heapifyDown(int length, int i);

    
}
