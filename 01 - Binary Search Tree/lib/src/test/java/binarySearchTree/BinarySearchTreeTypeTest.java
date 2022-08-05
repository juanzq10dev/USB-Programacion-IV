package binarySearchTree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTreeTypeTest {
    @Test
    public void isFull_FullBinaryTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-1);
        tree.add(5);
        tree.add(2);
        tree.add(6);

        assertTrue(BinarySearchTreeType.isFull(tree));
    }

    @Test
    public void isFull_NonFullBinaryTree_False() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-1);
        tree.add(5);
        tree.add(2);

        assertFalse(BinarySearchTreeType.isFull(tree));
    }

    @Test
    public void isPathologic_PathologicTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-1);
        tree.add(-2);
        tree.add(-4);

        assertTrue(BinarySearchTreeType.isPathologic(tree));
    }

    @Test
    public void isPathologic_NonPathologicTree_False() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-1);
        tree.add(2);
        tree.add(-4);
        tree.add(5);

        assertFalse(BinarySearchTreeType.isPathologic(tree));
    }

    @Test
    public void isComplete_PerfectBinaryTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-5);
        tree.add(-6);
        tree.add(-3);
        tree.add(5);
        tree.add(2);
        tree.add(6);

        assertTrue(BinarySearchTreeType.isComplete(tree));
    }

    @Test
    public void isComplete_NotAllCompletedNodesAtTheEnd_False() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(4);
        tree.add(1);

        assertFalse(BinarySearchTreeType.isComplete(tree));
    }

    @Test
    public void isComplete_MostNodesToTheLeft_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-2);
        tree.add(5);
        tree.add(-1);
        tree.add(-4);

        assertTrue(BinarySearchTreeType.isComplete(tree));
    }

    @Test
    public void isComplete_MostNodesToTheRight_False() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-1);
        tree.add(5);
        tree.add(2);
        tree.add(6);

        assertFalse(BinarySearchTreeType.isComplete(tree));
    } 
    
    @Test
    public void isPerfect_PerfectBinaryTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-5);
        tree.add(-6);
        tree.add(-3);
        tree.add(5);
        tree.add(2);
        tree.add(6);

        assertTrue(BinarySearchTreeType.isPerfect(tree));
    }

    @Test
    public void isPerfect_NonPerfectBinaryTree_False() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-1);
        tree.add(5);
        tree.add(2);

        assertFalse(BinarySearchTreeType.isPerfect(tree));
    }

    @Test
    public void isPerfect_OneChildAtLastLevel_False() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-5);
        tree.add(-3);
        tree.add(5);
        tree.add(2);
        tree.add(6);

        assertFalse(BinarySearchTreeType.isPerfect(tree));
    }

    @Test
    public void isBalanced_BalancedBinaryTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-1);
        tree.add(5);
        tree.add(2);
        tree.add(6);

        assertTrue(BinarySearchTreeType.isBalanced(tree));
    }

    @Test
    public void isBalanced_UnbalancedBinaryTree_False() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-1);
        tree.add(5);
        tree.add(2);
        tree.add(6);
        tree.add(7);

        assertFalse(BinarySearchTreeType.isBalanced(tree));
    }
}
