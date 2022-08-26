package Binomial.Heap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class NodeTest {
    @Test
    void merge_MergingNodesFromDifferentDegrees_IllegalArgumentException() {
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);

        node1.merge(node2);

        assertThrows(IllegalArgumentException.class, () -> node1.merge(node3));
    }

    @Test 
    void merge_MergingNodesWithSimilarDegrees_DegreeIncreases() {
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);

        node1.merge(node2);
        node3.merge(node4);
        node1.merge(node3);

        int expected = 2;
        int actual = node1.getDegree();
        assertEquals(expected, actual);
    }

    @Test
    void merge_MergingNodesWithSimilarDegrees_ChildrensAreOrdered() {
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);

        node1.merge(node2);
        node3.merge(node4);
        node1.merge(node3);

        Node<Integer>[] expected = new Node[] {node3, node2};
        Node<Integer>[] actual = node1.getChildren();

        assertArrayEquals(expected, actual);
    }
}
