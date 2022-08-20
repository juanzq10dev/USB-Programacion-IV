package SkipList;

public class Node<T> {
    private T element;
    private Node<T>[] forward;

    public Node(T element, int level) {
        this.element = element;
        this.forward = new Node[level + 1];
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T>[] getForward() {
        return forward;
    }

    public void setForward(Node<T>[] forward) {
        this.forward = forward;
    }

    public void setForward(int level, Node<T> forward) {
        this.forward[level] = forward;
    }

    public Node<T> getForward(int level) {
        return this.forward[level];
    }
}
