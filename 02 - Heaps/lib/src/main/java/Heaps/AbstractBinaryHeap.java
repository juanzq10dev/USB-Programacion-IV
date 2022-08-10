package Heaps;

import java.util.Arrays;
import java.util.Comparator;

public abstract class AbstractBinaryHeap<T extends Comparable<T>> implements Heap<T>, Comparator<T> {
    protected T[] array;
    protected int size;

    public AbstractBinaryHeap() {
        this.array = (T[]) new Comparable[10];
        this.size = 0;
    }

    public AbstractBinaryHeap(T[] array) {
        this.array = array;
        this.size = array.length;
        sort();
    }

    public void swap(int index1, int index2) {
        T temp = this.array[index1];
        this.array[index1] = this.array[index2];
        this.array[index2] = temp;
    }    

    public void resize() {
        this.array = Arrays.copyOf(array, array.length * 2);
    }

    public T[] getArray() {
        return (T[]) array;
    }

    @Override
    public void heapifyUp(int index) {
        if (index == 0) {
            return;
        }
        
        int parentIndex = (index - 1) / 2;
        if (compare(array[index], array[parentIndex]) < 0) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    @Override
    public void sort() {
        int length = size;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapifyDown(length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            swap(0, i);
            heapifyDown(i, 0);
        }
    }

    @Override
    public void heapifyDown(int length, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < length && compare(array[left], array[largest]) > 0) {
            largest = left;
        }

        if (right < length && compare(array[right], array[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapifyDown(length, largest);
        }
    }

    @Override
    public void add(T value) {
        if (size == array.length) {
            resize();
        }
        size++;
        array[size - 1] = value;
        heapifyUp(size - 1);
    }

    @Override
    public T search(T value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void remove(T value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        
    }
}
