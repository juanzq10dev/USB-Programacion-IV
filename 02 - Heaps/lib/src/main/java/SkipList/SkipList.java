package SkipList;

import java.util.Comparator;
import java.util.Iterator;

public class SkipList<T extends Comparable<T>> implements Iterable<T> {
    private final int MAX_LEVEL = 5;
    private float p;
    private int level;
    private Node<T> head;

    private Comparator<T> comparator;

    public SkipList() {
        this.p = 0.5f;
        this.level = 0;
        this.head = new Node<T>(null, MAX_LEVEL);
        comparator = Comparator.naturalOrder();
    }

    public SkipList(Comparator<T> comparator) {
        this();
        this.comparator = comparator;
    }

    public int randomLevel() {
        float r = (float) Math.random();
        int newLevel = 0;
        while (r < p && newLevel < MAX_LEVEL) {
            newLevel++;
            r = (float) Math.random();
        }
        return newLevel;
    }

    public Node<T> createNode(T element, int level) {
        return new Node<T>(element, level);
    }

    public void add(T element) {
        Node<T> current = head;
        Node<T>[] update = new Node[MAX_LEVEL + 1];

        for (int i = level; i >= 0; i--) {
            while (current.getForward(i) != null && comparator.compare(current.getForward(i).getElement(), element) <= 0) {
                current = current.getForward(i);
            }
            update[i] = current;
        }

        current = current.getForward(0);

        if (current == null || comparator.compare(current.getElement(), element) != 0) {
            int newLevel = randomLevel();
            if (newLevel > level) {
                for (int i = level + 1; i < newLevel + 1; i++) {
                    update[i] = head;
                }
                level = newLevel;
            }
            Node<T> newNode = createNode(element, newLevel);
            for (int i = 0; i <= newLevel; i++) {
                newNode.setForward(i, update[i].getForward(i));
                update[i].setForward(i, newNode);
            }
        }
    }

    public T removeHead() {
        return deleteElement(head.getForward(0).getElement());
    }

    private T deleteElement(T element) {
        Node<T> current = head;
        Node<T>[] update = new Node[MAX_LEVEL + 1];
        for (int i = level; i >= 0; i--) {
            while (current.getForward(i) != null && comparator.compare(current.getForward(i).getElement(), element) < 0) {
                current = current.getForward(i);
            }
            update[i] = current;
        }
        current = current.getForward(0);
        if (current != null && comparator.compare(current.getElement(), element) == 0) {
            for (int i = 0; i <= level; i++) {
                if (update[i].getForward(i) != current) {
                    break;
                }
                update[i].setForward(i, current.getForward(i));
            }
            while (level > 0 && head.getForward(level) == null) {
                level--;
            }
            return current.getElement();
        }
        return null;
    }

    public T peek() {
        return head.getForward(0).getElement();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private Node<T> current;
        private Node<T> next;

        public MyIterator() {
            this.current = head;
            this.next = head.getForward(0);
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            T element = next.getElement();
            current = next;
            next = next.getForward(0);
            return element;
        }

        @Override
        public void remove() {
            deleteElement(current.getElement());
        }
    }
}
