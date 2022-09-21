package Multi.Threading.Merge.Sort;

import java.util.Random;

import org.junit.Test;

import Multi.Threading.Merge.TimeMeasure.TimeMeasure;

public class MultiThreadingMergeSortTest {

    @Test
    public void testSort() {
        Integer[] a = new Integer[10000000];
        Random rd = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rd.nextInt();
        }

        TimeMeasure.measure(() -> {
                MultiThreadingMergeSort.threadedSort(a);
        });
    }

    @Test
    public void ntestSort() {
        Integer[] a = new Integer[10000000];
        Random rd = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rd.nextInt();
        }
        TimeMeasure.measure(() -> {
            Mergesort.sort(a);
        });
    }
}
