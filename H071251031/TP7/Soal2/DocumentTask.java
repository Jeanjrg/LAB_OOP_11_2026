package TP7.Soal2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class DocumentTask implements Runnable {
    private final String fileName;
    private final Map<String, Integer> hasil;
    private final Map<String, String> threadHandler;
    private final Map<String, Long> durasiProses;
    private final CountDownLatch latch;

    public DocumentTask(
            String fileName,
            ConcurrentHashMap<String, Integer> hasil, 
            ConcurrentHashMap<String, String> threadHandler,
            ConcurrentHashMap<String, Long> durasiProses,
            CountDownLatch latch
    ) {
        this.fileName = fileName;
        this.hasil = hasil;
        this.threadHandler = threadHandler;
        this.durasiProses = durasiProses;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            DataProcessor processor = new DataProcessor();
            long start = System.currentTimeMillis();
            int jumlahKata = processor.process(fileName);
            long end = System.currentTimeMillis();
            long durasi = end - start;

            hasil.put(fileName, jumlahKata);
            threadHandler.put(fileName, Thread.currentThread().getName());
            durasiProses.put(fileName, durasi);

            System.out.println("[" + Thread.currentThread().getName() + "] Selesai memproses " 
                                + fileName + " (" + jumlahKata + " kata)");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}