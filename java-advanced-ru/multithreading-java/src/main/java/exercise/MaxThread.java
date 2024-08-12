package exercise;

// BEGIN

import java.util.Arrays;

public class MaxThread extends Thread {
    private int max;
    private int[] numbers;

    public int getMax() {
        return max;
    }

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        max = Arrays.stream(numbers).max().getAsInt();
    }
}
// END
