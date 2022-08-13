package Heaps;

import java.util.Arrays;
import java.util.Comparator;

public abstract class BinaryHeap<T extends Comparable<T>> implements Heap<T>, Comparator<T> {
    protected T[] array;
    protected int size;

    public BinaryHeap() {
        this.array = (T[]) new Comparable[10];
        this.size = 0;
    }

    public BinaryHeap(T[] array) {
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

    public void heapifyDown(int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size - 1 && compare(array[left], array[largest]) < 0) {
            largest = left;
        }

        if (right < size - 1 && compare(array[right], array[largest]) < 0) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
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
    public T removeRoot() {
        if (!isEmpty()) {
            T root = array[0];
            T lastElement = array[size - 1];
            array[0] = lastElement;
            array[size - 1] = null;
            size--;
            heapifyDown(0);
            return root;
        }

        return null;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return array[0];
        }

        return null;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
