package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchController{
    public static boolean isFull(BinarySearchTree tree) {
        Node root = tree.getRootNode();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node != null) {
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
}
