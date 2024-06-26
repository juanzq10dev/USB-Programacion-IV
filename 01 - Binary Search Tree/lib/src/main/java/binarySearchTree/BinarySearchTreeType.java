package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeType {
    public static<T extends Comparable<T>> boolean isFull(BinarySearchTree<T> tree) {
        Node<T> root = tree.getRootNode();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();

            if (node != null) {
                if (node.isLeafNode()) {
                    continue;
                }
                
                if (node.getLeftNode() == null || node.getRightNode() == null) {
                    return false;
                }
                queue.add(node.getLeftNode());
                queue.add(node.getRightNode());
            }
        }
        return true;
    }

    public static<T extends Comparable<T>> boolean isPathologic(BinarySearchTree<T> tree) {
        Node<T> root = tree.getRootNode();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            if (node != null) {

                if (node.getLeftNode() != null && node.getRightNode() != null) {
                    return false;
                }

                queue.add(node.getLeftNode());
                queue.add(node.getRightNode());
            }
        }

        return true;
    }

    public static<T extends Comparable<T>> boolean isComplete(BinarySearchTree<T> tree) {
        Node<T> root = tree.getRootNode();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        boolean nonCompleteNodeFound = false;

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();

            if (node != null) {
                if (nonCompleteNodeFound && (node.getLeftNode() != null || node.getRightNode() != null)) {
                    return false;
                }

                if (node.getLeftNode() == null && node.getRightNode() != null) {
                    return false;
                }

                if (!node.hasTwoChildren()) {
                    nonCompleteNodeFound = true;
                }

                queue.add(node.getLeftNode());
                queue.add(node.getRightNode());
            }

        }
        return true;
    }

    public static<T extends Comparable<T>> boolean isPerfect(BinarySearchTree<T> binarySearchTree) {
        Node<T> root = binarySearchTree.getRootNode();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        boolean leafNodeFound = false;

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();

            if (node != null) {
                if (node.getLeftNode() != null && node.getRightNode() != null) {
                    if (leafNodeFound) {
                        return false;
                    } else {
                        queue.add(node.getLeftNode());
                        queue.add(node.getRightNode());
                    }
                }

                if (node.isLeafNode()) {
                    leafNodeFound = true;
                }

                if (node.hasOneChildren()) {
                    return false;
                }

            }
        }
        return true;
    }

    public static<T extends Comparable<T>> boolean isBalanced(BinarySearchTree<T> binarySearchTree) {
        Node<T> root = binarySearchTree.getRootNode();
        int leftHeight = binarySearchTree.getHeightFrom(root.getLeftNode());
        int rightHeight = binarySearchTree.getHeightFrom(root.getRightNode());

        return Math.abs(leftHeight - rightHeight) <= 1;
    }
}
