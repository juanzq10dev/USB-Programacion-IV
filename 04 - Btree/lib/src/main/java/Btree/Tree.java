package Btree;

public interface Tree<T extends Comparable<T>> {
    void insert(T value);

    void insert(T[] values);
    
    T find(T value); 

    T delete(T value);

    int size();

    boolean contains(T value);
    
    Node<T> getHead(); 

    T[] getHeadValues();
}
