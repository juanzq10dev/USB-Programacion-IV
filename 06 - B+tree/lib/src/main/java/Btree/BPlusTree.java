package Btree;

import com.google.common.base.Objects;

public class BPlusTree<T> implements BTree<T> {
    private int range; 

    public BPlusTree(int range) {
        this.range = range;
    }

    @Override
    public void insert(T node) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insertAll(T[] nodes) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean search(T node) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean searchAll(T[] nodes) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T remove(T node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T[] getHeadValues() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean removeAll(T[] nodes) {
        // TODO Auto-generated method stub
        return false;
    }
}
