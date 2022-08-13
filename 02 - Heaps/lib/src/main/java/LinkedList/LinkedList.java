package LinkedList;

import java.util.Comparator;

public interface LinkedList<T> extends Iterable<T> {

    void add(T element); 

    void add(T prev, T element);

    void add(T element, Comparator<T> comparator);

    void remove(T value);

    void removeHead();

    void removeTail(Node<T> penultimateNode);

    T get(int index);

    int getSize();

    boolean isEmpty();

    Object[] toArray();
}
