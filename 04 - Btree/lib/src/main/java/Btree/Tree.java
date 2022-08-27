package Btree;

public interface Tree<T> {
    void insert(T value);
    
    T find(T value); 

    T delete(T value);
}
