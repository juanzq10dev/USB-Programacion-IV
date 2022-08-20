package TimeMeasure;

import Person.Person;

import PriorityQueue.LinkedListPriorityQueue;
import PriorityQueue.PriorityQueue;
import PriorityQueue.BinaryHeapPriorityQueue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeMeasureTest {

    @ParameterizedTest
    @ValueSource(ints = {800000, 600000, 400000, 200000, 100000, 80000, 60000, 40000, 20000, 10000, 5000, 2000, 1000, 500})
    void measure_LinkedListPriorityQueue_Enqueue(int max) {
        PriorityQueue<Person> personList = new LinkedListPriorityQueue<Person>();

        System.out.print("LinkedListPriorityQueue Enqueue " + max + " elements: " );
        TimeMeasure.measure(() -> {
            for (int i = 0; i < max; i++) {
                int value = (int) Math.floor(Math.random() * (max * 10 + 1));
                personList.enqueue(new Person("John", "1970-06-07", value + "" ));
            }
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {10000000, 800000, 600000, 400000, 200000, 100000, 80000, 60000, 40000, 20000, 10000, 5000, 2000, 1000, 500})
    void measure_BinaryHeapPriorityQueue_Enqueue(int max) {
        PriorityQueue<Person> personList = new BinaryHeapPriorityQueue<Person>(true);

        System.out.print("Binary Heap Enqueue " + max + " elements: " );
        TimeMeasure.measure(() -> {
            for (int i = 0; i < max; i++) {
                int value = (int) Math.floor(Math.random() * (max + 1));
                personList.enqueue(new Person("John", "1970-06-07", value + "" ));
            }
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {800000, 600000, 400000, 200000, 100000, 80000, 60000, 40000, 20000, 10000, 5000, 2000, 1000, 500})
    void measure_LinkedListPriorityQueue_Dequeue(int max) {
        PriorityQueue<Person> personList = new LinkedListPriorityQueue<Person>();
        for (int i = 0; i < max; i++) {
            int value = (int) Math.floor(Math.random() * (max * 10 + 1));
            personList.enqueue(new Person("John", "1970-06-07", value + ""));
        }

        System.out.print("LinkedListPriorityQueue Dequeue " + max + " elements: " );
        TimeMeasure.measure(() -> {
            for (int i = 0; i < max; i++) {
                personList.dequeue();
            }
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {10000000, 800000, 600000, 400000, 200000, 100000, 80000, 60000, 40000, 20000, 10000, 5000, 2000, 1000, 500})
    void measure_BinaryHeapPriorityQueue_Dequeue(int max) {
        PriorityQueue<Person> personList = new BinaryHeapPriorityQueue<Person>(true);
        for (int i = 0; i < max; i++) {
            int value = (int) Math.floor(Math.random() * (max * 10 + 1));
            personList.enqueue(new Person("John", "1970-06-07", value + ""));
        }

        System.out.print("BinaryHeapPriorityQueue Dequeue " + max + " elements: " );
        TimeMeasure.measure(() -> {
            for (int i = 0; i < max; i++) {
                personList.dequeue();
            }
        });
    }
}