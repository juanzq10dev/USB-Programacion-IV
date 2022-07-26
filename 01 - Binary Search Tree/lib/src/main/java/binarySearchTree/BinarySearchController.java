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

                if (!node.isComplete()) {
                    nonCompleteNodeFound = true;
                }

                queue.add(node.getLeftNode());
                queue.add(node.getRightNode());
            }

        }

        return true;
    }
}
