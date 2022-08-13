package PriorityQueue;

import LinkedList.Node;
import LinkedList.SimpleLinkedList;

import java.util.Comparator;

public class LinkedListPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private SimpleLinkedList<T> list;
    private Comparator<T> comparator;

    public LinkedListPriorityQueue() {
        this.list = new SimpleLinkedList<T>();
        this.comparator = Comparator.naturalOrder();
    }

    public LinkedListPriorityQueue(Comparator<T> comparator) {
        this();
        this.comparator = comparator;
    }

    @Override
    public void enqueue(T value) {
        list.add(value, this.comparator);
    }

    @Override
    public T dequeue() {
        return list.removeHead();
    }

    @Override
    public T peek() {
        return list.peek();
    }
    
}
