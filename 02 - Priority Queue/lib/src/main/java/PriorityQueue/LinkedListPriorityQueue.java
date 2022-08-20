package PriorityQueue;

import SkipList.SkipList;

import java.util.Comparator;
import java.util.Iterator;

public class LinkedListPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private SkipList<T> list;

    public LinkedListPriorityQueue() {
        this.list = new SkipList<T>();
    }

    public LinkedListPriorityQueue(Comparator<T> comparator) {
        this.list = new SkipList<T>(comparator);
    }

    @Override
    public void enqueue(T value) {
        list.add(value);
    }

    @Override
    public T dequeue() {
       return list.removeHead();
    }

    @Override
    public T peek() {
        return list.peek();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
