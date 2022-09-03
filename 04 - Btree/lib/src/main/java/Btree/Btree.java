package Btree;

public class Btree<T extends Comparable<T>> implements Tree<T> {
    private int size;
    private int range;
    private Node<T> root;

    public Btree(int range) {
        this.range = range;
        this.root = new Node<T>(range);
    }

    @Override
    public void insert(T value) {
        if (value != null) {
            Node<T> node = root;
            insert(value, node);
        }
    }

    private void insert(T value, Node<T> node) {
        if (!node.isLeaf()) {
            int index = node.binarySearch(value);
            if (index < 0) {
                index = index * -1 - 1;
                Node<T> child = node.getChild(index);

                if (child == null) {
                    child = new Node<T>(range);
                    node.setChild(index, child);
                }

                insert(value, child);
            }
        } else {
            int ixdexInserted = node.insert(value);

            if (ixdexInserted != -1) {
                if (node.needsSplit()) {
                    split(node);
                }
                size++;
            }
        }
    }

    private void split(Node<T> node) {
        Node<T> parent;

        if (node == root) {
            parent = new Node<T>(range);
            root = parent;
        } else {
            parent = node.getParent();
        }

        parent.insertSplittedNode(node.midKey(), node.leftSide(), node.rigthSide());
        parent.setLeaf(false);

        if (parent.needsSplit()) {
            split(parent);
        }
    }

    @Override
    public void insert(T[] values) {
        for (T value : values) {
            insert(value);
        }
    }

    @Override
    public T find(T value) {
        return find(this.root, value);
    }

    public T find(Node<T> node, T value) {
        int index = node.binarySearch(value);
        if (index < 0) {
            Node<T> child = node.getChild(index * -1 - 1);
            if (child != null) {
                return find(child, value);
            }
            return null;
        } else {
            return node.getKey(index);
        }
    }

    @Override
    public T delete(T value) {
        if (value == null) {
            return null;
        }

        Node<T> nodeWithValue = findNode(this.root, value);
        if (nodeWithValue != null) {
            int indexOfValue = nodeWithValue.binarySearch(value);

            if (nodeWithValue.isLeaf()) {
                T removed = nodeWithValue.removeKey(indexOfValue);
                refactor(nodeWithValue);
                return removed;
            } else {
                Node<T> nodeWithSuccessor = nodeWithValue.inorderSuccessorNode(value);
                T inorderSuccessor = nodeWithSuccessor.pushFirstKey();
                T removed = nodeWithValue.replaceKey(indexOfValue, inorderSuccessor);
                refactor(nodeWithSuccessor);
                return removed;
            }
        }

        return null;
    }

    private void refactor(Node<T> node) {
        if (node.getParent() == null || node.hasExactlyMinKeys() || node.hasMoreThanMinKeys()) {
            return;
        }

        // 2nd case steal brother key
        Node<T> parent = node.getParent();
        int indexInParent = parent.getChild().indexOf(node);
        Node<T> leftBrother = node.getLeftBrother();
        Node<T> rightBrother = node.getRightBrother();

        if (leftBrother != null && leftBrother.hasMoreThanMinKeys()) {
            indexInParent -= 1;
            T parentKey = parent.getKey(indexInParent);
            T leftBrotherKey = leftBrother.removeLast();
            node.insert(parentKey);
            parent.setKey(indexInParent, leftBrotherKey);
            refactor(parent);
            return;
        } else if (rightBrother != null && rightBrother.hasMoreThanMinKeys()) {
            T parentKey = parent.getKey(indexInParent);
            T rightBrotherKey = rightBrother.pushFirstKey();
            node.insert(parentKey);
            parent.setKey(indexInParent, rightBrotherKey);
            refactor(parent);
            return;
        }

        // 3rd case merge brother
        if (leftBrother != null) {
            T parentKey = parent.removeKey(indexInParent - 1);
            leftBrother.insert(parentKey);
            leftBrother.insertAll(node.getKey());
            parent.removeChild(indexInParent);
            if (parent == root && parent.getSize() == 0) {
                root = leftBrother;
            }
            refactor(parent);
        } else if (rightBrother != null) {
            T parentKey = parent.removeKey(indexInParent);
            node.insert(parentKey);
            node.insertAll(rightBrother.getKey());
            parent.removeChild(indexInParent);
            if (parent == root && parent.getSize() == 0) {
                root = node;
            }
            refactor(parent);
        }
    }

    public Node<T> findNode(Node<T> node, T value) {
        int index = node.binarySearch(value);
        if (index < 0) {
            Node<T> child = node.getChild(index * -1 - 1);
            if (child != null) {
                return findNode(child, value);
            }
            return null;
        } else {
            return node;
        }
    }

    @Override
    public int size() {
        return size;
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
        return root.getKey();
    }
}