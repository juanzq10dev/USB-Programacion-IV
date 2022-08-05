package binarySearchTree;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FormulaTypeCheckerTest {
    @Test
    public void fullBinaryTreeFormulaIsValid_FullBinaryTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-1);
        tree.add(5);
        tree.add(2);
        tree.add(6);

        assertTrue(FormulaTypeChecker.fullBinaryTreeFormulaIsValid(tree));
    }

    @Test
    public void pathologicBinaryTreeFormulaIsValid_PathologicalBinaryTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-1);
        tree.add(-2);
        tree.add(-4);

        boolean result = FormulaTypeChecker.pathologicBinaryTreeFormulaIsValid(tree);
        assertTrue(result);
    }

    @Test
    public void perfectBinaryTreeFormulaIsValid_PerfectBinaryTree_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(1);
        tree.add(-5);
        tree.add(-6);
        tree.add(-3);
        tree.add(5);
        tree.add(2);
        tree.add(6);

        assertTrue(FormulaTypeChecker.perfectBinaryTreeFormulaIsValid(tree));
    }
}
