package binarySearchTree;

public class FormulaTypeChecker  {
    public static boolean fullBinaryTreeFormulaIsValid(BinarySearchTree binarySearchTree) {
        if (!BinarySearchTreeType.isFull(binarySearchTree)) {
            throw new IllegalArgumentException("Binary search tree is not full");
        }

        int leafNodes = binarySearchTree.countLeafNodes();
        int internalNodes = binarySearchTree.countInternalNodes();
        return leafNodes == internalNodes + 1;
    }

    public static boolean perfectBinaryTreeFormulaIsValid(BinarySearchTree binarySearchTree) {
        if (!BinarySearchTreeType.isFull(binarySearchTree)) {
            throw new IllegalArgumentException("Binary search tree is not full");
        }

        int totalElements = binarySearchTree.getTotalElements();
        int height = binarySearchTree.getHeight();
        return totalElements == Math.pow(2, height) - 1;
    }

    public static boolean pathologicBinaryTreeFormulaIsValid(BinarySearchTree binarySearchTree) {
        if (!BinarySearchTreeType.isPathologic(binarySearchTree)) {
            throw new IllegalArgumentException("Binary search tree is not pathologic");
        }

        int height = binarySearchTree.getHeight();
        int totalElements = binarySearchTree.getTotalElements();
        return height == totalElements;
    }

    

}
