package Btree;

public class Btree<T extends Comparable<T>> implements Tree<T>{
    private int size; 
    private int range; 

    public Btree(int range) {
        this.range = range;
    }
    
    @Override
    public void insert(T value) {
        // TODO Auto-generated method stub
    }

    @Override
    public T find(T value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T delete(T value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insert(T[] values) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(T value) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Node<T> getHead() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T[] getHeadValues() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
