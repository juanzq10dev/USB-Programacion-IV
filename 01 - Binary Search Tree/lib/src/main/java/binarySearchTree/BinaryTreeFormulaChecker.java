package binarySearchTree;

public class BinaryTreeFormulaChecker {
    public static<T extends Comparable<T>> boolean fullTreeFormulaIsValid(BinarySearchTree<T> binarySearchTree) {
        if (!BinarySearchTreeType.isFull(binarySearchTree)) {
            throw new IllegalArgumentException("Binary search tree is not full");
        }

        int leafNodes = binarySearchTree.countLeafNodes();
        int internalNodes = binarySearchTree.countInternalNodes();
        return leafNodes == internalNodes + 1;
    }

    public static<T extends Comparable<T>> boolean perfectTreeFormulaIsValid(BinarySearchTree<T> binarySearchTree) {
        if (!BinarySearchTreeType.isFull(binarySearchTree)) {
            throw new IllegalArgumentException("Binary search tree is not full");
        }

        int totalElements = binarySearchTree.getTotalElements();
        int height = binarySearchTree.getHeight();
        return totalElements == Math.pow(2, height) - 1;
    }

    public static<T extends Comparable<T>> boolean pathologicTreeFormulaIsValid(BinarySearchTree<T> binarySearchTree) {
        if (!BinarySearchTreeType.isPathologic(binarySearchTree)) {
            throw new IllegalArgumentException("Binary search tree is not pathologic");
        }

        int height = binarySearchTree.getHeight();
        int totalElements = binarySearchTree.getTotalElements();
        return height == totalElements;
    }
}
