package PriorityQueue;

import Heaps.BinaryHeap;
import Heaps.MaxHeap;
import Heaps.MinHeap;

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
}
