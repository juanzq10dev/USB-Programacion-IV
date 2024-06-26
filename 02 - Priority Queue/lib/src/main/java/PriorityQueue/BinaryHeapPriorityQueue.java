package PriorityQueue;

import Heaps.BinaryHeap;
import Heaps.MaxHeap;
import Heaps.MinHeap;

import java.util.Iterator;

public class BinaryHeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T>{
    private BinaryHeap heap;

    public BinaryHeapPriorityQueue(boolean isMinHeap) {
        this.heap = isMinHeap ? new MinHeap<T>() : new MaxHeap<T>();
    }
    @Override
    public void enqueue(T value) {
        this.heap.add(value);
    }

    @Override
    public T dequeue() {
        return (T) this.heap.removeRoot();
    }

    @Override
    public T peek() {
        return (T) this.heap.peek();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    }

    private class MyIterator<LinkedList> implements Iterator<T> {
        private T[] array;
        private int index;

        public MyIterator() {
            heap.sort();
            array = (T[]) heap.getArray();
            index = 0;
        }
        @Override
        public boolean hasNext() {
            return index < heap.size();
        }

        @Override
        public T next() {
            return array[index++];
        }
    }
}
