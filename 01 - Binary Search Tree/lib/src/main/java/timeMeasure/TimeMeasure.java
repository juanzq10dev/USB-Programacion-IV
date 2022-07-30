package timeMeasure;

public class TimeMeasure {
    public static void measure(Runnable runnable) {
        long initTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        System.out.println(nanoToMillis(endTime - initTime));
    }

    private static double nanoToMillis(long nanoTime) {
        return roundWithToDecimals(nanoTime / 1000000.0);
    }

    private static double roundWithToDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
