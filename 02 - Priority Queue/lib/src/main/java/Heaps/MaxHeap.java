package Heaps;

public class MaxHeap<T extends Comparable<T>> extends BinaryHeap<T> {

    public MaxHeap() {
        super();
    }

    public MaxHeap(T[] array) {
        super(array);
    }

    @Override
    public int compare(T o1, T o2) {
        return o2.compareTo(o1);
    } 
}
