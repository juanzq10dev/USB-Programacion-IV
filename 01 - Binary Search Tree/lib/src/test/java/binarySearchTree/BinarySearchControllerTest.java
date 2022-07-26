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

    @Test
    public void isPathologic_PathologicTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(-1);
        tree.insert(-2);
        tree.insert(-4);

        assertTrue(BinarySearchController.isPathologic(tree));
    }

    @Test
    public void isPathologic_NonPathologicTree_False() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(-1);
        tree.insert(2);
        tree.insert(-4);
        tree.insert(5);

        assertFalse(BinarySearchController.isPathologic(tree));
    }

    @Test
    public void isComplete_PerfectBinaryTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(-5);
        tree.insert(-6);
        tree.insert(-3);
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);

        assertTrue(BinarySearchController.isComplete(tree));
    }

    @Test
    public void isComplete_NotAllCompletedNodesAtTheEnd_False() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(4);
        tree.insert(1);

        assertFalse(BinarySearchController.isComplete(tree));
    }

    @Test
    public void isComplete_MostNodesToTheLeft_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(-2);
        tree.insert(5);
        tree.insert(-1);
        tree.insert(-4);

        assertTrue(BinarySearchController.isComplete(tree));
    }

    @Test
    public void isComplete_MostNodesToTheRight_False() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(-1);
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);

        assertFalse(BinarySearchController.isComplete(tree));
    }   
}
