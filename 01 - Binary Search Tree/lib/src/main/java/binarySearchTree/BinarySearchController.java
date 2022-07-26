package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchController {
    public static boolean isFull(BinarySearchTree tree) {
        Node root = tree.getRootNode();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

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

    public static boolean isPathologic(BinarySearchTree tree) {
        Node root = tree.getRootNode();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
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

    public static boolean isComplete(BinarySearchTree tree) {
        Node root = tree.getRootNode();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean nonCompleteNodeFound = false;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

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

    public static boolean isPerfect(BinarySearchTree binarySearchTree) {
        Node root = binarySearchTree.getRootNode();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leafNodeFound = false;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

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
}
