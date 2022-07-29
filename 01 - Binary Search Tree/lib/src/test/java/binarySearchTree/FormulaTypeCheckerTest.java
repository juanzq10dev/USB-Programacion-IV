package binarySearchTree;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FormulaTypeCheckerTest {
    @Test
    public void fullBinaryTreeFormulaIsValid_FullBinaryTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(-1);
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);

        assertTrue(FormulaTypeChecker.fullBinaryTreeFormulaIsValid(tree));
    }

    @Test
    public void pathologicBinaryTreeFormulaIsValid_PathologicalBinaryTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(-1);
        tree.insert(-2);
        tree.insert(-4);

        boolean result = FormulaTypeChecker.pathologicBinaryTreeFormulaIsValid(tree);
        assertTrue(result);
    }

    @Test
    public void perfectBinaryTreeFormulaIsValid_PerfectBinaryTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(-5);
        tree.insert(-6);
        tree.insert(-3);
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);

        assertTrue(FormulaTypeChecker.perfectBinaryTreeFormulaIsValid(tree));
    }
}