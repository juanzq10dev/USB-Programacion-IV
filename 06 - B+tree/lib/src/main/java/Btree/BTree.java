package Btree;

public interface BTree<T extends Comparable<T>>  {
    void insert(T node);

    void insertAll(T[] nodes); 

    boolean search(T node); 

    boolean searchAll(T[] nodes);

    T remove(T node); 

    boolean removeAll(T[] nodes);

    T[] getHeadValues();

    int size();
}
