package Btree;

public class BPlusTree<T extends Comparable<T>> implements BTree<T> {
    private int size;
    private int range;
    private Node<T> root;

    public BPlusTree(int range) {
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
    public void insertAll(T[] values) {
        for (T value : values) {
            insert(value);
        }
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
        return this.root.getKey();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean removeAll(T[] nodes) {
        // TODO Auto-generated method stub
        return false;
    }
}
