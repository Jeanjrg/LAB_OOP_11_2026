import java.util.Random;

public class DataProcessor {
    private Random random;

    public DataProcessor() {
        this.random = new Random();
    }

    public int process(String fileName) {
        try {
            
            Thread.sleep(500 + this.random.nextInt(1501));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        return 100 + this.random.nextInt(401);
    }
}