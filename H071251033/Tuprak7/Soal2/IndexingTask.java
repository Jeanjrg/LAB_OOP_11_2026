package H071251033.Tuprak7.Soal2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class IndexingTask implements Runnable {
    private final String fileName;
    private final DataProcessor processor;
    private final ConcurrentHashMap<String, Integer> results;
    private final ConcurrentHashMap<String, Long> durations;
    private final ConcurrentHashMap<String, String> threadNames;
    private final CountDownLatch latch;

    public IndexingTask(String fileName, DataProcessor processor,
                        ConcurrentHashMap<String, Integer> results,
                        ConcurrentHashMap<String, Long> durations,
                        ConcurrentHashMap<String, String> threadNames,
                        CountDownLatch latch) {
        this.fileName = fileName;
        this.processor = processor;
        this.results = results;
        this.durations = durations;
        this.threadNames = threadNames;
        this.latch = latch;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        try {
            int wordCount = processor.process(fileName);
            long duration = System.currentTimeMillis() - startTime;

            results.put(fileName, wordCount);
            durations.put(fileName, duration);
            threadNames.put(fileName, Thread.currentThread().getName());

            System.out.println("[" + Thread.currentThread().getName() +
                    "] Selesai memproses " + fileName +
                    " (" + wordCount + " kata)");
        } finally {
            latch.countDown();
        }
    }
}