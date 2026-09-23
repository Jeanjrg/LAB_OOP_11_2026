import java.util.Random;

public class DataProcessor {
    public int process(String fileName) throws InterruptedException {
        Random random = new Random();
        int duration = 500 + random.nextInt(1501); 
        Thread.sleep(duration);
        return 50 + random.nextInt(451);
    }
} 