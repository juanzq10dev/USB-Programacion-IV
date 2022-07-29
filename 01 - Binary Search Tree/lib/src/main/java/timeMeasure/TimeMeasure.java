package timeMeasure;

public class TimeMeasure {
    public static void measure(Runnable runnable) {
        long initTime = System.currentTimeMillis();
        runnable.run();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - initTime);
    }

    public static long millisToSeconds(long millis) {
        return millis / 1000;
    }

    public static long millisToMinutes(long millis) {
        return millisToSeconds(millis) / 60;
    }
}
