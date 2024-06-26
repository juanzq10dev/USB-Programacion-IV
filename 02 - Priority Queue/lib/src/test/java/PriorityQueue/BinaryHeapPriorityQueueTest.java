package PriorityQueue;

import Person.Person;
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
    void enqueueAndDequeue_EnqueueRepeatedElements_ElementsAreAdded() {
        BinaryHeapPriorityQueue<String> fruitList = new BinaryHeapPriorityQueue<String>(true);
        fruitList.enqueue("banana");
        fruitList.enqueue("carrot");
        fruitList.enqueue("apple");
        fruitList.enqueue("potato");
        fruitList.enqueue("banana");
        fruitList.enqueue("carrot");

        String actualFirstDequeued = fruitList.dequeue();
        String actualSecondDequeued = fruitList.dequeue();
        String actualThirdDequeued = fruitList.dequeue();
        String actualFourthDequeued = fruitList.dequeue();
        String actualFifthDequeued = fruitList.dequeue();
        String actualSixthDequeued = fruitList.dequeue();
        String expectedFirstDequeued = "apple";
        String expectedSecondDequeued = "banana";
        String expectedThirdDequeued = "banana";
        String expectedFourthDequeued = "carrot";
        String expectedFifthDequeued = "carrot";
        String expectedSixthDequeued = "potato";

        assertEquals(expectedFirstDequeued, actualFirstDequeued);
        assertEquals(expectedSecondDequeued, actualSecondDequeued);
        assertEquals(expectedThirdDequeued, actualThirdDequeued);
        assertEquals(expectedFourthDequeued, actualFourthDequeued);
        assertEquals(expectedFifthDequeued, actualFifthDequeued);
        assertEquals(expectedSixthDequeued, actualSixthDequeued);
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

    @Test
    void queue_bankProve_PriorityListIsOrdered() {
        BinaryHeapPriorityQueue<Person> bankList = new BinaryHeapPriorityQueue<Person>(true);
        Person john = new Person("John", "1980-05-01", "1213");
        Person jane = new Person("Jane", "1973-05-01", "1213");
        Person jill = new Person("Jill", "1982-05-01", "1213");
        Person jack = new Person("Jack", "1970-05-01", "1213");
        Person jake = new Person("Jake", "1983-05-01", "1213");

        bankList.enqueue(john);
        bankList.enqueue(jane);
        bankList.enqueue(jill);
        bankList.enqueue(jack);
        bankList.enqueue(jake);

        Person expected1 = bankList.dequeue();
        Person expected2 = bankList.dequeue();
        Person expected3 = bankList.dequeue();
        Person expected4 = bankList.dequeue();
        Person expected5 = bankList.dequeue();

        assertEquals(expected1, jack);
        assertEquals(expected2, jane);
        assertEquals(expected3, john);
        assertEquals(expected4, jill);
        assertEquals(expected5, jake);
    }

    @Test
    void queue_BankProveWithCI_PriorityListIsOrdered() {
        BinaryHeapPriorityQueue<Person> bankList = new BinaryHeapPriorityQueue<Person>(true);
        Person john = new Person("John", "1980-05-01", "1213");
        Person jane = new Person("Jane", "1980-05-01", "1214");
        Person jill = new Person("Jill", "1980-05-01", "1212");
        Person jack = new Person("Jack", "1980-05-01", "1215");
        Person jake = new Person("Jake", "1980-05-01", "1211");

        bankList.enqueue(john);
        bankList.enqueue(jane);
        bankList.enqueue(jill);
        bankList.enqueue(jack);
        bankList.enqueue(jake);

        Person expected1 = bankList.dequeue();
        Person expected2 = bankList.dequeue();
        Person expected3 = bankList.dequeue();
        Person expected4 = bankList.dequeue();
        Person expected5 = bankList.dequeue();

        assertEquals(expected1, jack);
        assertEquals(expected2, jane);
        assertEquals(expected3, john);
        assertEquals(expected4, jill);
        assertEquals(expected5, jake);
    }
}