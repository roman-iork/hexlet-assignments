package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        var result = new HashMap<String, Integer>();
        var minThread = new MinThread(numbers);
        var maxThread = new MaxThread(numbers);
        LOGGER.log(Level.INFO, String.format("Thread %s started", minThread.getName()));
        minThread.start();
        LOGGER.log(Level.INFO, String.format("Thread %s started", maxThread.getName()));
        maxThread.start();
        try {
            minThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.log(Level.INFO, String.format("Thread %s finished", minThread.getName()));
        try {
            maxThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.log(Level.INFO, String.format("Thread %s finished", maxThread.getName()));
        var min = minThread.getMin();
        var max = maxThread.getMax();
        result.put("min", min);
        result.put("max", max);
        return result;
    }
    // END
}
