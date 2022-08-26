package Binomial.Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class BinomialHeap<T extends Comparable<T>>  {
    private HashMap<Integer, Node<T>> nodes;
    private Node<T> max;

    public BinomialHeap() {
        nodes = new HashMap<Integer, Node<T>>();
        max = null;
    }

    public BinomialHeap(T[] array) {
        this();
        for (T value : array) {
            insert(value);
        }
    }

    public void insert(T value) {
        if (value != null) {
            Node<T> newNode = new Node<T>(value);
            addToMap(newNode);
            updateIfMax(newNode);
        }
    }

    private void updateIfMax(Node<T> node) {
        if (max == null || node.getValue().compareTo(max.getValue()) > 0) {
            max = node;
        }
    }

    private void addToMap(Node<T> newNode) {
        if (nodes.containsKey(newNode.getDegree())) {
            Node<T> other = nodes.remove(newNode.getDegree());
            union(other, newNode);
        } else {
            nodes.put(newNode.getDegree(), newNode);
        }
    }

    private void union(Node<T> node1, Node<T> node2) {
        boolean node1IsLesser = node1.getValue().compareTo(node2.getValue()) < 0;
        Node<T> lesserNode = (node1IsLesser) ? node1 : node2;
        Node<T> greaterNode = (node1IsLesser) ? node2 : node1;
        greaterNode.merge(lesserNode);
        addToMap(greaterNode);
    }

    public T deleteMax() {
        if (max != null) {
            Node<T> deleted = nodes.remove(max.getDegree());
            Node<T>[] children = deleted.getChildren(); 

            for (Node<T> node : children) {
                addToMap(node);
            }

            findNewMax();
            return deleted.getValue(); 
        }

        return null; 
    }

    private void findNewMax() {
        Set<Integer> keySet = nodes.keySet();
        this.max = null; 
        for (Integer key : keySet) {
            Node<T> node = nodes.get(key); 
            updateIfMax(node);
        }
    }

    public int getNumberOfBinomialTrees() {
        return nodes.keySet().size(); 
    }

    public Integer[] getBinomialTreeRanks() {
        Integer[] keySet = nodes.keySet().toArray(new Integer[nodes.size()]);
        Arrays.sort(keySet);
        return keySet;
    }

    public T getMax() {
        if (max != null) {
            return max.getValue();
        }

        return  null;
    }
}
