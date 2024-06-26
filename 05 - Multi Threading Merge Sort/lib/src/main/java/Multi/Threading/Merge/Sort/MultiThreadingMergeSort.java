package Multi.Threading.Merge.Sort;

import java.util.ArrayList;

public class MultiThreadingMergeSort {
    final static int MAX_THREADS = 4;

    private static class SortThreads extends Thread {
        SortThreads(Integer[] array, int begin, int end) {
            super(() -> {
                Mergesort.sort(array, begin, end);
            });
            this.start();
        }
    }

    public static void threadedSort(Integer[] array) {
        final int length = array.length;
        boolean exact = length % MAX_THREADS == 0;
        int maxlim = exact ? length / MAX_THREADS : length / (MAX_THREADS - 1);
        maxlim = maxlim < MAX_THREADS ? MAX_THREADS : maxlim;
        final ArrayList<SortThreads> threads = new ArrayList<>();

        for (int i = 0; i < length; i += maxlim) {
            int beg = i;
            int remain = (length) - i;
            int end = remain < maxlim ? i + (remain - 1) : i + (maxlim - 1);
            final SortThreads t = new SortThreads(array, beg, end);
            threads.add(t);
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException ignored) {
            }
        }

        for (int i = 0; i < length; i += maxlim) {
            int mid = i == 0 ? 0 : i - 1;
            int remain = (length) - i;
            int end = remain < maxlim ? i + (remain - 1) : i + (maxlim - 1);
            Mergesort.merge(array, 0, mid, end);
        }
    }

}
