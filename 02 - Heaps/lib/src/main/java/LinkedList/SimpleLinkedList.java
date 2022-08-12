package LinkedList;

import java.util.Comparator;
import java.util.Iterator;

public class SimpleLinkedList<T> implements LinkedList<T> {
    protected int size;
    protected Node<T> head; 
    protected Node<T> tail;

    protected SimpleLinkedList() { };

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        addToTale(newNode);
    }

    @Override
    public void add(T prev, T element) {
        Node<T> lastNode = getNode(prev); 
        Node<T> newNode = new Node<T>(element);
        Node<T> nextNode = lastNode.getNext();

        link(lastNode, newNode);
        link(newNode, nextNode);

        if(lastNode == tail) {
            tail = newNode;
        }

        size++;
    }

    private void addToHead(Node<T> newNode) { 
        link(newNode, head);
        head = newNode;
    }

    private void addToTale(Node<T> newNode) { 
        if(isEmpty()) { 
            head = newNode;
        } else { 
            link(tail, newNode);
        }

        tail = newNode;
        size++;
    }

    @Override
    public void remove(T value) {
        Node<T> lastNode = getLastNode(value);
        Node<T> nodeToRemove;
        Node<T> nextNode;

        try {
            nodeToRemove = lastNode.getNext();
        } catch (NullPointerException e) {
            nodeToRemove = getNode(value);
        }

        nextNode = nodeToRemove.getNext();

        removeNode(lastNode, nodeToRemove, nextNode);
    }

    private boolean removeNode(Node<T> lastNode, Node<T> nodeToRemove, Node<T> nextNode) {
        size--;

        if (nodeToRemove == head) {
            removeHead();
            return true;
        }

        if (nodeToRemove == tail) {
            removeTail(lastNode);
            return true;
        }

        link(lastNode, nextNode);
        return true;
    }

    private Node<T> getLastNode(T value) {
        if (head.contains(value)) {
            return null;
        }

        for (Node<T> node = head; node.getNext() != null; node = node.getNext()) {
            if (node.getNext().contains(value)) {
                return node;
            }
        }

        throw new IllegalArgumentException("The value " + value.toString() + " does not exists");
    }

    @Override
    public void removeHead() {
        head = head.getNext();
    }

    @Override
    public void removeTail(Node<T> penultimateNode) {
        penultimateNode.setNext(null);
        tail = penultimateNode;
    }

    protected Node<T> getNode(int index) {
        if (indexIsValid(index)) {
            Node<T> node = head;
    
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
    
            return node;
        }
        
        throw new IndexOutOfBoundsException("The index " + index + " is out of bounds");
    }

    protected Node<T> getNode(T value) {
        for (Node<T> node = head; node != null; node = node.getNext()) {
            if (node.contains(value)) {
                return node;
            }
        }

        throw new IllegalArgumentException("The value given does not exists");
    }

    protected boolean indexIsValid(int index) {
        return !(index < 0 || index > size);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private void link(Node<T> lastNode, Node<T> nextNode) {
        lastNode.setNext(nextNode);
    }
    
    private void unlink(Node<T> node) {
        node.setNext(null);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    }

    private class MyIterator<LinkedList> implements Iterator<T> {
        int index = 0; 
        Node<T> node = head;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T element = node.getElement(); 
            node = node.getNext();
            index++;
            return element;
        } 
    }
}
