package binarySearchTree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchControllerTest {
    @Test
    public void isFull_FullBinaryTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(-1);
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);

        assertTrue(BinarySearchController.isFull(tree));
    }

    @Test
    public void isFull_NonFullBinaryTree_False() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(-1);
        tree.insert(5);
        tree.insert(2);

        assertFalse(BinarySearchController.isFull(tree));
    }
}
