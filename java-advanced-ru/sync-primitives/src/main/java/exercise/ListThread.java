package exercise;

import java.util.stream.IntStream;

// BEGIN
public class ListThread extends Thread {
    private SafetyList safetyList;

    public ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, 1000).forEach(n -> {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            safetyList.add(n);
        });
    }
}
// END
