package Multi.Threading.Merge.TimeMeasure;

public class TimeMeasure {
    public static void measure(Executable executable) {
        long initTime = System.nanoTime();
        executable.execute();
        long endTime = System.nanoTime();
        System.out.println(nanoToMillis(endTime - initTime) + " ms");
    }

    private static double nanoToMillis(long nanoTime) {
        return roundWithToDecimals(nanoTime / 1000000.0);
    }

    private static double roundWithToDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
