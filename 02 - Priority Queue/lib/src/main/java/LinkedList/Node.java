package LinkedList;

public class Node<T> {
    T element; 
    Node<T> next; 

    protected Node(T element) {
        this.element = element;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }
    
    public T getElement() {
        return element;
    }

    public boolean contains(T value) {
        return element.equals(value);
    }
}
