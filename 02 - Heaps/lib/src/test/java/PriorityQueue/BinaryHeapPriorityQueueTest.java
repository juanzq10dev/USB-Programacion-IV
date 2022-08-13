package PriorityQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapPriorityQueueTest {

    @Test
    void enqueue_EnqueueStrings_HeadIsOrdered() {
        BinaryHeapPriorityQueue<String> fruitList = new BinaryHeapPriorityQueue<String>(true);
        fruitList.enqueue("banana");
        fruitList.enqueue("carrot");
        fruitList.enqueue("apple");

        String result = fruitList.peek();
        String expected = "apple";
        assertEquals(expected, result);
    }

    @Test
    void dequeue_DequeueTwoElements_ElementsAreDequeued() {
        BinaryHeapPriorityQueue<String> fruitList = new BinaryHeapPriorityQueue<String>(true);
        fruitList.enqueue("banana");
        fruitList.enqueue("carrot");
        fruitList.enqueue("apple");

        String actualFirstDequeued = fruitList.dequeue();
        String actualSecondDequeued = fruitList.dequeue();
        String actualHead = fruitList.peek();
        String expectedFirstDequeued = "apple";
        String expectedSecondDequeued = "banana";
        String expectedHead = "carrot";

        assertEquals(expectedFirstDequeued, actualFirstDequeued);
        assertEquals(expectedSecondDequeued, actualSecondDequeued);
        assertEquals(expectedHead, actualHead);
    }

    @Test
    void peek_PeekingTwice_TheHeadDoesNotChange() {
        BinaryHeapPriorityQueue<String> fruitList = new BinaryHeapPriorityQueue<String>(true);
        fruitList.enqueue("banana");
        fruitList.enqueue("carrot");
        fruitList.enqueue("apple");

        String firstPeek = fruitList.peek();
        String secondPeek = fruitList.peek();
        String expectedFirstPeek = "apple";
        String expectedSecondPeek = "apple";
        assertEquals(expectedFirstPeek, firstPeek);
        assertEquals(expectedSecondPeek, secondPeek);
    }

    @Test
    void iterate_Iterate_TheHeadDoesNotChange() {
        BinaryHeapPriorityQueue<String> fruitList = new BinaryHeapPriorityQueue<String>(true);
        fruitList.enqueue("banana");
        fruitList.enqueue("carrot");
        fruitList.enqueue("apple");

        String expectedString = "carrot";
        String actualString = "";
        for (String s : fruitList) {
            actualString = s;
        }

        String actualHead = fruitList.peek();
        String expectedHead = "apple";

        assertEquals(expectedString, actualString);
        assertEquals(expectedHead, actualHead);
    }
}