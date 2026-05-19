import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class IndexingTask implements Runnable {
    private final String fileName;
    private final DataProcessor processor;
    private final ConcurrentHashMap<String, String> results;
    private final CountDownLatch latch;
    private final long startTime;

    public IndexingTask(String fileName, DataProcessor processor, 
                        ConcurrentHashMap<String, String> results, CountDownLatch latch) {
        this.fileName = fileName;
        this.processor = processor;
        this.results = results;
        this.latch = latch;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        try {
            int wordCount = processor.process(fileName);
            long duration = System.currentTimeMillis() - startTime;

            String info = String.format("%d kata | %d ms | %s", 
                          wordCount, duration, Thread.currentThread().getName());
            results.put(fileName, info);

            System.out.printf("[%s] Selesai memproses %s (%d kata).\n", 
                              Thread.currentThread().getName(), fileName, wordCount); 

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}
