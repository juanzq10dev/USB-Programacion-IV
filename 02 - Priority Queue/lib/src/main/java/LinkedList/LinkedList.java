package LinkedList;

import java.util.Comparator;

public interface LinkedList<T> extends Iterable<T> {

    void add(T element); 

    void add(T prev, T element);

    void add(T element, Comparator<T> comparator);

    void remove(T value);

    T removeHead();

    void removeTail(Node<T> penultimateNode);

    T peek();

    T get(int index);

    int getSize();

    boolean isEmpty();

    Object[] toArray();
}
