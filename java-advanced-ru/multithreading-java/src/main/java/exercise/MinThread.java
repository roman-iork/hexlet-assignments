package exercise;

// BEGIN
import java.util.Arrays;

public class MinThread extends Thread {
    private int min;
    private int[] numbers;

    public int getMin() {
        return min;
    }

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        min = Arrays.stream(numbers).min().getAsInt();
    }
}
// END
