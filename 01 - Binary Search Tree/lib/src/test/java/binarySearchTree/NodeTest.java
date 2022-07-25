package binarySearchTree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NodeTest {
    @Test
    public void equals_SameNodes_True() {
        Node<String> node = new Node<>("John");
        Node<String> node2 = new Node<>("John");
        assertTrue(node.equals(node2));
    }

    @Test
    public void equals_SameNodesWithSameChild_True() {
        Node<String> rootNode1 = new Node<>("John");
        Node<String> carlos = new Node<>("Carlos");
        Node<String> pedro = new Node<>("Pedro");
        Node<String> brandon = new Node<>("Brandon");
        rootNode1.setLeftNode(brandon);
        rootNode1.setRightNode(pedro);
        brandon.setRightNode(carlos);

        Node<String> rootNode2 = new Node<>("John");
        Node<String> carlos2 = new Node<>("Carlos");
        Node<String> pedro2 = new Node<>("Pedro");
        Node<String> brandon2 = new Node<>("Brandon");
        rootNode2.setLeftNode(brandon2);
        rootNode2.setRightNode(pedro2);
        brandon2.setRightNode(carlos2);

        assertTrue(rootNode1.equals(rootNode2));
    }

    @Test
    public void equals_DifferentNodes_False() {
        Node<String> node = new Node<>("John");
        Node<String> node2 = new Node<>("Brandon");
        assertTrue(!node.equals(node2));
    }

    @Test
    public void equals_SameNodesWithDifferentChild_False() {
        Node<String> rootNode1 = new Node<>("John");
        Node<String> carlos = new Node<>("Carlos");
        Node<String> pedro = new Node<>("Pedro");
        Node<String> brandon = new Node<>("Brandon");
        rootNode1.setLeftNode(brandon);
        rootNode1.setRightNode(pedro);
        brandon.setRightNode(carlos);

        Node<String> rootNode2 = new Node<>("John");
        Node<String> carlos2 = new Node<>("Carlos");
        Node<String> pedro2 = new Node<>("Pedro");
        Node<String> brandon2 = new Node<>("Brandon");
        rootNode2.setLeftNode(brandon2);
        rootNode2.setRightNode(pedro2);
        brandon2.setLeftNode(carlos2);

        assertFalse(rootNode1.equals(rootNode2));
    }
}
