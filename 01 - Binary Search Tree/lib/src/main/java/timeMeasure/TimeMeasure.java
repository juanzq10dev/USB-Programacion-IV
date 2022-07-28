package timeMeasure;

public class TimeMeasure {
    public static long measure(Runnable runnable) throws InterruptedException {
        long initTime = System.currentTimeMillis();
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
        long endTime = System.currentTimeMillis();
        return endTime - initTime;
    }

    public static long millisToSeconds(long millis) {
        return millis / 1000;
    }

    public static long millisToMinutes(long millis) {
        return millisToSeconds(millis) / 60;
    }
}
