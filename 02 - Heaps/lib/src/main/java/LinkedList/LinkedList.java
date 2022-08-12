package LinkedList;

public interface LinkedList<T> extends Iterable<T> {

    void add(T element); 

    void add(T prev, T element);

    void remove(T value);

    void removeHead();

    void removeTail(Node<T> penultimateNode);
}
