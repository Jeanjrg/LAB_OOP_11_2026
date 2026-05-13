package H071251033.Tuprak7.Soal2;

import java.util.Random;

public class DataProcessor {
    private final Random random = new Random();

    public int process(String fileName) {
        try {
            int duration = 500 + random.nextInt(1501);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return 50 + random.nextInt(451);
    }
}